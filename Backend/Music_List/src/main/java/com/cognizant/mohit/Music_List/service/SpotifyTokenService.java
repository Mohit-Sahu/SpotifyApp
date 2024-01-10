//package com.cognizant.mohit.Music_List.service;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.http.HttpEntity;
//import org.springframework.http.HttpHeaders;
//import org.springframework.http.MediaType;
//import org.springframework.http.ResponseEntity;
//import org.springframework.stereotype.Service;
//import org.springframework.util.LinkedMultiValueMap;
//import org.springframework.util.MultiValueMap;
//import org.springframework.web.client.RestTemplate;
//
//import java.util.Base64;
//import java.util.HashMap;
//import java.util.Map;
//
//@Service
//public class SpotifyTokenService {
//
//    private final RestTemplate restTemplate;
//
//    private final String clientId;
//    private final String clientSecret;
//    private String accessToken;
//  
//    @Autowired
//    public SpotifyTokenService(@Value("${spotify.api.client-id}") String clientId,
//            @Value("${spotify.api.client-secret}") String clientSecret,
//            RestTemplate restTemplate) {
//this.clientId = clientId;
//this.clientSecret = clientSecret;
//this.restTemplate = restTemplate;
//this.accessToken = getAccessToken();
//}
//
//    public String getAccessToken() {
//        HttpHeaders headers = new HttpHeaders();
//        headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
//        headers.setBasicAuth(clientId, clientSecret);
//        
//        
//        MultiValueMap<String, String> requestBody = new LinkedMultiValueMap<>();
//        requestBody.add("grant_type", "client_credentials");
//
//        HttpEntity<MultiValueMap<String, String>> request = new HttpEntity<>(requestBody, headers);
//
//
//        
//
//        ResponseEntity<Map> response = restTemplate.postForEntity(
//                "https://accounts.spotify.com/api/token",
//                request,
//                Map.class
//        );
//
//        if (response.getStatusCode().is2xxSuccessful()) {
//            Map<String, Object> responseBody = response.getBody();
//            if (responseBody != null && responseBody.containsKey("access_token")) {
//                accessToken = (String) responseBody.get("access_token");
//                return accessToken;
//            }
//        }
//
//        throw new RuntimeException("Unable to retrieve Spotify access token");
//    }
//
//    public String getAccessTokenWithRefresh() {
//        if (accessToken == null) {
//            return getAccessToken();
//        }
//
//        // Check if the token is about to expire (e.g., within the last 10 seconds)
//        // In production, consider using a proper library for token expiration handling
//        // This is a simplified example for demonstration purposes
//        long expiresIn = 3600; // Access token expiration time in seconds (1 hour)
//        if (System.currentTimeMillis() / 1000L + 10 >= expiresIn) {
//            return getAccessToken();
//        }
//
//        return accessToken;
//    }
//}
