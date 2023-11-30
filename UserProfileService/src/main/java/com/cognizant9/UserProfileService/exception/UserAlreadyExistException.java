/**
 * 
 */
package com.cognizant9.UserProfileService.exception;

/**
 * @author mohit
 *
 */
public class UserAlreadyExistException extends Exception {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String message;

    public UserAlreadyExistException(String message) {
        super(message);
        this.message = message;
    }

    public UserAlreadyExistException() {
    }


}
