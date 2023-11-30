/**
 * 
 */
package com.cognizant9.UserProfileService.controller;

import java.util.List;
import java.util.Set;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.cognizant9.UserProfileService.entity.User;
import com.cognizant9.UserProfileService.service.UserService;



/**
 * @author mohit
 *
 */
@Controller
@RequestMapping("/api/v1/users")
public class UserController {
	
	private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }
	
	   @PostMapping("/register")
	    public ResponseEntity<User> registerNewUser(@RequestBody User user) {
	        User createdUser = userService.registerNewUser(user);
	        return new ResponseEntity<>(createdUser, HttpStatus.CREATED);
	    }
	   
	   @PostConstruct
		public void initRolesAndUser() {
			userService.initRolesAndUser();
		}
	   
	   @GetMapping("/{userName}")
	    public ResponseEntity<User> getUserByUserName(@PathVariable String userName) {
	        User user = userService.getUserByUserName(userName);
	        return new ResponseEntity<>(user, HttpStatus.OK);
	    }

	    @GetMapping("/all")
	    public ResponseEntity<List<User>> getAllUsers() {
	        List<User> users = userService.getAllUsers();
	        return new ResponseEntity<>(users, HttpStatus.OK);
	    }

}
