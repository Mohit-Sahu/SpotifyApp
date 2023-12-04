/**
 * 
 */
package com.cognizant9.AuthenticationService.service;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.cognizant9.AuthenticationService.entity.Role;
import com.cognizant9.AuthenticationService.entity.User;
import com.cognizant9.AuthenticationService.repository.UserRepo;
import com.cognizant9.UserProfileService.entity.UserDetails;

/**
 * @author mohit
 *
 */
@Service
public class UserServiceImpl implements UserService {
	
	Map<String, String> mapObj = new HashMap<>();
	
	  @Autowired
	  private UserRepo userRepository;

	@Override
	public ResponseEntity<?> registerUser(UserDetails user) {
		// TODO Auto-generated method stub
		if (userRepository.existsById(user.getUserName())) {
			mapObj.put("msg", "Username or email is already exists!");
			return new ResponseEntity<>(mapObj, HttpStatus.BAD_REQUEST);
		}
          User user1 = new User(user.getUserName(), user.getUserFirstName(), user.getUserLastName(),
		 user.getUserPassword(),user.getContactNumber(),user.getRole());
//
      Set<Role> strRoles = user.getRole();
//		Set<Role> roles = new HashSet<>();
//		if (strRoles == null) {
//			Role userRole = roleRepository.findByName("ROLE_CUSTOMER")
//					.orElseThrow(() -> new RuntimeException("Error: Role is not found."));
//			roles.add(userRole);
//		} else {
//			strRoles.forEach(role -> {
//				switch (role) {
//				case "admin":
//					Role adminRole = roleRepository.findByName("ROLE_ADMIN")
//							.orElseThrow(() -> new RuntimeException("Error: Role is not found."));
//					roles.add(adminRole);
//
//					break;
//				default:
//					Role userRole = roleRepository.findByName("ROLE_CUSTOMER")
//							.orElseThrow(() -> new RuntimeException("Error: Role is not found."));
//					roles.add(userRole);
//				}
//			});
//		}

		user.setRole(strRoles);
		userRepository.save(user1);
		mapObj.put("msg", "User registered successfully");
		return new ResponseEntity<>(mapObj, HttpStatus.OK);
	}

	@Override
	public ResponseEntity<?> registerUser(User user) {
		// TODO Auto-generated method stub
		return null;
	}
	
}
