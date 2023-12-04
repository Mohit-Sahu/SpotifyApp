/**
 * 
 */
package com.cognizant9.AuthenticationService.controller;

/**
 * @author mohit
 *
 */
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.cognizant9.AuthenticationService.dao.JwtRequest;
import com.cognizant9.AuthenticationService.dao.JwtResponse;
import com.cognizant9.AuthenticationService.service.JwtService;



@org.springframework.web.bind.annotation.RestController
@CrossOrigin
@RequestMapping("api/v1")
public class JwtController {
	@Autowired
    private JwtService jwtService;

    @PostMapping({"/login"})
    public JwtResponse createJwtToken(@RequestBody JwtRequest jwtRequest) throws Exception {
        return jwtService.createJwtToken(jwtRequest);
    }
    
    @PostMapping({"/login"})
    public boolean validateToken(@RequestBody JwtRequest jwtRequest) throws Exception {
        
    }
}

