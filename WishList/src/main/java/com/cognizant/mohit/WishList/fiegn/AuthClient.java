/**
 * 
 */
package com.cognizant.mohit.WishList.fiegn;



import org.springframework.cloud.openfeign.FeignClient;

/**
 * @author mohit
 *
 */

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestHeader;

@FeignClient(name = "REGISTRATIONSERVICE",url="http://localhost:9090/api/v1.0/authentication")
public interface AuthClient {
	
	@PostMapping("/validate")
	public ResponseEntity<?> validateToken(@RequestHeader("Authorization") String token);
}

