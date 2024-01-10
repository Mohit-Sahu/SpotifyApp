/**
 * 
 */
package com.cognizant.mohit.Music_List.config;

/**
 * @author mohit
 *
 */
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SpotifyApiConfig {

    @Value("${spotify.api.token-url}")
    private String tokenUrl;

    @Value("${spotify.api.client-id}")
    private String clientId;

    @Value("${spotify.api.client-secret}")
    private String clientSecret;

    public String getTokenUrl() {
        return tokenUrl;
    }

    public String getClientId() {
        return clientId;
    }

    public String getClientSecret() {
        return clientSecret;
    }
}

