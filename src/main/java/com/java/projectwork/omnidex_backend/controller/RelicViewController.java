package com.java.projectwork.omnidex_backend.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.java.projectwork.omnidex_backend.model.Relic;
import com.java.projectwork.omnidex_backend.service.CategoryService;
import com.java.projectwork.omnidex_backend.service.RelicService;
import com.java.projectwork.omnidex_backend.service.UniverseService;

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

    @GetMapping 
    public String index (
        @RequestParam (name = "name", required = false) String name, 
        Model model){

        List<Relic> relics = relicService.findRelics(name);

        model.addAttribute("relics", relics);
        model.addAttribute("searchName", name);
        return "relics/index";
    }

    @GetMapping ("/{id}")
    public String show (@PathVariable ("id") Integer id, Model model){

        Relic relic = relicService.findById(id);
        model.addAttribute("relic", relic);

        return "/relics/relicDetail";
    }
}
