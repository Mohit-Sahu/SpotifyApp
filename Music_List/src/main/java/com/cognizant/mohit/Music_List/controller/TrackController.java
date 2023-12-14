/**
 * 
 */
package com.cognizant.mohit.Music_List.controller;




/**
 * @author mohit
 *
 */
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;

import com.cognizant.mohit.Music_List.dto.AlbumDTO;
import com.cognizant.mohit.Music_List.exception.ExternalServiceException;
import com.cognizant.mohit.Music_List.exception.InvalidCredentialsException;

import com.cognizant.mohit.Music_List.service.SpotifyService;


import feign.FeignException;



@RestController
@RequestMapping("/api/v1.0/track/")
public class TrackController {

    private final SpotifyService spotifyService;
  
  
    
//    
//    @Autowired
//    private SpotifyTokenService spotifyTokenService;
//    
//    
//    @GetMapping("/gettoken")
//    public String exampleEndpoint() {
//        String accessToken = spotifyTokenService.getAccessTokenWithRefresh();
//        return "Spotify access token: " + accessToken;
//    }


    
    @Autowired
    public TrackController(SpotifyService spotifyService) {
        this.spotifyService = spotifyService;
    }
    
    @GetMapping("/search")
    public ResponseEntity<Object> searchSpotify(
            @RequestParam(name = "query")String query,
            @RequestParam(name = "type") String type) throws InvalidCredentialsException
     {
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
    public AlbumDTO getAlbum(@PathVariable String albumId) throws InvalidCredentialsException {
    	try {
		
			
				return spotifyService.getAlbum(albumId);
			
		} catch (FeignException e) {
			throw new ExternalServiceException(e.getMessage());
		}
        
    }
}

