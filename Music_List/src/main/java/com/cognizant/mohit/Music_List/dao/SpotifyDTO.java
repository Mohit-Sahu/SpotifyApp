/**
 * 
 */
package com.cognizant.mohit.Music_List.dao;

import java.util.List;

import com.cognizant.mohit.Music_List.model.Track;

/**
 * @author mohit
 *
 */
public class SpotifyDTO {
    // Define the fields based on the Spotify API response structure
    // For simplicity, you can include only the relevant fields you need
	private List<Track> data;

	public SpotifyDTO(List<Track> data) {
		super();
		this.data = data;
	}

	/**
	 * @return the data
	 */
	public List<Track> getData() {
		return data;
	}

	/**
	 * @param data the data to set
	 */
	public void setData(List<Track> data) {
		this.data = data;
	}

	/**
	 * 
	 */
	public SpotifyDTO() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @return
	 */
	
	
}
