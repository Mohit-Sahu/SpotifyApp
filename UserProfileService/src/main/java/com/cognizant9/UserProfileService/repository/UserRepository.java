/**
 * 
 */
package com.cognizant9.UserProfileService.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cognizant9.UserProfileService.entity.User;

/**
 * @author mohit
 *
 */
@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

	/**
	 * @param userName
	 * @return
	 */
	User findByUserName(String userName);

}
