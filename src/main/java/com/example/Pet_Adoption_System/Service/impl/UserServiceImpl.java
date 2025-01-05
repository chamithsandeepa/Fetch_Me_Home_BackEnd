package com.example.Pet_Adoption_System.Service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.Pet_Adoption_System.Model.User;
import com.example.Pet_Adoption_System.Repository.UserRepository;
import com.example.Pet_Adoption_System.Service.UserService; 
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserServiceImpl implements UserService{

    @Autowired
    private UserRepository userRepository;

    @Override
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

        return userRepository.save(user);
    }

    @Override
    public User LoginUser(String email, String password) {
        User user = userRepository.findByEmail(email);
        if (user!= null && user.getPassword().equals(password)) {
            return user;
        }else {
            throw new RuntimeException("Invalid Login");
        }
    }

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public User authenticateUser(String email, String password) {
        User user = userRepository.findByEmail(email);

        // Verify the plain-text password (not secure; better to hash passwords in production)
        if (user != null && user.getPassword().equals(password)) {
            return user;
        }
        return null;
    }

    @Override
    public User getUserById(String id) {
       Optional<User> user = userRepository.findById(id);
       return user.orElse(null);
    }

    @Override
    public User updateUser(String id, User user) {
        if (userRepository.existsById(id)) {
            user.setId(id);
            return userRepository.save(user);
    }
    return null;
}

    @Override
    public void deleteUser(String id) {
        userRepository.deleteById(id);
    }

}
