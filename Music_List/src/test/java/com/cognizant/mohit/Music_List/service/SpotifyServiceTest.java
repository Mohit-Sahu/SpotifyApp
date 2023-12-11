/**
 * 
 */
package com.cognizant.mohit.Music_List.service;

/**
 * @author mohit
 *
 */
import com.cognizant.mohit.Music_List.dao.AlbumDTO;
import com.cognizant.mohit.Music_List.service.SpotifyService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.client.RestClientException;

import static org.junit.jupiter.api.Assertions.*;

class SpotifyServiceTest {

    private SpotifyService spotifyService;

    @BeforeEach
    void setUp() {
        RestTemplateBuilder restTemplateBuilder = new RestTemplateBuilder();
        String validToken = "validToken"; // Replace with a valid Spotify API token
        spotifyService = new SpotifyService(restTemplateBuilder, validToken);
    }

    @Test
    void getAlbumWithValidAlbumIdShouldReturnAlbumDTO() {
        String validAlbumId = "4aawyAB9vmqN3uQ7FjRGTy";
        AlbumDTO albumDTO = spotifyService.getAlbum(validAlbumId);

        assertNotNull(albumDTO);
        assertEquals(validAlbumId, albumDTO.getId(), "The returned album ID should match the requested album ID");
        assertNotNull(albumDTO.getName(), "The album should have a name");
        assertNotNull(albumDTO.getArtists(), "The album should have artists");
        assertTrue(albumDTO.getArtists().size() > 0, "The album should have at least one artist");
    }


    @Test
    void getAlbumWithInvalidAlbumIdShouldThrowException() {
        String invalidAlbumId = "as1f2f3"; // Replace with an invalid album ID
        assertThrows(RestClientException.class, () -> {
            spotifyService.getAlbum(invalidAlbumId);
        });
    }

    @Test
    void getAlbumWithNullAlbumIdShouldThrowException() {
        assertThrows(IllegalArgumentException.class, () -> {
            spotifyService.getAlbum(null);
        });
    }

    @Test
    void getAlbumWithEmptyAlbumIdShouldThrowException() {
        assertThrows(IllegalArgumentException.class, () -> {
            spotifyService.getAlbum("");
        });
    }
}
