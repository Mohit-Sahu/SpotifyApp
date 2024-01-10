/**
 * 
 */
package com.cognizant.mohit.WishList.service;

/**
 * @author mohit
 *
 */
import java.util.List;

import com.cognizant.mohit.WishList.document.WishlistItem;

public interface WishlistService {

    String addToWishlist(WishlistItem wishlistItem);

    String removeFromWishlist(String userId, String trackId);

    List<WishlistItem> getWishlist(String userId);
}

