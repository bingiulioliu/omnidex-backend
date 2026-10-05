package com.java.projectwork.omnidex_backend.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

@Entity 
@Table (name = "universes")
public class Universe {

    @Id 
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Integer id;

    @Size (min = 3, max = 70, message = "Inserire un nome compreso tra 3 e 70 caratteri")
    @Column (nullable = false)
    @NotBlank 
    private String name;

    @NotBlank(message = "Inserire una descrizione")
    private String description;

    // Relazione 1:N con Relic
    @OneToMany  (mappedBy = "universe", cascade = CascadeType.REMOVE)
    @JoinColumn
    @JsonIgnore 
    private List<Relic> relics;

    // GETTER E SETTER
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<Relic> getRelics() {
        return relics;
    }

    public void setRelics(List<Relic> relics) {
        this.relics = relics;
    }

    
}
