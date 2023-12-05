/**
 * 
 */
package com.cognizant.mohit.Music_List.model;

/**
 * @author mohit
 *
 */
public class Track {
	
	    private String trackId;
	    private String name;
	    private String albumType;
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
		 * @return the albumType
		 */
		public String getAlbumType() {
			return albumType;
		}
		/**
		 * @param albumType the albumType to set
		 */
		public void setAlbumType(String albumType) {
			this.albumType = albumType;
		}
		/**
		 * @param trackId
		 * @param name
		 * @param albumType
		 */
		public Track(String trackId, String name, String albumType) {
			super();
			this.trackId = trackId;
			this.name = name;
			this.albumType = albumType;
		}
		/**
		 * 
		 */
		public Track() {
			super();
			// TODO Auto-generated constructor stub
		}
	    
	    

}
