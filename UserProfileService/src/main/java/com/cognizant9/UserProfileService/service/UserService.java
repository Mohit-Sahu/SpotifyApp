/**
 * 
 */
package com.cognizant9.UserProfileService.service;

import java.util.List;
import java.util.Set;

import com.cognizant9.UserProfileService.entity.User;

/**
 * @author mohit
 *
 */
public interface UserService {
	public void initRolesAndUser();
	
	public User registerNewUser(User user);

	/**
	 * @param userName
	 * @return
	 */
	public User getUserByUserName(String userName);

	/**
	 * @return
	 */
	public List<User> getAllUsers();
}
