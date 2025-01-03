package com.example.Pet_Adoption_System.Controller;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.Pet_Adoption_System.Model.Pet;
import com.example.Pet_Adoption_System.Service.PetService;

@RestController
@CrossOrigin
@RequestMapping("api/pets")
public class PetController {

    @Autowired
    private PetService petService;

    @GetMapping
    public ResponseEntity<List<Pet>> getAllPets() {
        List<Pet> pets = petService.getAllPets();
        return ResponseEntity.ok(pets);
    }
}
