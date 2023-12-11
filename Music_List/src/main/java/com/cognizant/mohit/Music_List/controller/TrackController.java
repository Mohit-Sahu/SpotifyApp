/**
 * 
 */
package com.cognizant.mohit.Music_List.controller;

import java.util.List;
import java.util.Map;

/**
 * @author mohit
 *
 */
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;

import com.cognizant.mohit.Music_List.dao.AlbumDTO;
import com.cognizant.mohit.Music_List.exception.ExternalServiceException;
import com.cognizant.mohit.Music_List.exception.InvalidCredentialsException;
import com.cognizant.mohit.Music_List.fiegn.AuthClient;
import com.cognizant.mohit.Music_List.model.Track;
import com.cognizant.mohit.Music_List.service.SpotifyService;

import feign.FeignException;
import io.swagger.v3.oas.annotations.Parameter;


@RestController
@RequestMapping("/api/v1.0/track/")
public class TrackController {

    private final SpotifyService spotifyService;
  
    private final AuthClient authClient;
    

    
    @Autowired
    public TrackController(SpotifyService spotifyService, AuthClient authClient) {
        this.spotifyService = spotifyService;
        this.authClient = authClient;
    }
    
    @GetMapping("/search")
    public ResponseEntity<Object> searchSpotify(
            @RequestParam(name = "query", required = false) String query,
            @RequestParam(name = "type", required = false) String type
    ) {
        if (query == null || type == null) {
            return ResponseEntity.badRequest().body("Both 'query' and 'type' parameters are required.");
        }

        try {
            // Call the SpotifyService to perform the search
            Object result = spotifyService.searchSpotify(query, type);
            return ResponseEntity.ok(result);
        } catch (Exception e) {
            // Handle exceptions and return an error response
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error occurred during the Spotify API request.");
        }
    }

    
    @GetMapping(value = "/albums/{albumId}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public AlbumDTO getAlbum(@PathVariable String albumId,@Parameter(hidden = true) @RequestHeader("Authorization") String token) throws InvalidCredentialsException {
    	try {
			Map<String, String> userInfo = (Map<String, String>) authClient.validateToken(token).getBody();
			if (userInfo.containsValue("ROLE_ADMIN") || userInfo.containsValue("ROLE_CUSTOMER")) {
				return spotifyService.getAlbum(albumId);
			} else {
				throw new InvalidCredentialsException("Access Denied");
			}
		} catch (FeignException e) {
			throw new ExternalServiceException(e.getMessage());
		}
        
    }
}

