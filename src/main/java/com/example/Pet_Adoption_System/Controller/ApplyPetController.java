package com.example.Pet_Adoption_System.Controller;

import com.example.Pet_Adoption_System.Model.ApplyPet;
import com.example.Pet_Adoption_System.Service.ApplyPetService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/apply-pet")
@CrossOrigin
@Tag(name="ApplyPetController",description="To perform operations on Apply Pets")
public class ApplyPetController {

    @Autowired
    private ApplyPetService applyPetService;



    @Operation(
            summary = "POST operation on Apply Pets",
            description = "It is used to save Apply Pets in database"
    )
    @PostMapping
    public ResponseEntity<ApplyPet> saveApplication(@RequestBody ApplyPet applyPet) {
        return ResponseEntity.ok(applyPetService.saveApplication(applyPet));
    }

    @GetMapping
    public ResponseEntity<List<ApplyPet>> getAllApplications() {
        return ResponseEntity.ok(applyPetService.getAllApplications());
    }

    @GetMapping("/{id}")
    public ResponseEntity<ApplyPet> getApplicationById(@PathVariable String id) {
        ApplyPet applyPet = applyPetService.getApplicationById(id);
        if (applyPet != null) {
            return ResponseEntity.ok(applyPet);
        }
        return ResponseEntity.notFound().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<ApplyPet> updateApplication(
            @PathVariable String id, @RequestBody ApplyPet applyPet) {
        applyPet.setId(id);
        return ResponseEntity.ok(applyPetService.saveApplication(applyPet));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteApplication(@PathVariable String id) {
        applyPetService.deleteApplication(id);
        return ResponseEntity.noContent().build();
    }
}

