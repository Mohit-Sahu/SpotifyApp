/**
 * 
 */
package com.cognizant.mohit.Music_List.dto;

import java.util.List;



/**
 * @author mohit
 *
 */
public class AlbumDTO {
    // Define the fields based on the Spotify API response structure
    // For simplicity, you can include only the relevant fields you need
	// AlbumDTO.java
	    private String album_type;
	    private int total_tracks;
	    private String id;
	    private String name;
	    private List<ArtistsDTO> artists;
	    private TracksDTO tracks;
	  
		/**
		 * @return the album_type
		 */
		public String getAlbum_type() {
			return album_type;
		}
		/**
		 * @param album_type the album_type to set
		 */
		public void setAlbum_type(String album_type) {
			this.album_type = album_type;
		}
		/**
		 * @return the total_tracks
		 */
		public int getTotal_tracks() {
			return total_tracks;
		}
		/**
		 * @param total_tracks the total_tracks to set
		 */
		public void setTotal_tracks(int total_tracks) {
			this.total_tracks = total_tracks;
		}
		/**
		 * @return the href
		 */
		
		/**
		 * @return the id
		 */
		public String getId() {
			return id;
		}
		/**
		 * @param id the id to set
		 */
		public void setId(String id) {
			this.id = id;
		}
		/**
		 * @return the name
		 */
		public String getName() {
			return name;
		}
		/**
		 * @param name the name to set
		 */
		public void setName(String name) {
			this.name = name;
		}
		/**
		 * @return the release_date
		 */
		
		/**
		 * @return the release_date_precision
		 */
		
		/**
		 * @return the artists
		 */
		public List<ArtistsDTO> getArtists() {
			return artists;
		}
		/**
		 * @param artists the artists to set
		 */
		public void setArtists(List<ArtistsDTO> artists) {
			this.artists = artists;
		}
		/**
		 * @return the tracks
		 */
		public TracksDTO getTracks() {
			return tracks;
		}
		/**
		 * @param tracks the tracks to set
		 */
		public void setTracks(TracksDTO tracks) {
			this.tracks = tracks;
		}
		/**
		 * @return the genres
		 */
	
		/**
		 * @param album_type
		 * @param total_tracks
		 * @param href
		 * @param id
		 * @param name
		 * @param release_date
		 * @param release_date_precision
		 * @param artists
		 * @param tracks
		 * @param genres
		 */
		public AlbumDTO(String album_type, int total_tracks, String href, String id, String name, String release_date,
				String release_date_precision, List<ArtistsDTO> artists, TracksDTO tracks) {
			super();
			this.album_type = album_type;
			this.total_tracks = total_tracks;
			this.id = id;
			this.name = name;
		
			this.artists = artists;
			this.tracks = tracks;
		
		}
		/**
		 * 
		 */
		public AlbumDTO() {
			super();
			// TODO Auto-generated constructor stub
		}

	 
	


	
	
}
