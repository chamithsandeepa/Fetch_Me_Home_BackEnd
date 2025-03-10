package com.example.Pet_Adoption_System.Security.JWT;

import java.security.Key;
import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;

import com.example.Pet_Adoption_System.Security.Services.UserDetailsImpl;

import io.jsonwebtoken.*;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
@Component
public class JwtUtils {
  // Logger to log messages and errors related to JWT operations
  private static final Logger logger = LoggerFactory.getLogger(JwtUtils.class);

  // Injecting values for secret key and expiration time from application properties
  @Value("${CRUD.app.jwtSecret}")
  private String jwtSecret;

  @Value("${CRUD.app.jwtExpirationMs}")
  private int jwtExpirationMs;

  /**
   * Method to generate a JWT token for the authenticated user
   * @param authentication - the Authentication object containing user details
   * @return JWT token as a string
   */
  public String generateJwtToken(Authentication authentication) {

    // Retrieve user details from the authentication object (e.g., user email)
    UserDetailsImpl userPrincipal = (UserDetailsImpl) authentication.getPrincipal();

    // Create and return a JWT token with user details, issued time, and expiration time
    return Jwts.builder()
        .setSubject((userPrincipal.getEmail())) // Set user email as subject
        .setIssuedAt(new Date()) // Set user email as subject
        .setExpiration(new Date((new Date()).getTime() + jwtExpirationMs)) // Set token expiration time
        .signWith(key(), SignatureAlgorithm.HS256) // Sign the token with the secret key using HMAC-SHA256 algorithm
        .compact(); // Return the generated JWT token
  }

  /**
   * Method to return the signing key used to create and verify JWT tokens
   * @return Key object used for signing and verifying JWT
   */
  private Key key() {
    return Keys.hmacShaKeyFor(Decoders.BASE64.decode(jwtSecret));
  }

  public String getUserNameFromJwtToken(String token) {
    return Jwts.parserBuilder().setSigningKey(key()).build()
               .parseClaimsJws(token).getBody().getSubject();
  }

  public boolean validateJwtToken(String authToken) {
    try {
      Jwts.parserBuilder().setSigningKey(key()).build().parse(authToken);
      return true;
    } catch (MalformedJwtException e) {
      logger.error("Invalid JWT token: {}", e.getMessage());
    } catch (ExpiredJwtException e) {
      logger.error("JWT token is expired: {}", e.getMessage());
    } catch (UnsupportedJwtException e) {
      logger.error("JWT token is unsupported: {}", e.getMessage());
    } catch (IllegalArgumentException e) {
      logger.error("JWT claims string is empty: {}", e.getMessage());
    }

    return false;
  }
}


