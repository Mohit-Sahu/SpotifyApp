///**
// * 
// */
//package com.cognizant.mohit.Music_List.controller;
//
///**
// * @author mohit
// *
// */
//import org.junit.jupiter.api.Test;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.boot.test.mock.mockito.MockBean;
//import org.springframework.http.MediaType;
//import org.springframework.test.web.servlet.MockMvc;
//import org.springframework.test.web.servlet.MvcResult;
//import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
//import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
//
//import static org.mockito.ArgumentMatchers.anyString;
//import static org.mockito.Mockito.when;
//
//@SpringBootTest
//@AutoConfigureMockMvc
//public class MuiscControllerTest {
//
//    @Autowired
//    private MockMvc mockMvc;
//
//    @MockBean
//    private SpotifyService spotifyService;
//
//    @Test
//    public void testGetAlbum_PositiveCase() throws Exception {
//        // Mock the behavior of the spotifyService.getAlbum method
//        AlbumDTO mockAlbumDTO = new AlbumDTO();
//        mockAlbumDTO.setTitle("Mock Album");
//        mockAlbumDTO.setArtist("Mock Artist");
//
//        when(spotifyService.getAlbum(anyString())).thenReturn(mockAlbumDTO);
//
//        // Perform the request
//        mockMvc.perform(MockMvcRequestBuilders
//                .get("/music/albums/{albumId}", "someAlbumId")
//                .contentType(MediaType.APPLICATION_JSON))
//                .andExpect(MockMvcResultMatchers.status().isOk())
//                .andExpect(MockMvcResultMatchers.jsonPath("$.title").value("Mock Album"))
//                .andExpect(MockMvcResultMatchers.jsonPath("$.artist").value("Mock Artist"));
//    }
//
//    @Test
//    public void testGetAlbum_NegativeCase() throws Exception {
//        // Mock the behavior of the spotifyService.getAlbum method to return null or throw an exception
//        when(spotifyService.getAlbum(anyString())).thenReturn(null);
//
//        // Perform the request
//        mockMvc.perform(MockMvcRequestBuilders
//                .get("/music/albums/{albumId}", "nonexistentAlbumId")
//                .contentType(MediaType.APPLICATION_JSON))
//                .andExpect(MockMvcResultMatchers.status().isNotFound());
//    }
//}
//
