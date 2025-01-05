package com.example.Pet_Adoption_System.DTO;

import lombok.Data;
import java.util.List;

@Data
public class PetsDTO {
    private String name;

    private List<String> images;

    private String description;
    private Integer id;

    
}
