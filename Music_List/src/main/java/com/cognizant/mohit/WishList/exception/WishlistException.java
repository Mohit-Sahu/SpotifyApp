/**
 * 
 */
package com.cognizant.mohit.WishList.exception;

/**
 * @author mohit
 *
 */
import org.springframework.http.HttpStatus;

public class WishlistException extends RuntimeException {

    private final HttpStatus status;

    public WishlistException(String message, HttpStatus status) {
        super(message);
        this.status = status;
    }

    public HttpStatus getStatus() {
        return status;
    }
}

