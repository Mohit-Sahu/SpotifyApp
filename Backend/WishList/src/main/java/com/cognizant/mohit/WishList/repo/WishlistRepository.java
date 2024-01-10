/**
 * 
 */
package com.cognizant.mohit.WishList.repo;

import java.util.List;

/**
 * @author mohit
 *
 */
import org.springframework.data.mongodb.repository.MongoRepository;

import com.cognizant.mohit.WishList.document.WishlistItem;

public interface WishlistRepository extends MongoRepository<WishlistItem, String> {

	/**
	 * @param userId
	 * @param trackId
	 * @return
	 */
	WishlistItem findByUserIdAndTrackId(String userId, String trackId);

	/**
	 * @param userId
	 * @return
	 */
	List<WishlistItem> findByUserId(String userId);

    // Custom queries or methods if needed

}

