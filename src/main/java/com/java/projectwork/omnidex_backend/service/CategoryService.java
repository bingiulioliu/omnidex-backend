package com.java.projectwork.omnidex_backend.service;

import java.util.List;


import org.springframework.stereotype.Service;

import com.java.projectwork.omnidex_backend.exception.ResourceNotFoundException;
import com.java.projectwork.omnidex_backend.model.Category;
import com.java.projectwork.omnidex_backend.repository.CategoryRepository;

@Service 
public class CategoryService {
    
    private final CategoryRepository categoryRepository;

    public CategoryService (CategoryRepository categoryRepository){
        this.categoryRepository = categoryRepository;
    }

    public List<Category> findAll(){
        return categoryRepository.findAll();
    }

    public Category findById (Integer id){
        return categoryRepository.findById(id)
            .orElseThrow(() -> new ResourceNotFoundException("Categoria con ID " + id + " non trovata."));
    }

    public Category create (Category category){
        return categoryRepository.save(category);
    }

    public Category update (Category category, Integer id){
        Category categoryAttemp = this.findById(id);

        categoryAttemp.setName(category.getName());
        categoryAttemp.setDescription(category.getDescription());

        return categoryRepository.save(categoryAttemp);
    }

    public void deleteById (Integer id){
        Category categoryAttempt = this.findById(id);

        categoryRepository.delete(categoryAttempt);
    }
}
