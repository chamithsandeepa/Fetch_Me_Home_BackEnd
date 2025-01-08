package com.example.Pet_Adoption_System.Model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "Pet")
@Data

public class PetSearch {

    @Id
    private String id;
    private String species;
    private String Gender;


}
