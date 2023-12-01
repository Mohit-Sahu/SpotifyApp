/**
 * 
 */
package com.cognizant9.AuthenticationService.entity;

/**
 * @author mohit
 *
 */

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.JoinColumn;




/**
 * @author mohit
 *
 */

@Entity
public class User {
	@Id
	private String userName;
	private String userPassword;
	private String role;
	/**
	 * @return the userName
	 */
	/**
	 * @return the userName
	 */
	public String getUserName() {
		return userName;
	}
	/**
	 * @param userName the userName to set
	 */
	public void setUserName(String userName) {
		this.userName = userName;
	}
	/**
	 * @return the userPassword
	 */
	public String getUserPassword() {
		return userPassword;
	}
	/**
	 * @param userPassword the userPassword to set
	 */
	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}
	/**
	 * @return the role
	 */
	public String getRole() {
		return role;
	}
	/**
	 * @param role the role to set
	 */
	public void setRole(String role) {
		this.role = role;
	}
	/**
	 * @param userName
	 * @param userPassword
	 * @param role
	 */
	public User(String userName, String userPassword, String role) {
		super();
		this.userName = userName;
		this.userPassword = userPassword;
		this.role = role;
	}
	/**
	 * 
	 */
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "User [userName=" + userName + ", userPassword=" + userPassword + ", role=" + role + "]";
	}
	
	
	
}

