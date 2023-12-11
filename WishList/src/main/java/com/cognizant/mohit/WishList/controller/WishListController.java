/**
 * 
 */
package com.cognizant.mohit.WishList.controller;

/**
 * @author mohit
 *
 */


import java.util.Date;
import java.util.List;

import org.apache.hc.client5.http.auth.InvalidCredentialsException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cognizant.mohit.WishList.document.WishlistItem;
import com.cognizant.mohit.WishList.exception.ExternalServiceException;
import com.cognizant.mohit.WishList.fiegn.AuthClient;
import com.cognizant.mohit.WishList.service.WishlistService;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;



import feign.FeignException;
import io.swagger.v3.oas.annotations.Parameter;

@RestController
@RequestMapping("/api/v1.0/wishlist")
public class WishListController {

    @Autowired
    WishlistService whishListService;

    @Autowired
    AuthClient authClient;

    //kafka
    @GetMapping("/getByUserId/{userId}")
    public ResponseEntity<?> getWhishlistByUserId(@PathVariable String userId,
            @Parameter(hidden = true) @RequestHeader("Authorization") String token) throws InvalidCredentialsException {
    	try {
			Map<String, String> userInfo = (Map<String, String>) authClient.validateToken(token).getBody();
			if (userInfo.containsValue("ROLE_ADMIN") || userInfo.containsValue("ROLE_CUSTOMER")) {
				return new ResponseEntity<>(whishListService.getWishlist(userId), HttpStatus.OK);
			} else {
				throw new InvalidCredentialsException("Access Denied");
			}
		} catch (FeignException e) {
			throw new ExternalServiceException(e.getMessage());
		}
    }

    @PostMapping("/addItem")
    public ResponseEntity<?> addStockToWhishlist(@RequestBody WishlistItem whishlist,
            @Parameter(hidden = true) @RequestHeader("Authorization") String token) throws InvalidCredentialsException {
    	try {
			Map<String, String> userInfo = (Map<String, String>) authClient.validateToken(token).getBody();
			if (userInfo.containsValue("ROLE_ADMIN") || userInfo.containsValue("ROLE_CUSTOMER")) {
				String userId = userInfo.keySet().iterator().next();
				System.out.println("userIdv " + userId);
				whishlist.setUserId(userId);
				return new ResponseEntity<>(whishListService.addToWishlist(whishlist), HttpStatus.OK);
			} else {
				throw new InvalidCredentialsException("Access Denied");
			}
		} catch (FeignException e) {
			throw new ExternalServiceException(e.getMessage());
		}
    }

    @DeleteMapping("/remove/{userId}/{trackId}")
    public ResponseEntity<?> deleteFromWhishList(@PathVariable String userId, @PathVariable String trackId,
            @Parameter(hidden = true) @RequestHeader("Authorization") String token) throws InvalidCredentialsException {
    	try {
			Map<String, String> userInfo = (Map<String, String>) authClient.validateToken(token).getBody();
			if (userInfo.containsValue("ROLE_ADMIN") || userInfo.containsValue("ROLE_CUSTOMER")) {
				return new ResponseEntity<>(whishListService.removeFromWishlist(userId,trackId), HttpStatus.OK);
			} else {
				throw new InvalidCredentialsException("Access Denied");
			}
		} catch (FeignException e) {
			throw new ExternalServiceException(e.getMessage());
		}
    }

  

  
}
