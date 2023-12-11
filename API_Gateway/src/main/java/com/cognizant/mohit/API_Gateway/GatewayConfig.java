///**
// * 
// */
//package com.cognizant.mohit.API_Gateway;
//
///**
// * @author mohit
// *
// */
//import org.springframework.cloud.gateway.route.RouteLocator;
//import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//
//@Configuration
//public class GatewayConfig {
//
//    @Bean
//    public RouteLocator customRouteLocator(RouteLocatorBuilder builder) {
//        return builder.routes()
//                .route("userprofile", r -> r.path("/api/v1.0/userProfile/**")
//                        .uri("http://localhost:8086"))
//                .route("wishlist", r -> r.path("/api/v1/**")
//                        .uri("http://localhost:9095"))
//                .route("authentication", r -> r.path("/api/v1/**")
//                        .uri("http://localhost:9091"))
//                .route("wishlist", r -> r.path("/api/v1/**")
//                        .uri("http://localhost:9095"))
//                .build();
//    }
//}
//
