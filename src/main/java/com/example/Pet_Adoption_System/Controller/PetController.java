package com.example.Pet_Adoption_System.Controller;

import com.example.Pet_Adoption_System.Model.Pet;
import com.example.Pet_Adoption_System.Service.PetService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/pets")
@CrossOrigin
@Tag(name="PetController",description="To perform operations on Pet")
public class PetController {

    @Autowired
    private PetService petService;

    @Operation(
            summary = "POST operation on Pet",
            description = "It is used to save Pets in database"
    )
    @PostMapping
    public ResponseEntity<Pet> addPet(@RequestBody Pet pet) {
        // Log received data for debugging
        System.out.println("Received Pet: " + pet);

        Pet savedPet = petService.addPet(pet);
        return ResponseEntity.ok(savedPet);
    }

    @Operation(
            summary = "GET operation on Pet",
            description = "It is used to get All Pets from database"
    )
    @GetMapping
    public ResponseEntity<List<Pet>> getAllPets() {
        List<Pet> pets = petService.getAllPets();
        return ResponseEntity.ok(pets);
    }

    @Operation(
            summary = "GET operation on Pet",
            description = "It is used to get Pets from database"
    )
    @GetMapping("/{id}")
    public ResponseEntity<Pet> getPetById(@PathVariable String id) {
        Pet pet = petService.getPetById(id);
        return ResponseEntity.ok(pet);
    }

    @Operation(
            summary = "DELETE operation on Pet",
            description = "It is used to delete Pets details in database"
    )
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePet(@PathVariable String id) {
        petService.deletePet(id);
        return ResponseEntity.ok().build();
    }
}
