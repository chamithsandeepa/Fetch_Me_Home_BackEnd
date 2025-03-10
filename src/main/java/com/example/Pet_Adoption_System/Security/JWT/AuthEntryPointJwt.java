package com.example.Pet_Adoption_System.Security.JWT;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;
@Component
public class AuthEntryPointJwt implements AuthenticationEntryPoint {

	    // Logger for logging unauthorized access errors
	private static final Logger logger = LoggerFactory.getLogger(AuthEntryPointJwt.class);

	/**
     * This method is called when an authentication exception is thrown.
     * It handles the error and sends a response to the client.
     * @param request - the HTTP request
     * @param response - the HTTP response
     * @param authException - the exception that caused the authentication error
     * @throws IOException - if an input or output exception occurs
     * @throws ServletException - if a servlet-specific error occurs
     */

	@Override
	public void commence(HttpServletRequest request, HttpServletResponse response,
			AuthenticationException authException) throws IOException, ServletException {
		        // Log the authentication error with the exception message
		logger.error("Unauthorized error: {}", authException.getMessage());
		        // Send an HTTP 401 Unauthorized status code and a custom error message in the response
		response.sendError(HttpServletResponse.SC_UNAUTHORIZED, "Error: Unauthorized");
	}

}
