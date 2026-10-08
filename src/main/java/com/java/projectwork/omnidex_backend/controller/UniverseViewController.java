package com.java.projectwork.omnidex_backend.controller;

import com.java.projectwork.omnidex_backend.service.RelicService;
import java.util.List;

import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.java.projectwork.omnidex_backend.model.Universe;
import com.java.projectwork.omnidex_backend.service.UniverseService;

import jakarta.validation.Valid;

@Controller 
@RequestMapping ("/universes")
public class UniverseViewController {
    
    private final RelicService relicService;
    private final UniverseService universeService;

    public UniverseViewController (UniverseService universeService, RelicService relicService){
        this.universeService = universeService;
        this.relicService = relicService;
    }

    // INDEX
    @GetMapping 
    public String index (Model model){
        List<Universe> universes = universeService.findAll();
        model.addAttribute("universes", universes);
        return "universes/index";
    }

    // SHOW
    @GetMapping ("/{id}")
    public String show (@PathVariable ("id") Integer id, Model model){
        Universe universe = universeService.findById(id);
        model.addAttribute("universe", universe);
        return "universes/universeDetail";
    }

    // CREATE (FORM)
    @GetMapping ("/create")
    public String create (Model model){
        model.addAttribute("universe", new Universe());
        model.addAttribute("edit", false);
        return "universes/create-or-edit";
    }

    // STORE
    @PostMapping ("/create")
    public String store (
        @Valid @ModelAttribute ("universe") Universe formUniverse,
        BindingResult bindingResult,
        Model model
    ){
        if (bindingResult.hasErrors()){
            model.addAttribute("edit", false);
            return "universes/create-or-edit";
        }
        universeService.create(formUniverse);
        return "redirect:/universes";
    }

    // EDIT (FORM)
    @GetMapping ("/edit/{id}")
    public String edit (@PathVariable Integer id, Model model){
        model.addAttribute("universe", universeService.findById(id));
        model.addAttribute("edit", true);
        return "universes/create-or-edit";
    }

    // UPDATE
    @PostMapping ("/edit/{id}")
    public String update (
        @PathVariable Integer id,
        @Valid @ModelAttribute ("universe") Universe formUniverse,
        BindingResult bindingResult,
        Model model
    ){
        if (bindingResult.hasErrors()){
            model.addAttribute("edit", true);
            return "universes/create-or-edit";
        }

        universeService.update(formUniverse, id);
        return "redirect:/universes";
    }

    // DELETE
    @DeleteMapping ("/delete/{id}")
    public String delete (@PathVariable Integer id){
        relicService.deleteById(id);
        return "redirect:/universes";
    }

}
