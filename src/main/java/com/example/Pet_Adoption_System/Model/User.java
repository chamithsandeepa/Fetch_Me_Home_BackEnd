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
    private ERole role;

    @JsonIgnore
    private List<Pet> adoptedPets = new ArrayList<>();
    
    private List<PetsDTO> favourites = new ArrayList<>();

    private ERole role;

}