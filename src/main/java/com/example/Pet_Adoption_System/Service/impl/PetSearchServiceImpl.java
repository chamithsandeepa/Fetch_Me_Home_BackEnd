package com.example.Pet_Adoption_System.Service.impl;

import com.example.Pet_Adoption_System.Model.PetSearch;
import com.example.Pet_Adoption_System.Repository.PetSearchRepository;
import com.example.Pet_Adoption_System.Service.PetSearchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PetSearchServiceImpl implements PetSearchService {
    @Autowired
    private PetSearchRepository petSearchRepository;

    @Override
    public List<PetSearch> filterBySpecies(String species) {
        return petSearchRepository.findBySpecies(species);
}
}
