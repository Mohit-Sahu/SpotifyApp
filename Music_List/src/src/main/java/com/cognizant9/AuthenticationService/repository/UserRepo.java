/**
 * 
 */
package com.cognizant9.AuthenticationService.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cognizant9.AuthenticationService.entity.User;
import com.cognizant9.UserProfileService.entity.UserDetails;

/**
 * @author mohit
 *
 */
public interface UserRepo extends JpaRepository<User, String>{

	/**
	 * @param user1
	 */
	

}
