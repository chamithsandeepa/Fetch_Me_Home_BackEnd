package com.example.Pet_Adoption_System.Service;

import com.example.Pet_Adoption_System.Model.ApplyPet;
import com.example.Pet_Adoption_System.Repository.ApplyPetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ApplyPetService {

    @Autowired
    private ApplyPetRepository applyPetRepository;

    public ApplyPet saveApplication(ApplyPet applyPet) {
        return applyPetRepository.save(applyPet);
    }

    public List<ApplyPet> getAllApplications() {
        return applyPetRepository.findAll();
    }

    public ApplyPet getApplicationById(String id) {
        return applyPetRepository.findById(id).orElse(null);
    }

    public void deleteApplication(String id) {
        applyPetRepository.deleteById(id);
    }
}
