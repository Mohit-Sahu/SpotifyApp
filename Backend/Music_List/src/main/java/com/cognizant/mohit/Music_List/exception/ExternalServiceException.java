/**
 * 
 */
package com.cognizant.mohit.Music_List.exception;

/**
 * @author mohit
 *
 */

public class ExternalServiceException extends RuntimeException {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public ExternalServiceException(String message) {
        super(message);
    }
}

