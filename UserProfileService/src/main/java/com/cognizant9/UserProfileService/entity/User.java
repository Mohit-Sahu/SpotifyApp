/**
 * 
 */
package com.cognizant9.UserProfileService.entity;

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
	private String userFirstName;
	private String userLastName;
	private String userPassword;
	private String contactNumber;
	@ManyToMany(fetch=FetchType.EAGER, cascade=CascadeType.ALL)
	@JoinTable(name="USER_ROLE",
	joinColumns= {@JoinColumn(name="USER_ID")},
	inverseJoinColumns= {
			@JoinColumn(name="ROLE_ID")
	}
	)
	private Set<Role> role;
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
	 * @return the userFirstName
	 */
	public String getUserFirstName() {
		return userFirstName;
	}
	/**
	 * @param userFirstName the userFirstName to set
	 */
	public void setUserFirstName(String userFirstName) {
		this.userFirstName = userFirstName;
	}
	/**
	 * @return the userLastName
	 */
	public String getUserLastName() {
		return userLastName;
	}
	/**
	 * @param userLastName the userLastName to set
	 */
	public void setUserLastName(String userLastName) {
		this.userLastName = userLastName;
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
	 * @return the contactNumber
	 */
	public String getContactNumber() {
		return contactNumber;
	}
	/**
	 * @param contactNumber the contactNumber to set
	 */
	public void setContactNumber(String contactNumber) {
		this.contactNumber = contactNumber;
	}
	/**
	 * @return the role
	 */
	public Set<Role> getRole() {
		return role;
	}
	/**
	 * @param role the role to set
	 */
	public void setRole(Set<Role> role) {
		this.role = role;
	}
	/**
	 * @param userName
	 * @param userFirstName
	 * @param userLastName
	 * @param userPassword
	 * @param contactNumber
	 * @param role
	 */
	public User(String userName, String userFirstName, String userLastName, String userPassword, String contactNumber,
			Set<Role> role) {
		super();
		this.userName = userName;
		this.userFirstName = userFirstName;
		this.userLastName = userLastName;
		this.userPassword = userPassword;
		this.contactNumber = contactNumber;
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
		return "User [userName=" + userName + ", userFirstName=" + userFirstName + ", userLastName=" + userLastName
				+ ", userPassword=" + userPassword + ", contactNumber=" + contactNumber + ", role=" + role + "]";
	}
	
	
}
