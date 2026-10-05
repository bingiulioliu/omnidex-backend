package com.java.projectwork.omnidex_backend.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

@Entity 
@Table (name = "categories")
public class Category {
    
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Integer id;

    @Size (min = 3, max = 70, message = "Inserire un nome compreso tra 3 e 70 caratteri")
    @Column (nullable = false)
    @NotBlank 
    private String name;

    @NotBlank(message = "Inserire una descrizione")
    private String description;

    // Nome per l'icona dinamica da passare a React
    @Enumerated (EnumType.STRING)
    @NotBlank (message = "Inserire una chiave per l'icona")
    private String inconKey;

    // Relazione N:N con Relic
    @ManyToMany (mappedBy = "categories")
    @JsonIgnore 
    private List<Relic> relics;

    // Getter e Setter
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
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

    public String getInconKey() {
        return inconKey;
    }

    public void setInconKey(String inconKey) {
        this.inconKey = inconKey;
    }

    public List<Relic> getRelics() {
        return relics;
    }

    public void setRelics(List<Relic> relics) {
        this.relics = relics;
    }


}
