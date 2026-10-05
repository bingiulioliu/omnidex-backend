package com.java.projectwork.omnidex_backend.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.java.projectwork.omnidex_backend.exception.RelicNotFoundException;
import com.java.projectwork.omnidex_backend.model.Relic;
import com.java.projectwork.omnidex_backend.repository.CategoryRepository;
import com.java.projectwork.omnidex_backend.repository.RelicRepository;
import com.java.projectwork.omnidex_backend.repository.UniverseRepository;

@Service 
public class RelicService {
    
    private final RelicRepository relicRepository;
    private final CategoryRepository categoryRepository;
    private final UniverseRepository universeRepository;

    public RelicService (
        RelicRepository relicRepository,
        CategoryRepository categoryRepository,
        UniverseRepository universeRepository
    ) {
        this.relicRepository = relicRepository;
        this.categoryRepository = categoryRepository;
        this.universeRepository = universeRepository;
    }

    public List<Relic> findRelics(String name){
        // Se request param è vuoto restituisci tutto
        if (name == null || name.isBlank()){
            return relicRepository.findAll();
        }
        // altrimenti cerca valore di request param
        String trimmedName = name.trim();
        return relicRepository.findByNameContainingIgnoringCase(trimmedName);
    }

    public Relic findById(Integer id){
        return relicRepository.findById(id)
            .orElseThrow(() -> new RelicNotFoundException("Reliquia con ID: " + id + " non trovata."));
        
    }

}
