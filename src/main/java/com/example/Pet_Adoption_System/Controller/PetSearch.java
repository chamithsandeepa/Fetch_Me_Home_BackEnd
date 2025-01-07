package com.example.Pet_Adoption_System.Controller;

import com.example.Pet_Adoption_System.Service.PetSearchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/api/pets")
@RestController
@CrossOrigin(origins = "*")
public class PetSearch {
   @Autowired
    private PetSearchService petSearchService;

    @GetMapping("/filter")
    public List<com.example.Pet_Adoption_System.Model.PetSearch> filterBySpecies(@RequestParam(required = false) String species) {
        return petSearchService.filterBySpecies(species);
    }

}
