package com.java.projectwork.omnidex_backend.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.java.projectwork.omnidex_backend.exception.ResourceNotFoundException;
import com.java.projectwork.omnidex_backend.model.Universe;
import com.java.projectwork.omnidex_backend.repository.UniverseRepository;

@Service 
public class UniverseService {
    
    private final UniverseRepository universeRepository;

    public UniverseService (UniverseRepository universeRepository){
        this.universeRepository = universeRepository;
    }

    public List<Universe> findAll(){
        return universeRepository.findAll();
    }

    public Universe findById(Integer id){
        return universeRepository.findById(id)
            .orElseThrow(() -> new ResourceNotFoundException("Universo con ID: " + id + " non trovato."));
    }

    public Universe create (Universe universe){
        // Tolto check se esiste nome per unique = true nella Entity
        // if (relicRepository.existsByNameIgnoreCase(universe.getName().trim())){
        //    throw new IllegalArgumentException("Esiste già un Universo con il nome: " + universe.getName());
        // }
        return universeRepository.save(universe);
    }

    public Universe update (Universe universe, Integer id){
        // Riutilizza findById
        Universe universeAttempt = this.findById(id);

        universeAttempt.setName(universe.getName());
        universeAttempt.setDescription(universe.getDescription());

        return universeRepository.save(universeAttempt);
    }

    public void deleteById (Integer id){
        // Riutilizza findById
        Universe universeAttemp = this.findById(id);

        universeRepository.delete(universeAttemp);
    }
}
