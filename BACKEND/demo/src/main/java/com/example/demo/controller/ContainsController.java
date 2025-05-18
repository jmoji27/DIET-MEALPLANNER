package com.example.demo.controller;

import com.example.demo.dto.ContainsDTO;
import com.example.demo.dto.IngredientWithKcalDTO;
import com.example.demo.entity.Contains;
import com.example.demo.entity.Recipe;
import com.example.demo.service.ContainsService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/contains")
public class ContainsController {
    private final ContainsService containsService;

    public ContainsController(ContainsService containsService) {
        this.containsService = containsService;
    }

    //Admins only methods
    @DeleteMapping("/{id}")
    public void deleteContainsById(@PathVariable Integer  id) {
        containsService.deleteContainsById(id);
    }

    @PostMapping
    public ContainsDTO insertContains(@RequestBody ContainsDTO dto) {
        return containsService.insertContains(dto);
    }

    @PutMapping
    public ContainsDTO updateContains(@RequestBody ContainsDTO dto) {
        return containsService.updateContains(dto);
    }

    //Every User
    @RequestMapping
    public List<ContainsDTO> getAllContains() {
        return containsService.getAllContains();
    }

    @GetMapping("/{rid}/{igid}")
    public ContainsDTO getContainsById(@PathVariable Integer rid, @PathVariable Integer igid) {
        return containsService.getContainsById(rid, igid);
    }

    @GetMapping("/max-cal/{Cal}")
    public List<ContainsDTO> getContainsByMaxKcal(@PathVariable Integer Cal) {
        return containsService.getContainsByMaxKcal(Cal);
    }

    @GetMapping("/min-cal/{Cal}")
    public List<ContainsDTO> getContainsByMinKcal(@PathVariable Integer Cal) {
        return containsService.getContainsByMinKcal(Cal);
    }

    @GetMapping("/ingredient/{igId}")
        public List<Recipe> getRecipeByIngredientId(@PathVariable Integer igId){
            return containsService.findRecipeByIngredientId(igId);
        }

    @GetMapping("/ingredient-name/{igName}")
    public List<Recipe> getRecipeByIngredientName(@PathVariable String igName){
        return containsService.findRecipeByIngredientName(igName);
    }

    @GetMapping("/recipe/{rId}")
    public List<IngredientWithKcalDTO> getRecipeByRecipeId(@PathVariable Integer rId){
        return containsService.findIngredientByRecipeId(rId);
    }





}
