package com.cognizant.spotify.authservice.service;

import java.util.Optional;

import org.springframework.http.ResponseEntity;

import com.cognizant.spotify.authservice.dto.LoginDto;
import com.cognizant.spotify.authservice.dto.ResetDto;
import com.cognizant.spotify.authservice.dto.SignupDto;
import com.cognizant.spotify.authservice.model.User;
import com.cognizant.spotify.userprofileservice.model.UserProfile;

public interface UserService {

	public ResponseEntity<?> addUser(SignupDto signupDto);
	
	//kafka service
	public ResponseEntity<?> registerUser(UserProfile signupDto);

	// this will work like a authentication manager for validating user
	public boolean loginUser(LoginDto loginDto);

	public ResponseEntity<?> getAllUsers();

	public Optional<User> getUserByUsername(String username);

	public ResponseEntity<?> updatePassword(ResetDto resetDto);

	public ResponseEntity<?> deleteUser(Long userId);

}
