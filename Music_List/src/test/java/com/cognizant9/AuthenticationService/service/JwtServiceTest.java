/**
 * 
 */
package com.cognizant9.AuthenticationService.service;

/**
 * @author mohit
 *
 */
//package com.cognizant9.AuthenticationService.service;
//
//import com.cognizant9.AuthenticationService.dao.JwtRequest;
//import com.cognizant9.AuthenticationService.dao.JwtResponse;
//import com.cognizant9.AuthenticationService.entity.User;
//import com.cognizant9.AuthenticationService.repository.UserRepo;
//import com.cognizant9.AuthenticationService.util.JwtUtil;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//import org.mockito.InjectMocks;
//import org.mockito.Mock;
//import org.mockito.MockitoAnnotations;
//import org.springframework.security.authentication.AuthenticationManager;
//import org.springframework.security.authentication.DisabledException;
//import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
//import java.util.Collections;
//import java.util.HashSet;
//import java.util.Set;
//
//import static org.junit.jupiter.api.Assertions.*;
//import static org.mockito.Mockito.*;
//
//class JwtServiceTest {
//
//    @Mock
//    private JwtUtil jwtUtil;
//
//    @Mock
//    private UserRepo userDao;
//
//    @Mock
//    private AuthenticationManager authenticationManager;
//
//    @InjectMocks
//    private JwtService jwtService;
//
//    @BeforeEach
//    void setUp() {
//        MockitoAnnotations.openMocks(this);
//    }
//
//    @Test
//    void testCreateJwtTokenSuccess() throws Exception {
//        // Mocking user data
//        User mockUser = new User("testUser", "testPassword", "ROLE_USER");
//        when(userDao.findById("testUser")).thenReturn(java.util.Optional.of(mockUser));
//
//        // Mocking authentication
//        when(authenticationManager.authenticate(any(UsernamePasswordAuthenticationToken.class)))
//                .thenReturn(null);
//
//        // Mocking UserDetails
//        UserDetails userDetails = new org.springframework.security.core.userdetails.User(
//                "testUser",
//                "testPassword",
//                Collections.emptySet()
//        );
//        when(jwtService.loadUserByUsername("testUser")).thenReturn(userDetails);
//
//        // Mocking JWT token generation
//        when(jwtUtil.generateToken(userDetails)).thenReturn("mockedToken");
//
//        // Performing the actual test
//        JwtRequest jwtRequest = new JwtRequest("testUser", "testPassword");
//        JwtResponse jwtResponse = jwtService.createJwtToken(jwtRequest);
//
//        // Assertions
//        assertNotNull(jwtResponse);
//        assertEquals(mockUser, jwtResponse.getUser());
//        assertEquals("mockedToken", jwtResponse.getToken());
//    }
//
//    @Test
//    void testCreateJwtTokenUserNotFound() {
//        // Mocking user data
//        when(userDao.findById("nonexistentUser")).thenReturn(java.util.Optional.empty());
//
//        // Performing the actual test
//        JwtRequest jwtRequest = new JwtRequest("nonexistentUser", "invalidPassword");
//
//        // Assertions
//        assertThrows(UsernameNotFoundException.class, () -> jwtService.createJwtToken(jwtRequest));
//    }
//
//    @Test
//    void testCreateJwtTokenAuthenticationFailure() {
//        // Mocking user data
//        User mockUser = new User("testUser", "testPassword", "ROLE_USER");
//        when(userDao.findById("testUser")).thenReturn(java.util.Optional.of(mockUser));
//
//        // Mocking authentication failure
//        when(authenticationManager.authenticate(any(UsernamePasswordAuthenticationToken.class)))
//                .thenThrow(new DisabledException("User is disabled"));
//
//        // Performing the actual test
//        JwtRequest jwtRequest = new JwtRequest("testUser", "testPassword");
//
//        // Assertions
//        assertThrows(Exception.class, () -> jwtService.createJwtToken(jwtRequest));
//    }
//
//    // Additional test cases for other failure scenarios can be added as needed
//}

