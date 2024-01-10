/**
 * 
 */
package com.cognizant.mohit.WishList.service;

/**
 * @author mohit
 *
 */
import com.cognizant.mohit.WishList.document.WishlistItem;
import com.cognizant.mohit.WishList.repo.WishlistRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

import static org.mockito.Mockito.*;

public class WishlistServiceImplTest {

    @Mock
    private WishlistRepository wishlistRepository;

    @InjectMocks
    private WishlistServiceImpl wishlistService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void addToWishlist_Success() {
        WishlistItem wishlistItem = new WishlistItem("1","userId", "trackId", new Date());
        when(wishlistRepository.findByUserIdAndTrackId("userId", "trackId")).thenReturn(null);

        String result = wishlistService.addToWishlist(wishlistItem);

        assertEquals("Track added to the wishlist: trackId", result);
        verify(wishlistRepository, times(1)).save(wishlistItem);
    }

    @Test
    void addToWishlist_AlreadyExists() {
        WishlistItem wishlistItem = new WishlistItem("1","userId", "trackId", new Date());
        when(wishlistRepository.findByUserIdAndTrackId("userId", "trackId")).thenReturn(wishlistItem);

        String result = wishlistService.addToWishlist(wishlistItem);

        assertEquals("Track is already in the wishlist: trackId", result);
        verify(wishlistRepository, never()).save(any());
    }

    @Test
    void removeFromWishlist_Success() {
        WishlistItem wishlistItem = new WishlistItem("1","userId", "trackId", new Date());
        when(wishlistRepository.findByUserIdAndTrackId("userId", "trackId")).thenReturn(wishlistItem);

        String result = wishlistService.removeFromWishlist("userId", "trackId");

        assertEquals("Track removed from the wishlist: trackId", result);
        verify(wishlistRepository, times(1)).deleteById(wishlistItem.getFavoriteId());
    }

    @Test
    void removeFromWishlist_NotFound() {
        when(wishlistRepository.findByUserIdAndTrackId("userId", "trackId")).thenReturn(null);

        String result = wishlistService.removeFromWishlist("userId", "trackId");

        assertEquals("Track not found in the wishlist: trackId", result);
        verify(wishlistRepository, never()).deleteById(any());
    }

    @Test
    void getWishlist() {
        List<WishlistItem> wishlistItems = new ArrayList<>();
        when(wishlistRepository.findByUserId("userId")).thenReturn(wishlistItems);

        List<WishlistItem> result = wishlistService.getWishlist("userId");

        assertEquals(wishlistItems, result);
        verify(wishlistRepository, times(1)).findByUserId("userId");
    }
}
