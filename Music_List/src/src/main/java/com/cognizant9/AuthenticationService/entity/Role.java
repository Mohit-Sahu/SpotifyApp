/**
 * 
 */
package com.cognizant9.AuthenticationService.entity;

/**
 * @author mohit
 *
 */
/**
 * 
 */


import javax.persistence.Id;

/**
 * @author mohit
 *
 */
@javax.persistence.Entity
public class Role {
	  @Id
	  private String roleId;
	  private String roleName;
	  private String roleDesc;
	/**
	 * @return the roleId
	 */
	public String getRoleId() {
		return roleId;
	}
	/**
	 * @param roleId the roleId to set
	 */
	public void setRoleId(String roleId) {
		this.roleId = roleId;
	}
	/**
	 * @return the roleName
	 */
	public String getRoleName() {
		return roleName;
	}
	/**
	 * @param roleName the roleName to set
	 */
	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}
	/**
	 * @return the roleDesc
	 */
	public String getRoleDesc() {
		return roleDesc;
	}
	/**
	 * @param roleDesc the roleDesc to set
	 */
	public void setRoleDesc(String roleDesc) {
		this.roleDesc = roleDesc;
	}
	/**
	 * @param roleId
	 * @param roleName
	 * @param roleDesc
	 */
	public Role(String roleId, String roleName, String roleDesc) {
		super();
		this.roleId = roleId;
		this.roleName = roleName;
		this.roleDesc = roleDesc;
	}
	/**
	 * 
	 */
	public Role() {
		super();
		// TODO Auto-generated constructor stub
	}
	  
	  
}
