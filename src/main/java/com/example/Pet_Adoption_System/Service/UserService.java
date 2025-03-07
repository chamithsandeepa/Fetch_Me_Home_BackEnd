package com.example.Pet_Adoption_System.Service;

import com.example.Pet_Adoption_System.Model.User;
import com.example.Pet_Adoption_System.Repository.UserRepository;
import com.example.Pet_Adoption_System.Util.PasswordEncoderUtil; // Import the utility class

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoderUtil passwordEncoderUtil; // Inject the password encoder utility

    public User registerUser(User user) {
        // Check if email already exists
        User existingUser = userRepository.findByEmail(user.getEmail());
        if (existingUser != null) {
            throw new RuntimeException("Email already registered.");
        }

        // Check if password and confirmPassword match
        if (!user.getPassword().equals(user.getConfirmPassword())) {
            throw new RuntimeException("Passwords do not match.");
        }

        // Hash the password before saving
        String hashedPassword = passwordEncoderUtil.hashPassword(user.getPassword());
        user.setPassword(hashedPassword);
        user.setConfirmPassword(hashedPassword); // Optional: Clear confirmPassword after hashing

        return userRepository.save(user);
    }

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public User authenticateUser(String email, String password) {
        User user = userRepository.findByEmail(email);

        if (user == null) {
            throw new RuntimeException("User not found.");
        }

        // Verify the hashed password
        if (!passwordEncoderUtil.verifyPassword(password, user.getPassword())) {
            throw new RuntimeException("Invalid credentials.");
        }

        return user;
    }

    public User updateUser(String id, User user) {
        User existingUser = userRepository.findById(id).orElseThrow(() -> new RuntimeException("User not found"));

        // Update user details
        existingUser.setName(user.getName());
        existingUser.setEmail(user.getEmail());

        // Hash the new password before saving (if password is being updated)
        if (user.getPassword() != null && !user.getPassword().isEmpty()) {
            String hashedPassword = passwordEncoderUtil.hashPassword(user.getPassword());
            existingUser.setPassword(hashedPassword);
        }

        return userRepository.save(existingUser);
    }

    public void deleteUser(String id) {
        User user = userRepository.findById(id).orElseThrow(() -> new RuntimeException("User not found"));
        userRepository.delete(user);
    }

    // Additional method to find user by email
    public User findUserByEmail(String email) {
        return userRepository.findByEmail(email);
    }
}