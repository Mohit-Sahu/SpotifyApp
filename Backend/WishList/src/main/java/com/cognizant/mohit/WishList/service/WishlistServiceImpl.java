/**
 * 
 */
package com.cognizant.mohit.WishList.service;

/**
 * @author mohit
 *
 */
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cognizant.mohit.WishList.document.WishlistItem;
import com.cognizant.mohit.WishList.repo.WishlistRepository;

import java.util.Date;
import java.util.List;

@Service
public class WishlistServiceImpl implements WishlistService {

    @Autowired
    private WishlistRepository wishlistRepository;

    @Override
    public String addToWishlist(WishlistItem wishlistItem) {
        WishlistItem existingItem = wishlistRepository.findByUserIdAndTrackId(wishlistItem.getUserId(), wishlistItem.getTrackId());
        if (existingItem == null) {
            wishlistItem.setDateAdded(new Date());
            wishlistRepository.save(wishlistItem);
            return "Track added to the wishlist: " + wishlistItem.getTrackId();
        } else {
            return "Track is already in the wishlist: " + wishlistItem.getTrackId();
        }
    }

    @Override
    public String removeFromWishlist(String userId, String trackId) {
        WishlistItem existingItem = wishlistRepository.findByUserIdAndTrackId(userId, trackId);
        if (existingItem != null) {
            wishlistRepository.deleteById(existingItem.getFavoriteId());
            return "Track removed from the wishlist: " + trackId;
        } else {
            return "Track not found in the wishlist: " + trackId;
        }
    }

    @Override
    public List<WishlistItem> getWishlist(String userId) {
        return wishlistRepository.findByUserId(userId);
    }
}
