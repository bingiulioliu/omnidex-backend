package com.java.projectwork.omnidex_backend.model;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

@Entity 
@Table (name = "relics") 
public class Relic {
    
    @Id 
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Integer id;

    @Size (max = 70, message = "Inserire massimo 70 caratteri")
    @Column (nullable = false, unique = true)
    @NotBlank
    private String name;

    @NotBlank (message = "Inserire una descrizione")
    private String description;

    @NotBlank (message = "Inserire un url per l'immagine")
    private String imgUrl;

    // Relazione N:N con Category
    @ManyToMany 
    @JoinTable (
        name = "category_relic",
        joinColumns = @JoinColumn(name = "relic.id"),
        inverseJoinColumns = @JoinColumn (name = "category.id")
    )
    private List<Category> categories;

    // Relazione N:1 con Universe
    @ManyToOne
    @JoinColumn (name = "universe_id", nullable = false)
    private Universe universe;

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

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    public List<Category> getCategories() {
        return categories;
    }

    public void setCategories(List<Category> categories) {
        this.categories = categories;
    }

    public Universe getUniverse() {
        return universe;
    }

    public void setUniverse(Universe universe) {
        this.universe = universe;
    }


}
