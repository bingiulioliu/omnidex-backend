package com.java.projectwork.omnidex_backend.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.java.projectwork.omnidex_backend.model.Category;
import com.java.projectwork.omnidex_backend.service.CategoryService;

import jakarta.validation.Valid;

@Controller 
@RequestMapping ("/categories")
public class CategoryViewController {
    
    private final CategoryService categoryService;

    public CategoryViewController (CategoryService categoryService){
        this.categoryService = categoryService;
    }

    // INDEX
    @GetMapping 
    public String index (Model model){
        List<Category> categories = categoryService.findAll();
        model.addAttribute("categories", categories);
        return "categories/index";
    }

    // SHOW
    @GetMapping ("/{id}")
    public String show (@PathVariable ("id") Integer id, Model model){
        Category category = categoryService.findById(id);
        model.addAttribute("category", category);
        return "categories/categoryDetail";
    }

    // CREATE (FORM)
    @GetMapping ("/create")
    public String create (Model model){
        model.addAttribute("category", new Category());
        model.addAttribute("edit", false);
        return "categories/create-or-edit";
    }

    // STORE
    @PostMapping ("/create")
    public String store (
        @Valid @ModelAttribute ("category") Category formCategory,
        BindingResult bindingResult,
        Model model
    ){
        if (bindingResult.hasErrors()){
            model.addAttribute("edit", false);
            return "categories/create-or-edit";
        }
        categoryService.create(formCategory);
        return "redirect:/categories";
    }

    // EDIT (FORM)
    @GetMapping ("/edit/{id}")
    public String edit (@PathVariable Integer id, Model model){
        model.addAttribute("category", categoryService.findById(id));
        model.addAttribute("edit", true);
        return "categories/create-or-edit";
    }

    // UPDATE
    @PostMapping ("/edit/{id}")
    public String update (
        @PathVariable Integer id,
        @Valid @ModelAttribute ("category") Category formCategory,
        BindingResult bindingResult,
        Model model
    ){
        if (bindingResult.hasErrors()){
            model.addAttribute("edit", true);
            return "categories/create-or-edit";
        }

        categoryService.update(formCategory, id);
        return "redirect:/categories";
    }

    // DELETE
    @PostMapping ("delete/{id}")
    public String delete (@PathVariable Integer id){
        categoryService.deleteById(id);
        return "redirect:/categories";
    }
}
