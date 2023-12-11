///**
// * 
// */
//package com.cognizant.mohit.Music_List.service;
//
///**
// * @author mohit
// *
// */
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpHeaders;
//import org.springframework.http.HttpMethod;
//import org.springframework.http.MediaType;
//import org.springframework.http.ResponseEntity;
//import org.springframework.stereotype.Service;
//import org.springframework.web.client.RequestCallback;
//import org.springframework.web.client.RestTemplate;
//import org.springframework.web.util.UriComponentsBuilder;
//
//import com.cognizant.mohit.Music_List.config.SpotifyApiConfig;
//
//import java.util.Base64;
//import java.util.Collections;
//
//@Service
//public class SpotifyAuthService {
//
//    @Autowired
//    private SpotifyApiConfig spotifyApiConfig;
//
//    @Autowired
//    private RestTemplate restTemplate;
//    
//
//
//    public String getAccessToken() {
//        HttpHeaders headers = new HttpHeaders();
//        headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
//
//        String clientIdAndSecret = spotifyApiConfig.getClientId() + ":" + spotifyApiConfig.getClientSecret();
//        String base64ClientIdAndSecret = Base64.getEncoder().encodeToString(clientIdAndSecret.getBytes());
//
//        headers.set("Authorization", "Basic " + base64ClientIdAndSecret);
//
//        UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(spotifyApiConfig.getTokenUrl())
//                .queryParam("grant_type", "client_credentials");
//
//        ResponseEntity<String> response = restTemplate.exchange(
//                builder.toUriString(),
//                HttpMethod.POST,
//                null,
//                String.class
//        );
//        System.out.println(response);
//
//        // Parse the response to get the access token
//        // Add your own logic here based on the Spotify API response format
//        String accessToken = response.getBody(); // TODO: Parse the access token from the response
//
//        return accessToken;
//    }
//}
