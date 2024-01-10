/**
 * 
 */
package com.cognizant.mohit.Music_List.controller;

/**
 * @author mohit
 *
 */
import com.cognizant.mohit.Music_List.dto.AlbumDTO;
import com.cognizant.mohit.Music_List.exception.ExternalServiceException;
import com.cognizant.mohit.Music_List.exception.InvalidCredentialsException;
import com.cognizant.mohit.Music_List.service.SpotifyService;
import feign.FeignException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

class TrackControllerTest {

    @Mock
    private SpotifyService spotifyService;

    @InjectMocks
    private TrackController trackController;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void searchSpotify_Success() throws InvalidCredentialsException {
        String query = "test";
        String type = "track";
        Object mockedSearchResult = "Mocked Spotify Search Response";

        when(spotifyService.searchSpotify(query, type))
                .thenReturn(mockedSearchResult);

        ResponseEntity<Object> result = trackController.searchSpotify(query, type);

        assertEquals(HttpStatus.OK, result.getStatusCode());
        assertEquals(mockedSearchResult, result.getBody());
    }

    @Test
    void searchSpotify_MissingParameters() throws InvalidCredentialsException {
        ResponseEntity<Object> result = trackController.searchSpotify(null, null);

        assertEquals(HttpStatus.BAD_REQUEST, result.getStatusCode());
        assertEquals("Both 'query' and 'type' parameters are required.", result.getBody());
    }

    @Test
    void searchSpotify_Exception() throws InvalidCredentialsException {
        String query = "test";
        String type = "track";

        when(spotifyService.searchSpotify(query, type))
                .thenThrow(new RuntimeException("Mocked exception"));

        ResponseEntity<Object> result = trackController.searchSpotify(query, type);

        assertEquals(HttpStatus.INTERNAL_SERVER_ERROR, result.getStatusCode());
        assertEquals("Error occurred during the Spotify API request.", result.getBody());
    }

    @Test
    void getAlbum_Success() throws InvalidCredentialsException {
        String albumId = "123";
        AlbumDTO mockedAlbum = new AlbumDTO("Test Album", 0, "Artist", "2022", "http://example.com/cover.jpg", albumId, albumId, null, null);

        when(spotifyService.getAlbum(albumId))
                .thenReturn(mockedAlbum);

        AlbumDTO result = trackController.getAlbum(albumId);

        assertEquals(mockedAlbum, result);
    }

   
}

