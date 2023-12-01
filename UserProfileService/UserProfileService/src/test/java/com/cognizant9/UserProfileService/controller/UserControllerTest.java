/**
 * 
 */
package com.cognizant9.UserProfileService.controller;

/**
 * @author mohit
 *
 */
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.cognizant9.UserProfileService.controller.UserController;
import com.cognizant9.UserProfileService.entity.User;
import com.cognizant9.UserProfileService.service.UserService;

public class UserControllerTest {

    @Mock
    private UserService userService;

    @InjectMocks
    private UserController userController;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testRegisterNewUser_Positive() {
        User user = new User();
        user.setUserName("john");
        user.setUserFirstName("John");
        user.setUserLastName("Doe");

        when(userService.registerNewUser(any(User.class))).thenReturn(user);

        ResponseEntity<User> response = userController.registerNewUser(user);

        assertEquals(HttpStatus.CREATED, response.getStatusCode());
        assertEquals(user, response.getBody());

        verify(userService, times(1)).registerNewUser(any(User.class));
        verifyNoMoreInteractions(userService);
    }

    @Test
    public void testGetUserByUserName_Positive() {
        String userName = "john";
        User user = new User();
        user.setUserName(userName);
        user.setUserFirstName("John");
        user.setUserLastName("Doe");

        when(userService.getUserByUserName(userName)).thenReturn(user);

        ResponseEntity<User> response = userController.getUserByUserName(userName);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(user, response.getBody());

        verify(userService, times(1)).getUserByUserName(userName);
        verifyNoMoreInteractions(userService);
    }

    @Test
    public void testGetAllUsers_Negative() {
        when(userService.getAllUsers()).thenReturn(null);

        ResponseEntity<List<User>> response = userController.getAllUsers();

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertNull(response.getBody());

        verify(userService, times(1)).getAllUsers();
        verifyNoMoreInteractions(userService);
    }

    @Test
    public void testGetUserByUserName_Negative() {
        String userName = "John";

        when(userService.getUserByUserName(userName)).thenReturn(null);

        ResponseEntity<User> response = userController.getUserByUserName(userName);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertNull(response.getBody());

        verify(userService, times(1)).getUserByUserName(userName);
        verifyNoMoreInteractions(userService);
    }
}

