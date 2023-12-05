/**
 * 
 */
package com.cognizant9.AuthenticationService.repo;

/**
 * @author mohit
 *
 */
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Import;

import com.cognizant9.AuthenticationService.entity.User;
import com.cognizant9.AuthenticationService.repository.UserRepo;

@DataJpaTest
class UserRepoTest {

    @MockBean
    private UserRepo userRepo;

    @Test
    void testFindById() {
        String userName = "john.doe";
        User user = new User(userName, "password", "John", "Doe", userName);

        when(userRepo.findById(userName)).thenReturn(Optional.of(user));

        Optional<User> result = userRepo.findById(userName);

        assertTrue(result.isPresent());
        assertEquals(user, result.get());
    }

    @Test
    void testFindById_NotFound() {
        String userName = "nonexistent.user";

        when(userRepo.findById(userName)).thenReturn(Optional.empty());

        Optional<User> result = userRepo.findById(userName);

        assertFalse(result.isPresent());
    }

    @Test
    void testSave() {
        User user = new User("john.doe", "password", "John", "Doe", "abc");

        when(userRepo.save(user)).thenReturn(user);

        User result = userRepo.save(user);

        assertEquals(user, result);
    }

    @Test
    void testDeleteById() {
        String userName = "john.doe";

        userRepo.deleteById(userName);

        verify(userRepo, times(1)).deleteById(userName);
    }
}

