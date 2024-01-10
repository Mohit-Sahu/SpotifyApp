/**
 * 
 */
package com.cognizant.mohit.Music_List.service;
import com.cognizant.mohit.Music_List.dto.AlbumDTO;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import org.springframework.web.client.RestTemplate;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

class SpotifyServiceTest {

    @Mock
    private RestTemplate restTemplate;

    @InjectMocks
    private SpotifyService spotifyService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @SuppressWarnings("unchecked")
	@Test
    void searchSpotify_Success() {
        String query = "test";
        String type = "track";
        String responseBody = "Mocked Spotify Search Response";

        when(restTemplate.getForObject(any(String.class), any(Class.class)))
                .thenReturn(responseBody);

        Object result = spotifyService.searchSpotify(query, type);

        assertEquals(responseBody, result);
    }

    @SuppressWarnings("unchecked")
	@Test
    void getAlbum_Success() {
        String albumId = "123";
        AlbumDTO mockedAlbum = new AlbumDTO("Test Album", 0, "Artist", "2022", "http://example.com/cover.jpg", albumId, albumId, null, null);

        when(restTemplate.getForObject(any(String.class), any(Class.class)))
                .thenReturn(mockedAlbum);

        AlbumDTO result = spotifyService.getAlbum(albumId);

        assertEquals(mockedAlbum, result);
    }
}
