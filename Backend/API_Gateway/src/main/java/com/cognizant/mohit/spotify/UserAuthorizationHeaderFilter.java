package com.cognizant.mohit.spotify;


import java.util.Base64;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.gateway.filter.GatewayFilter;
import org.springframework.cloud.gateway.filter.factory.AbstractGatewayFilterFactory;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.http.server.reactive.ServerHttpResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;

import com.cognizant.mohit.spotify.util.JwtTokenUtil;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;

@Component
public class UserAuthorizationHeaderFilter extends AbstractGatewayFilterFactory<UserAuthorizationHeaderFilter.Config> {

    private static final Logger LOGGER = LoggerFactory.getLogger(UserAuthorizationHeaderFilter.class);

    @Autowired
    private JwtTokenUtil jwtUtils;

    @Autowired
    private Environment env;

    public UserAuthorizationHeaderFilter() {
        super(Config.class);
    }

    public static class Config {
        // You can define configuration properties here if needed
    }

    @Override
    public GatewayFilter apply(Config config) {
        return (exchange, chain) -> {
            ServerWebExchange mutatedExchange = validateJwtToken(exchange);
            return chain.filter(mutatedExchange);
        };
    }

    private ServerWebExchange validateJwtToken(ServerWebExchange exchange) {
        // capture the request and validation of token,user here
        ServerHttpRequest request = exchange.getRequest();

        if (!request.getHeaders().containsKey(HttpHeaders.AUTHORIZATION)) {
            return onError(exchange, "No authorization header", HttpStatus.UNAUTHORIZED);
        }

        String authorizationHeader = request.getHeaders().get(HttpHeaders.AUTHORIZATION).get(0);
        String jwt = authorizationHeader.replace("Bearer ", "");
        LOGGER.info("Jwt after removal of bearer: {}", jwt);

        if (!isJwtValid(jwt) || !isUser(jwt)) {
            return onError(exchange, "JWT token is not valid or does not have the admin role", HttpStatus.FORBIDDEN);
        }

        return exchange;
    }

    private ServerWebExchange onError(ServerWebExchange exchange, String err, HttpStatus httpStatus) {
        ServerHttpResponse response = exchange.getResponse();
        response.setStatusCode(httpStatus);
        return exchange;
    }

    private boolean isJwtValid(String jwt) {
        boolean returnValue = true;

        try {
            Jwts.parserBuilder()
                .setSigningKey(Base64.getEncoder().encode(env.getProperty("token.secret").getBytes()))
                .build()
                .parse(jwt);
            return true;
        } catch (Exception ex) {
            returnValue = false;
            return false;
        }
    }

    private boolean isUser(String jwt) {
        boolean returnValue = false;

        try {
            Claims claims = Jwts.parserBuilder()
                .setSigningKey(Base64.getEncoder().encode(env.getProperty("token.secret").getBytes()))
                .build()
                .parseClaimsJws(jwt)
                .getBody();

            String role = claims.get("role", String.class);
            returnValue = "User".equalsIgnoreCase(role);
        } catch (Exception ex) {
            // Handle parsing exception
        }

        return returnValue;
    }
}
