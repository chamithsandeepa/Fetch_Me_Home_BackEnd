package com.example.Pet_Adoption_System.Security.JWT;

import java.io.IOException;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.util.StringUtils;
import org.springframework.web.filter.OncePerRequestFilter;

import com.example.Pet_Adoption_System.Security.Services.UserDetailsServiceImpl;

public class AuthTokenFilter extends OncePerRequestFilter {
       
    // Injecting JwtUtils for handling JWT operations
    @Autowired
    private JwtUtils jwtUtils;

    // Injecting UserDetailsServiceImpl to load user details by username
    @Autowired
    private UserDetailsServiceImpl userDetailsService;

           // Logger for error logging
    private static final Logger logger = LoggerFactory.getLogger(AuthTokenFilter.class);

           // Overriding doFilterInternal to filter each request
    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
        throws ServletException, IOException {
      try {
                     // Extract the JWT from the request
        String jwt = parseJwt(request);
                     
             // If the JWT exists and is valid
        if (StringUtils.hasText(jwt) && jwtUtils.validateJwtToken(jwt)) {
              // Extract username from the valid JWT
          String username = jwtUtils.getUserNameFromJwtToken(jwt);
            // Load user details using the username
          UserDetails userDetails = userDetailsService.loadUserByUsername(username);
            // Create an authentication token for the user
          UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(userDetails, null,
              userDetails.getAuthorities());
          
               // Set details on the authentication token
          authentication.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
                         // Set the authentication context with the token
          SecurityContextHolder.getContext().setAuthentication(authentication);
        }
                     // Log error if authentication fails
      } catch (Exception e) {
        logger.error("Cannot set user authentication: {}", e);
      }
            // Continue with the filter chain after authentication check
               filterChain.doFilter(request, response);
    }
      // Method to extract the JWT from the Authorization header
    private String parseJwt(HttpServletRequest request) {
       // Retrieve the Authorization header from the request
      String headerAuth = request.getHeader("Authorization");
  
      if (StringUtils.hasText(headerAuth) && headerAuth.startsWith("Bearer ")) {
        return headerAuth.substring(7, headerAuth.length());
      }
  
      return null;
    }
  }


