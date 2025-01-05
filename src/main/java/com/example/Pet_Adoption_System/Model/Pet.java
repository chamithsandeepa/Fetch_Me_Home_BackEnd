package com.example.Pet_Adoption_System.Model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Document(collection = "Pets")
@Data
@Getter
@NoArgsConstructor
@Setter
public class Pet {
    @Id
    private Integer id;
    private String name;
    private String species;
    private String breed;
    private Integer age;
    private String sex;
    private boolean adopted = false; //default: false
    private String description;

    //Getters and Setters


}



