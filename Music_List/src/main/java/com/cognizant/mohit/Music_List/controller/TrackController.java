/**
 * 
 */
package com.cognizant.mohit.Music_List.controller;

import java.util.List;

/**
 * @author mohit
 *
 */
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cognizant.mohit.Music_List.dao.SpotifyDTO;
import com.cognizant.mohit.Music_List.model.Track;
import com.cognizant.mohit.Music_List.service.SpotifyService;

@RestController
public class TrackController {

    private final SpotifyService spotifyService;

    @Autowired
    public TrackController(SpotifyService spotifyService) {
        this.spotifyService = spotifyService;
    }

    @GetMapping("/tracks")
    public SpotifyDTO getTracks(@RequestParam String trackIds) {
        return spotifyService.getTracks(trackIds);
    }
    
    @GetMapping("/albums/{albumId}")
    public ResponseEntity<?> getAlbum(@PathVariable String albumId) {
    	
        return spotifyService.getAlbum(albumId);
    }
}

