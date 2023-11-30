/**
 * 
 */
package com.cognizant9.UserProfileService.service;

/**
 * @author mohit
 *
 */
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.cognizant9.UserProfileService.entity.Role;
import com.cognizant9.UserProfileService.entity.User;
import com.cognizant9.UserProfileService.repository.RoleRepository;
import com.cognizant9.UserProfileService.repository.UserRepository;
import com.cognizant9.UserProfileService.service.UserServiceImpl;

public class UserServiceImplTest {

    @Mock
    private UserRepository userRepository;

    @Mock
    private RoleRepository roleRepository;

    @Mock
    private PasswordEncoder passwordEncoder;

    @InjectMocks
    private UserServiceImpl userService;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testRegisterNewUser() {
        User user = new User();
        user.setUserFirstName("John");
        user.setUserLastName("Doe");
        user.setUserName("john123");
        user.setUserPassword("password");
        user.setContactNumber("1234567890");

        Role role = new Role();
        role.setRoleId("1");
        role.setRoleName("User");
        role.setRoleDesc("Default Role for user");

        when(roleRepository.findByRoleName("User")).thenReturn(role);
        when(passwordEncoder.encode("password")).thenReturn("encodedPassword");
        when(userRepository.save(user)).thenReturn(user);

        User savedUser = userService.registerNewUser(user);

        assertEquals("encodedPassword", savedUser.getUserPassword());
        assertEquals("User", savedUser.getRole().iterator().next().getRoleName());

        verify(roleRepository, times(1)).findByRoleName("User");
        verify(passwordEncoder, times(1)).encode("password");
        verify(userRepository, times(1)).save(user);
    }

    @Test
    public void testGetUserByUserName() {
        String userName = "john123";
        User user = new User();
        user.setUserName(userName);

        when(userRepository.findByUserName(userName)).thenReturn(user);

        User foundUser = userService.getUserByUserName(userName);

        assertEquals(userName, foundUser.getUserName());
        verify(userRepository, times(1)).findByUserName(userName);
    }

    @Test
    public void testGetAllUsers() {
        List<User> userList = new ArrayList<>();
        userList.add(new User());
        userList.add(new User());

        when(userRepository.findAll()).thenReturn(userList);

        List<User> foundUsers = userService.getAllUsers();

        assertEquals(2, foundUsers.size());
        verify(userRepository, times(1)).findAll();
    }
 

    @Test
    public void testGetUserByUserName_UserNotFound() {
        String userName = "john123";

        // Mock scenario when the user is not found
        when(userRepository.findByUserName(userName)).thenReturn(null);

        // Attempt to get a user by username that does not exist
        User foundUser = userService.getUserByUserName(userName);

        assertNull(foundUser);

        // Verify that the repository method was called
        verify(userRepository, times(1)).findByUserName(userName);
        verifyNoMoreInteractions(userRepository, roleRepository, passwordEncoder);
    }

    @Test
    public void testGetAllUsers_NoUsersFound() {
        // Mock scenario when no users are found
        when(userRepository.findAll()).thenReturn(null);

        // Attempt to get all users when none exist
        assertNull(userService.getAllUsers());

        // Verify that the repository method was called
        verify(userRepository, times(1)).findAll();
        verifyNoMoreInteractions(userRepository, roleRepository, passwordEncoder);
    }
}
