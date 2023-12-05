/**
 * 
 */
package com.cognizant9.AuthenticationService.dao;

/**
 * @author mohit
 *
 */

public class JwtRequest {

	    private String userName;
	    private String userPassword;

	    /**
		 * @param string
		 * @param string2
		 */
		
		public String getUserName() {
	        return userName;
	    }

	    /**
		 * @param userName
		 * @param userPassword
		 */
		public JwtRequest(String userName, String userPassword) {
			super();
			this.userName = userName;
			this.userPassword = userPassword;
		}

		public void setUserName(String userName) {
	        this.userName = userName;
	    }

	    public String getUserPassword() {
	        return userPassword;
	    }

	    public void setUserPassword(String userPassword) {
	        this.userPassword = userPassword;
	    }

		/**
		 * 
		 */
		public JwtRequest() {
			super();
			// TODO Auto-generated constructor stub
		}
	}

