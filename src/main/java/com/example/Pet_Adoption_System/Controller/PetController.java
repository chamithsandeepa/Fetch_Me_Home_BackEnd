package com.example.Pet_Adoption_System.Controller;

import com.example.Pet_Adoption_System.Model.Pet;
import com.example.Pet_Adoption_System.Service.PetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/pets")
@CrossOrigin
public class PetController {

    @Autowired
    private PetService petService;

    @PostMapping
    public ResponseEntity<Pet> addPet(@RequestBody Pet pet) {
        // Log received data for debugging
        System.out.println("Received Pet: " + pet);

        Pet savedPet = petService.addPet(pet);
        return ResponseEntity.ok(savedPet);
    }

    @GetMapping("/allPets")
    public ResponseEntity<List<Pet>> getAllPets() {
        List<Pet> pets = petService.getAllPets();
        return ResponseEntity.ok(pets);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Pet> getPetById(@PathVariable String id) {
        Pet pet = petService.getPetById(id);
        return ResponseEntity.ok(pet);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePet(@PathVariable String id) {
        petService.deletePet(id);
        return ResponseEntity.ok().build();
    }
}
