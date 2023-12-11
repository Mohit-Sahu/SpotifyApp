package com.cognizant.spotify.authservice.controller;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cognizant.spotify.authservice.dto.JwtResponse;
import com.cognizant.spotify.authservice.dto.LoginDto;
import com.cognizant.spotify.authservice.dto.ResetDto;
import com.cognizant.spotify.authservice.dto.SignupDto;
import com.cognizant.spotify.authservice.exception.InvalidInputException;
import com.cognizant.spotify.authservice.model.User;
import com.cognizant.spotify.authservice.security.JwtTokenUtil;
import com.cognizant.spotify.authservice.service.UserService;

@RestController
@RequestMapping("/api/v1.0/authentication")
public class AuthorizationController {

	@Autowired
	UserService userService;

	@Autowired
	JwtTokenUtil jwtTokenUtil;

	

	@PostMapping("/login")
	public ResponseEntity<?> loginUser(@RequestBody LoginDto loginRequest) throws InvalidInputException {
		try {
			String jwtToken = jwtTokenUtil.generatToken(loginRequest);
			Optional<User> userDetails = userService.getUserByUsername(loginRequest.getUsername());// fetch the user
			if (userDetails.isPresent()) {
				return ResponseEntity.ok(new JwtResponse(jwtToken, userDetails.get().getId(),
						userDetails.get().getUsername(), userDetails.get().getEmail(), userDetails.get().getRoles()));
			} else {
				throw new InvalidInputException("Invalid Credentials");
			}
		} catch (InvalidInputException e) {
			return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(e.getMessage());
		}
	}

	@PostMapping("/validate")
	public ResponseEntity<?> validateToken(@RequestHeader("Authorization") String token) {
		if (jwtTokenUtil.validateJwtToken(token)) {
			Map<String, String> userInfo = new HashMap<>();
			String authToken = token.substring(7);
			String username = jwtTokenUtil.getUserNameFromJwtToken(authToken);
			String role = jwtTokenUtil.getRoleFromToken(authToken);
			userInfo.put(username, role);
			return ResponseEntity.status(HttpStatus.OK).body(userInfo);
		} else {
			return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid token");
		}
	}

	



}
