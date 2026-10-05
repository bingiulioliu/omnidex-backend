package com.java.projectwork.omnidex_backend.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.java.projectwork.omnidex_backend.exception.ResourceNotFoundException;
import com.java.projectwork.omnidex_backend.model.Relic;
import com.java.projectwork.omnidex_backend.repository.RelicRepository;

@Service 
public class RelicService {
    
    private final RelicRepository relicRepository;

    public RelicService (RelicRepository relicRepository) {
        this.relicRepository = relicRepository;
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
            .orElseThrow(() -> new ResourceNotFoundException("Reliquia con ID: " + id + " non trovata."));
        
    }

    public Relic create (Relic relic){
        
        // Tolto check se esiste nome per unique = true nella entity 
        // if (relicRepository.existsByNameIgnoreCase(relic.getName().trim())){
        //    throw new IllegalArgumentException("Esiste già una reliqui dal nome: " + relic.getName());
        // }  
        
        return relicRepository.save(relic);
    }

    public Relic update (Integer id, Relic relic){

        // riutilizzo findById
        Relic relicAttempt = this.findById(id);

        // Copio i dati da relic a relicAttempt
        relicAttempt.setName(relic.getName());
        relicAttempt.setDescription(relic.getDescription());
        relicAttempt.setImgUrl(relic.getImgUrl());
        relicAttempt.setCategories(relic.getCategories());
        relicAttempt.setUniverse(relic.getUniverse());

        // Salvo l'oggetto aggiornato
        return relicRepository.save(relicAttempt);
            
    }

    public void deleteById(Integer id){

        // Check se la reliquia esiste
        Relic relicAttempt = this.findById(id);

        relicRepository.delete(relicAttempt);
    }

}
