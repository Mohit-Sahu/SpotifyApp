/**
 * 
 */
package com.cognizant.mohit.Music_List.dao;

/**
 * @author mohit
 *
 */
public class ArtistsDTO {
   // private ExternalUrlsDTO external_urls;
    private String href;
    private String id;
    private String name;
    private String type;

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
	 * @param href
	 * @param id
	 * @param name
	 * @param type
	 * @param uri
	 */
	public ArtistsDTO(String href, String id, String name, String type) {
		super();
		this.href = href;
		this.id = id;
		this.name = name;
		this.type = type;
	}

    // Getters and setters
    
}