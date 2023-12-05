/**
 * 
 */
package com.cognizant.mohit.WishList.document;

/**
 * @author mohit
 *
 */
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

@Document(collection = "wishlist")
public class WishlistItem {

    @Id
    private String favoriteId;

    private String userId;

    private String trackId;

    @JsonFormat(pattern = "dd/MM/yyyy")
    private Date dateAdded;

	/**
	 * @return the favoriteId
	 */
	public String getFavoriteId() {
		return favoriteId;
	}

	/**
	 * @param favoriteId the favoriteId to set
	 */
	public void setFavoriteId(String favoriteId) {
		this.favoriteId = favoriteId;
	}

	/**
	 * @return the userId
	 */
	public String getUserId() {
		return userId;
	}

	/**
	 * @param userId the userId to set
	 */
	public void setUserId(String userId) {
		this.userId = userId;
	}

	/**
	 * @return the trackId
	 */
	public String getTrackId() {
		return trackId;
	}

	/**
	 * @param trackId the trackId to set
	 */
	public void setTrackId(String trackId) {
		this.trackId = trackId;
	}

	/**
	 * @return the dateAdded
	 */
	public Date getDateAdded() {
		return dateAdded;
	}

	/**
	 * @param dateAdded the dateAdded to set
	 */
	public void setDateAdded(Date dateAdded) {
		this.dateAdded = dateAdded;
	}

	/**
	 * @param favoriteId
	 * @param userId
	 * @param trackId
	 * @param dateAdded
	 */
	public WishlistItem(String favoriteId, String userId, String trackId, Date dateAdded) {
		super();
		this.favoriteId = favoriteId;
		this.userId = userId;
		this.trackId = trackId;
		this.dateAdded = new Date();
	}

    // Constructors, getters, setters, etc.
    

}

