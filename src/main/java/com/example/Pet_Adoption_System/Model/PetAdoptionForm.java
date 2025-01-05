package com.example.Pet_Adoption_System.Model;

import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Document (collection = "Pet_Adoption_Form")
@Data
@Getter
@Setter
@NoArgsConstructor
public class PetAdoptionForm {

    private String name;
    private String address;
    private long contact_no;
    
}
