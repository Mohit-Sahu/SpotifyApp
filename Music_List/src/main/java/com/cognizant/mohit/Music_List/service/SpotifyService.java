/**
 * 
 */
package com.cognizant.mohit.Music_List.service;

/**
 * @author mohit
 *
 */
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.cognizant.mohit.Music_List.dao.AlbumDTO;
import com.cognizant.mohit.Music_List.model.Track;

import java.util.Collections;
import java.util.List;

@Service
public class SpotifyService {

    @Value("${spotify.api.url}")
    private String spotifyApiUrl;

    private final RestTemplate restTemplate;

    // Inject the token via constructor
    public SpotifyService(RestTemplateBuilder restTemplateBuilder,
                          @Value("${spotify.api.token}") String spotifyApiToken) {
        this.restTemplate = restTemplateBuilder
                .defaultHeader(HttpHeaders.AUTHORIZATION, "Bearer " + spotifyApiToken)
                .build();
    }

    public String getTracks(String trackIds) {
        String apiUrl = spotifyApiUrl +"/tracks/" + "?ids=" + trackIds;
        return restTemplate.getForObject(apiUrl, String.class);
    }
    
    public AlbumDTO getAlbum(String albumId) {
    	   String apiUrl = spotifyApiUrl + "/albums/" + albumId;
    	 return restTemplate.getForObject(apiUrl, AlbumDTO.class);
      
    }
}
