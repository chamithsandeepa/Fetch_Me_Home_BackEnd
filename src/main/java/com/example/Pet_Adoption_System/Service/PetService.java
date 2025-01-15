package com.example.Pet_Adoption_System.Service;

import com.example.Pet_Adoption_System.Model.Pet;
import com.example.Pet_Adoption_System.Repository.PetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface PetService {
    

    Pet addPet(Pet pet);
    Pet getPetById(String id);
    List<Pet> getAllPets();
    Pet updatePet(String id, Pet pet);
    void  deletePet(String id);
    List<Pet> getAvailablePets(Boolean adopted);
    Pet adoptPet(String id);
    List<Pet> getPetsBySex(String sex);
    List<Pet> getPetsByBreed(String breed);

}
