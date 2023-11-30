/**
 * 
 */
package com.cognizant9.UserProfileService.service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.cognizant9.UserProfileService.entity.Role;
import com.cognizant9.UserProfileService.entity.User;
import com.cognizant9.UserProfileService.repository.RoleRepository;
import com.cognizant9.UserProfileService.repository.UserRepository;

/**
 * @author mohit
 *
 */

@Service
public class UserServiceImpl implements UserService{

	@Autowired
	private UserRepository userdao;
	
	@Autowired
	private RoleRepository roleDao;
	
	@Autowired
    private PasswordEncoder passwordEncoder;
  
	 
	@Override
	public void initRolesAndUser() {
		
		Role adminRole=new Role();
		adminRole.setRoleId("2");
		adminRole.setRoleName("Admin");
		adminRole.setRoleDesc("Admin Role");
		roleDao.save(adminRole);
		
		Role userRole=new Role();
		userRole.setRoleId("2");
		userRole.setRoleName("User");
		userRole.setRoleDesc("Default Role for user");
		roleDao.save(userRole);
		
		User adminUser=new User();
		adminUser.setUserFirstName("admin");
		adminUser.setUserLastName("admin");
		adminUser.setUserName("admin123");
		adminUser.setUserPassword(getEncodedPassword("admin@pass"));
		adminUser.setContactNumber("9876543210");
		Set<Role> adminRoles=new HashSet<>();
		adminRoles.add(adminRole);
		adminUser.setRole(adminRoles);
		userdao.save(adminUser);
		
//		User user=new User();
//		user.setUserFirstName("mohit");
//		user.setUserLastName("sahu");
//		user.setUserName("mohit123");
//		user.setUserPassword(getEncodedPassword("mohit@123"));
//		Set<Role> userRoles=new HashSet<>();
//		userRoles.add(userRole);
//		user.setRole(userRoles);
//		userdao.save(user);
//		
		
		
		
	}
	public User registerNewUser(User user) {
        Role role = roleDao.findByRoleName("User");
        Set<Role> userRoles = new HashSet<>();
        userRoles.add(role);
        user.setRole(userRoles);
        user.setUserPassword(getEncodedPassword(user.getUserPassword()));

        return userdao.save(user);
    }
	
	 @Override
	    public User getUserByUserName(String userName) {
	        // Implement logic to get a user by username
		 return userdao.findByUserName(userName);
	    }

	    @Override
	    public List<User> getAllUsers() {
	        // Implement logic to retrieve all users
	    	 return  userdao.findAll();
	    }
	
	public String getEncodedPassword(String password) {
        return passwordEncoder.encode(password);
    }

}
