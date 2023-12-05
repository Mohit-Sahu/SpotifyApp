/**
 * 
 */
package com.cognizant9.AuthenticationService.controller;

/**
 * @author mohit
 *
 */


import com.cognizant9.AuthenticationService.dao.JwtRequest;
import com.cognizant9.AuthenticationService.dao.JwtResponse;
import com.cognizant9.AuthenticationService.service.JwtService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

class JwtControllerTest {

    private MockMvc mockMvc;

    @Mock
    private JwtService jwtService;

    @InjectMocks
    private JwtController jwtController;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        mockMvc = MockMvcBuilders.standaloneSetup(jwtController).build();
    }

    @Test
    void testCreateJwtTokenSuccess() throws Exception {
        // Mocking the service method for successful execution
        when(jwtService.createJwtToken(new JwtRequest("username", "password")))
                .thenReturn(new JwtResponse(null, "token"));

        // Performing the POST request
        mockMvc.perform(post("/api/v1/login")
                .content(asJsonString(new JwtRequest("username", "password")))
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.token").value("token"));
    }

    @Test
    void testCreateJwtTokenFailure() throws Exception {
        // Mocking the service method for failure scenario
        when(jwtService.createJwtToken(new JwtRequest("username", "password")))
                .thenThrow(new Exception("Some error message"));

        // Performing the POST request
        mockMvc.perform(post("/api/v1/login")
                .content(asJsonString(new JwtRequest("username", "password")))
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isInternalServerError());
    }

    // Helper method to convert object to JSON string
    private String asJsonString(Object object) throws Exception {
        return new ObjectMapper().writeValueAsString(object);
    }
}

