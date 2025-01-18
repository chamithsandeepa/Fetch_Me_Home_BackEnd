package com.example.Pet_Adoption_System.Controller;

import com.example.Pet_Adoption_System.Model.PetSearch;
import com.example.Pet_Adoption_System.Service.PetSearchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping({"/api/petsearch"})
@CrossOrigin("*")
public class PetSearchController {
    @Autowired
    private PetSearchService petSearchService;
    @GetMapping("/search")
    public List<PetSearch> searchPet(
            @RequestParam(required = false) String species,
            @RequestParam(required = false) String gender,
            @RequestParam(required = false) Integer age,
            @RequestParam(required = false) String color
    ){
        return petSearchService.searchPet(species,gender,age,color);
    }

}
