package com.example.Pet_Adoption_System.Model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;
import lombok.NoArgsConstructor;

@Document(collection = "Users")
@Data
@NoArgsConstructor
public class User {
    @Id
    private String id;
    private String name; // Changed from separate firstName and lastName
    private String email;
    private String password;
    private String confirmPassword; // Add this field for password confirmation

    // Getter for full name if needed
    public String getFullName() {
        return name;
    }

    // Getter for name
    public String getName() {
        return name;
    }

    // Setter for name
    public void setName(String name) {
        this.name = name;
    }

    // Getter for email
    public String getEmail() {
        return email;
    }

    // Setter for email
    public void setEmail(String email) {
        this.email = email;
    }

    // Getter for password
    public String getPassword() {
        return password;
    }

    // Setter for password
    public void setPassword(String password) {
        this.password = password;
    }

    // Getter for confirmPassword
    public String getConfirmPassword() {
        return confirmPassword;
    }

    // Setter for confirmPassword
    public void setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
    }
}
