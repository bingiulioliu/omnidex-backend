package com.java.projectwork.omnidex_backend.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.java.projectwork.omnidex_backend.model.Relic;
import com.java.projectwork.omnidex_backend.service.CategoryService;
import com.java.projectwork.omnidex_backend.service.RelicService;
import com.java.projectwork.omnidex_backend.service.UniverseService;

import jakarta.validation.Valid;

@Controller 
@RequestMapping ("/relics")
public class RelicViewController {
    
    private final RelicService relicService;
    private final CategoryService categoryService;
    private final UniverseService universeService;

    public RelicViewController (
        RelicService relicService,
        CategoryService categoryService,
        UniverseService universeService
    ){
        this.relicService = relicService;
        this.categoryService = categoryService;
        this.universeService = universeService;
    }

    // INDEX
    @GetMapping 
    public String index (
        @RequestParam (name = "name", required = false) String name, 
        Model model){

        List<Relic> relics = relicService.findRelics(name);

        model.addAttribute("relics", relics);
        model.addAttribute("searchName", name);
        return "relics/index";
    }

    // SHOW
    @GetMapping ("/{id}")
    public String show (@PathVariable ("id") Integer id, Model model){

        Relic relic = relicService.findById(id);
        model.addAttribute("relic", relic);

        return "/relics/relicDetail";
    }

    // CREATE
    @GetMapping ("/create")
    public String create (Model model){

        model.addAttribute("relic", new Relic());
        model.addAttribute("categories", categoryService.findAll());
        model.addAttribute("universes", universeService.findAll());

        return "/relics/create-or-edit";
    }

    @PostMapping ("/create")
    public String store (
        @Valid @ModelAttribute ("relic") Relic formRelic,
        BindingResult bindingResult,
        Model model
    ){
        if (bindingResult.hasErrors()){
            // Ricarico le liste altrimenti altrimenti Model si svuota e ritorna null
            // Per renderizzare le select
            model.addAttribute("categories", categoryService.findAll());
            model.addAttribute("universes", universeService.findAll());
            return "relics/create-or-edit";
        }
        relicService.create(formRelic);
        return "redirect:/relics";
    }

    // EDIT
    @GetMapping ("/edit/{id}")
    public String edit (@PathVariable Integer id, Model model){

        model.addAttribute("relic", relicService.findById(id));
        model.addAttribute("categories", categoryService.findAll());
        model.addAttribute("universes", universeService.findAll());

        return "relics/create-or-edit";
    }

    @PostMapping ("/edit/{id}")
    public String update (
        @PathVariable Integer id,
        @Valid @ModelAttribute ("relic")Relic formRelic,
        BindingResult bindingResult, 
        Model model){
    
        if (bindingResult.hasErrors()){
            model.addAttribute("categories", categoryService.findAll());
            model.addAttribute("universes", universeService.findAll());
            return "relics/create-or-edit";        
        }

        relicService.update(id, formRelic);

        return "redirect:/relics/" + id;
    }

    @DeleteMapping ("/delete/{id}")
    public String delete (@PathVariable Integer id){
        relicService.deleteById(id);
        return "redirect:/relics";
    }
}
