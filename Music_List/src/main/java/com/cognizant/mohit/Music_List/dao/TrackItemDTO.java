/**
 * 
 */
package com.cognizant.mohit.Music_List.dao;

import java.util.List;

/**
 * @author mohit
 *
 */
public class TrackItemDTO {
    private List<ArtistsDTO> artists;
    private long duration_ms;
    private String href;
    private String id;
    private String name;
    private int track_number;
    private String type;
  
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
	 * @return the disc_number
	 */
	
	/**
	 * @return the duration_ms
	 */
	public long getDuration_ms() {
		return duration_ms;
	}
	/**
	 * @param duration_ms the duration_ms to set
	 */
	public void setDuration_ms(long duration_ms) {
		this.duration_ms = duration_ms;
	}
	/**
	 * @return the explicit
	 */
	
	/**
	 * @return the href
	 */
	public String getHref() {
		return href;
	}
	/**
	 * @param href the href to set
	 */
	public void setHref(String href) {
		this.href = href;
	}
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
	 * @return the preview_url
	 */
	
	/**
	 * @return the track_number
	 */
	public int getTrack_number() {
		return track_number;
	}
	/**
	 * @param track_number the track_number to set
	 */
	public void setTrack_number(int track_number) {
		this.track_number = track_number;
	}
	/**
	 * @return the type
	 */
	public String getType() {
		return type;
	}
	/**
	 * @param type the type to set
	 */
	public void setType(String type) {
		this.type = type;
	}
	/**
	 * @return the uri
	 */
	
	/**
	 * @param is_local the is_local to set
	 */
	
	/**
	 * @param artists
	 * @param disc_number
	 * @param duration_ms
	 * @param explicit
	 * @param href
	 * @param id
	 * @param name
	 * @param preview_url
	 * @param track_number
	 * @param type
	 * @param uri
	 * @param is_local
	 */
	public TrackItemDTO(List<ArtistsDTO> artists, int disc_number, long duration_ms, boolean explicit, String href,
			String id, String name, String preview_url, int track_number, String type, String uri, boolean is_local) {
		super();
		this.artists = artists;
		
		this.duration_ms = duration_ms;
	
		this.href = href;
		this.id = id;
		this.name = name;
		this.track_number = track_number;
		this.type = type;
		
	}

    // Getters and setters
    
}
