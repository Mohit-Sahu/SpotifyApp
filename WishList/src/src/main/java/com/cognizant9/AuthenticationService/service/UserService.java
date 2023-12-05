/**
 * 
 */
package com.cognizant9.AuthenticationService.service;

import org.springframework.http.ResponseEntity;

import com.cognizant9.AuthenticationService.entity.User;
import com.cognizant9.UserProfileService.entity.UserDetails;

/**
 * @author mohit
 *
 */
public interface UserService {
	public ResponseEntity<?> registerUser(User user);

	/**
	 * @param user
	 * @return
	 */
	ResponseEntity<?> registerUser(UserDetails user);
}
