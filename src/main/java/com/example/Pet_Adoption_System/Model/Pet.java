package com.example.Pet_Adoption_System.Model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.AllArgsConstructor;

@Document(collection = "Pets")
@Data
@Getter
@NoArgsConstructor
@Setter
@AllArgsConstructor
public class Pet {
    @Id
    private Integer id;
    private String name;
    private String species;
    private String breed;
    private Integer age;
    private String sex;
    private String status;
    private String description;

    //Getters and Setters


}



