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

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cognizant.mohit.WishList.document.WishlistItem;
import com.cognizant.mohit.WishList.repo.WishlistRepository;
import com.cognizant.mohit.WishList.service.WishlistService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/wishlist")
public class WishListController {

    @Autowired
    private WishlistService wishlistService;

    @PostMapping("/add")
    public ResponseEntity<String> addToWishlist(@RequestBody WishlistItem wishlistItem) {
        String response = wishlistService.addToWishlist(wishlistItem);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @DeleteMapping("/remove/{userId}/{trackId}")
    public ResponseEntity<String> removeFromWishlist(@PathVariable String userId, @PathVariable String trackId) {
        String response = wishlistService.removeFromWishlist(userId, trackId);
        HttpStatus status = response.startsWith("Track removed") ? HttpStatus.OK : HttpStatus.NOT_FOUND;
        return ResponseEntity.status(status).body(response);
    }

    @GetMapping("/list/{userId}")
    public ResponseEntity<List<WishlistItem>> getWishlist(@PathVariable String userId) {
        List<WishlistItem> wishlist = wishlistService.getWishlist(userId);
        return ResponseEntity.ok(wishlist);
    }
}
