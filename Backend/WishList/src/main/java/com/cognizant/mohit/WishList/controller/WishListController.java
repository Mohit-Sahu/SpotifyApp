/**
 * 
 */
package com.cognizant.mohit.WishList.controller;

/**
 * @author mohit
 *
 */



import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;

import com.cognizant.mohit.WishList.document.WishlistItem;
import com.cognizant.mohit.WishList.exception.ExternalServiceException;


import com.cognizant.mohit.WishList.service.WishlistService;

import feign.FeignException;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("api/v1.0/wishlist")
public class WishListController {

    
         private final WishlistService wishlistService;
  
      

    
          @Autowired
          public WishListController(WishlistService wishlistService) {
              this.wishlistService = wishlistService;
             
          }
          
   

    @PostMapping("/add")
    public ResponseEntity<String> addToWishlist(@RequestBody WishlistItem wishlistItem) throws Exception {
    	try {
			
				String response = wishlistService.addToWishlist(wishlistItem);
		        return ResponseEntity.status(HttpStatus.CREATED).body(response);
			
		} catch (FeignException e) {
			throw new ExternalServiceException(e.getMessage());
		}
        
    }

    	
    

    @DeleteMapping("/remove/{userId}/{trackId}")
    public ResponseEntity<String> removeFromWishlist(@PathVariable String userId, @PathVariable String trackId) throws Exception {
    	try {
			
				 String response = wishlistService.removeFromWishlist(userId, trackId);
			        HttpStatus status = response.startsWith("Track removed") ? HttpStatus.OK : HttpStatus.NOT_FOUND;

			        // Add logging for debugging
			        System.out.println("Response: " + response + ", Status: " + status);

			        return ResponseEntity.status(status).body(response);
			
		} catch (FeignException e) {
			throw new ExternalServiceException(e.getMessage());
		}
        
    }
       
    

    @GetMapping("/list/{userId}")
    public ResponseEntity<List<WishlistItem>> getWishlist(@PathVariable String userId) throws Exception {
    	try {

				List<WishlistItem> wishlist = wishlistService.getWishlist(userId);
		        return ResponseEntity.ok(wishlist);
			
		} catch (FeignException e) {
			throw new ExternalServiceException(e.getMessage());
		}
        
    }
}

    	
    
