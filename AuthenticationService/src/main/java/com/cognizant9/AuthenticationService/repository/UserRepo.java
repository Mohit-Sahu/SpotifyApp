/**
 * 
 */
package com.cognizant9.AuthenticationService.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cognizant9.AuthenticationService.entity.User;

/**
 * @author mohit
 *
 */
public interface UserRepo extends JpaRepository<User, String>{

}
