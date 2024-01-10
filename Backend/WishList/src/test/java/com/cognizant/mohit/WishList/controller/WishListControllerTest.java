/**
 * 
 */
package com.cognizant.mohit.WishList.controller;

/**
 * @author mohit
 *
 */
import com.cognizant.mohit.WishList.document.WishlistItem;
import com.cognizant.mohit.WishList.exception.ExternalServiceException;
import com.cognizant.mohit.WishList.service.WishlistService;
import feign.FeignException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;

public class WishListControllerTest {

    @Mock
    private WishlistService wishlistService;

    @InjectMocks
    private WishListController wishListController;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void addToWishlist_Success() throws Exception {
        WishlistItem wishlistItem = new WishlistItem("1","userId", "trackId", null);
        when(wishlistService.addToWishlist(wishlistItem)).thenReturn("Track added to the wishlist: trackId");

        ResponseEntity<String> response = wishListController.addToWishlist(wishlistItem);

        assertEquals(HttpStatus.CREATED, response.getStatusCode());
        assertEquals("Track added to the wishlist: trackId", response.getBody());
    }

    @Test
    void addToWishlist_FeignException() throws Exception {
        WishlistItem wishlistItem = new WishlistItem("1","userId", "trackId", null);
        when(wishlistService.addToWishlist(wishlistItem)).thenThrow(FeignException.class);

        assertThrows(ExternalServiceException.class, () -> wishListController.addToWishlist(wishlistItem));
    }

    @Test
    void removeFromWishlist_Success() throws Exception {
        String userId = "userId";
        String trackId = "trackId";
        when(wishlistService.removeFromWishlist(userId, trackId)).thenReturn("Track removed from the wishlist: trackId");

        ResponseEntity<String> response = wishListController.removeFromWishlist(userId, trackId);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals("Track removed from the wishlist: trackId", response.getBody());
    }

    @Test
    void removeFromWishlist_NotFound() throws Exception {
        String userId = "userId";
        String trackId = "trackId";
        when(wishlistService.removeFromWishlist(userId, trackId)).thenReturn("Track not found in the wishlist: trackId");

        ResponseEntity<String> response = wishListController.removeFromWishlist(userId, trackId);

        assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode());
        assertEquals("Track not found in the wishlist: trackId", response.getBody());
    }

    @Test
    void removeFromWishlist_FeignException() throws Exception {
        String userId = "userId";
        String trackId = "trackId";
        when(wishlistService.removeFromWishlist(userId, trackId)).thenThrow(FeignException.class);

        assertThrows(ExternalServiceException.class, () -> wishListController.removeFromWishlist(userId, trackId));
    }

    @Test
    void getWishlist_Success() throws Exception {
        String userId = "userId";
        List<WishlistItem> wishlistItems = new ArrayList<>();
        when(wishlistService.getWishlist(userId)).thenReturn(wishlistItems);

        ResponseEntity<List<WishlistItem>> response = wishListController.getWishlist(userId);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(wishlistItems, response.getBody());
    }

    @Test
    void getWishlist_FeignException() throws Exception {
        String userId = "userId";
        when(wishlistService.getWishlist(userId)).thenThrow(FeignException.class);

        assertThrows(ExternalServiceException.class, () -> wishListController.getWishlist(userId));
    }
}

