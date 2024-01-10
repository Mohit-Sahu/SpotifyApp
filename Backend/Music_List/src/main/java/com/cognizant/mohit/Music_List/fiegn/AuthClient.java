///**
// * 
// */
//package com.cognizant.mohit.Music_List.fiegn;
//
//
//import org.springframework.cloud.openfeign.FeignClient;
///**
// * @author mohit
// *
// */
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestHeader;
//
//@FeignClient(name = "AUTHENTICATION-SERVICE",url="http://localhost:9090/api/v1.0/authentication")
//public interface AuthClient {
//	
//	@PostMapping("/validate")
//	public ResponseEntity<?> validateToken(@RequestHeader("Authorization") String token);
//}
