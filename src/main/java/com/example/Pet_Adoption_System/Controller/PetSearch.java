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

   @GetMapping
   public List<PetSearch> getAllPets(){
       return petSearchService.getAllPets();
   }

    @GetMapping("/filter")
    public List<com.example.Pet_Adoption_System.Model.PetSearch> filterpets
            (@RequestParam(required = false) String species),
    (@RequestParam(required = false) String gender) {
        return petSearchService.filterPets(species,gender);
    }

}
