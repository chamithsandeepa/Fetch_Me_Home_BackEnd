package com.example.Pet_Adoption_System.Model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.example.Pet_Adoption_System.DTO.PetsDTO;
import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Document(collection = "Users")
@Data
@Getter
@Setter
@AllArgsConstructor
public class User {

    @Id
    private String id;
    private String username;
    private String email;
    private String password;
    private String confirmPassword;
<<<<<<< HEAD
    private ERole role;

    @JsonIgnore
    private List<Pet> adoptedPets = new ArrayList<>();
    
    private List<PetsDTO> favourites = new ArrayList<>();
 
=======
    private ERole role;// Add this field for password confirmation

    // Getter for full name if needed
    public String getFullName() {
        return name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public ERole getRole() {
        return role;
    }

    public void setRole(ERole role) {
        this.role = role;
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
>>>>>>> main
}

