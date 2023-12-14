/**
 * 
 */
package com.cognizant.mohit.Music_List.dto;

import java.util.List;

/**
 * @author mohit
 *
 */
public class TracksDTO {
    private String href;
 
    private int total;
    private List<TrackItemDTO> items;
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
	 * @return the limit
	 */
	
	/**
	 * @return the offset
	 */
	
	/**
	 * @param previous the previous to set
	 */
	
	/**
	 * @return the total
	 */
	public int getTotal() {
		return total;
	}
	/**
	 * @param total the total to set
	 */
	public void setTotal(int total) {
		this.total = total;
	}
	/**
	 * @return the items
	 */
	public List<TrackItemDTO> getItems() {
		return items;
	}
	/**
	 * @param items the items to set
	 */
	public void setItems(List<TrackItemDTO> items) {
		this.items = items;
	}
	/**
	 * @param href
	 * @param limit
	 * @param next
	 * @param offset
	 * @param previous
	 * @param total
	 * @param items
	 */
	public TracksDTO(String href, int total,
			List<TrackItemDTO> items) {
		super();
		this.href = href;
		
		this.total = total;
		this.items = items;
	}

    // Getters and setters
    
}
