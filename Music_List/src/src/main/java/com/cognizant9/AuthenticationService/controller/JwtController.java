/**
 * 
 */
package com.cognizant9.AuthenticationService.controller;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

/**
 * @author mohit
 *
 */
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;

import com.cognizant9.AuthenticationService.dao.JwtRequest;
import com.cognizant9.AuthenticationService.dao.JwtResponse;
import com.cognizant9.AuthenticationService.entity.User;
import com.cognizant9.AuthenticationService.repository.UserRepo;
import com.cognizant9.AuthenticationService.service.JwtService;
import com.cognizant9.AuthenticationService.util.JwtUtil;
import com.cognizant9.UserProfileService.entity.UserDetails;



@org.springframework.web.bind.annotation.RestController
@CrossOrigin
@RequestMapping("/api/v1")
public class JwtController {
	@Autowired
    private JwtService jwtService;
	
	@Autowired
    private UserRepo userRepo;
	
	 @Autowired
	 private JwtUtil jwtUtil;

    @PostMapping({"/login"})
    public JwtResponse createJwtToken(@RequestBody JwtRequest jwtRequest) throws Exception {
        return jwtService.createJwtToken(jwtRequest);
    }
    
    @PostMapping("/validate")
	public ResponseEntity<?> validateToken(@RequestHeader("Authorization") String token) throws Exception {
	
			if (jwtUtil.validateJwtToken(token)) {
				Map<String, String> userInfo = new HashMap<>();
				String authToken = token.substring(7);
				String username = jwtUtil.getUsernameFromToken(authToken);
				Optional<User> u=userRepo.findById(username);
				userInfo.put("role","User");
				userInfo.put("userId", username);
				return ResponseEntity.status(HttpStatus.OK).body(userInfo);
			} else {
				return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid token");
			}
		
	}
    
    
}

