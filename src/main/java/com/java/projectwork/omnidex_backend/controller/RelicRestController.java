package com.java.projectwork.omnidex_backend.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.java.projectwork.omnidex_backend.model.Relic;
import com.java.projectwork.omnidex_backend.service.RelicService;

// Da passare a React solo chiamate GET
@RestController 
@RequestMapping ("/api/relics")
public class RelicRestController {
    
    private final RelicService relicService;

    public RelicRestController (RelicService relicService){
        this.relicService = relicService;
    }

    // INDEX
    @GetMapping
    public List<Relic> index(String name){
        List<Relic> relics = relicService.findRelics(name);
        return relics;
    }

    // SHOW
    @GetMapping ("/{id}") 
    public ResponseEntity<Relic> show (@PathVariable Integer id){
        Relic relic = relicService.findById(id);
        return ResponseEntity.ok(relic);
    }
}
