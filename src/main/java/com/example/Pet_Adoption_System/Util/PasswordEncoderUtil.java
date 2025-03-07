package com.example.Pet_Adoption_System.Util;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

@Component // Mark it as a Spring component for dependency injection
public class PasswordEncoderUtil {

    private static final BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

    // Method to hash a password
    public String hashPassword(String password) {
        return encoder.encode(password);
    }

    // Method to verify a password
    public boolean verifyPassword(String rawPassword, String hashedPassword) {
        return encoder.matches(rawPassword, hashedPassword);
    }
}