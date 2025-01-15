package com.example.Pet_Adoption_System.Service.impl;

import com.example.Pet_Adoption_System.Model.PetSearch;
import com.example.Pet_Adoption_System.Repository.PetSearchRepository;
import com.example.Pet_Adoption_System.Service.PetSearchService;
import com.example.Pet_Adoption_System.Service.PetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

import static java.util.Locale.filter;

@Service
public class PetSearchServiceImpl implements PetSearchService {
    @Autowired
    private PetSearchRepository petSearchRepository;

    @Override
    public List<PetSearch> findBySpecies(String species, String sex) {
        return PetService.stream()
                .filter(pet -> (species == null || pet.getSpecies().equalsIgnoreCase(species)) &&
                        (gender == null || pet.getGender().equalsIgnoreCase(gender)))
                .collect(Collectors.toList());
}
}
