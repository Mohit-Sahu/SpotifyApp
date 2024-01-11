/**
 * 
 */
package com.cognizant.mohit.spotify.util;

/**
 * @author mohit
 *
 */
/**
 * 
 */


/**
 * @author mohit
 *
 */



import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;



@Component
public class JwtTokenUtil {

	private static final Logger LOGGER = LoggerFactory.getLogger(JwtTokenUtil.class);

	@Value("${auth.app.jwtSecret}")
	private String jwtSecret;

	@Value("${auth.app.jwtExpireTime}")
	private int jwtExpireTime;

	

	

	public String getUserNameFromJwtToken(String token) {
		return Jwts.parser().setSigningKey(jwtSecret).parseClaimsJws(token).getBody().getSubject();
	}

	public Claims getJwtClaims(String token) {
		Claims claims = Jwts.parser().setSigningKey(jwtSecret).parseClaimsJws(token).getBody();
		return claims;
	}

	// will need this later
	public String getRoleFromToken(String token) {
		Claims claims = Jwts.parser().setSigningKey(jwtSecret).parseClaimsJws(token).getBody();

		String role = (String) claims.get("role");

		return role;
	}

	public boolean validateJwtToken(String token) throws Exception {// fix me
		String authToken = null;
		String user = null;
		if (token != null && token.startsWith("Bearer ")) {
			authToken = token.substring(7);
			try {
				user = getUserNameFromJwtToken(authToken);
				return true;
			} catch (Exception e) {
				LOGGER.warn("token not starts with Bearer");
				throw new Exception("invalid token");
			}
		}
		return false;
	}

}
