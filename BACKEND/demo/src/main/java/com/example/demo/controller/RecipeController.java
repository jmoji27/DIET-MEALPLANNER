package com.example.demo.controller;

import com.example.demo.dto.RecipeDTO;
import com.example.demo.service.RecipeService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/recipe")
public class RecipeController {

    private final RecipeService recipeService;

    public RecipeController(RecipeService recipeService) {
        this.recipeService = recipeService;
    }

    @PostMapping
    public RecipeDTO insertRecipe(@RequestBody RecipeDTO dto) {
        return recipeService.insertRecipe(dto);
    }

    @PutMapping("/{id}")
    public RecipeDTO updateRecipe(@PathVariable Integer id, @RequestBody RecipeDTO dto) {
        dto.setId(id);
        return recipeService.updateRecipe(dto);
    }

    @DeleteMapping("/{id}")
    public void deleteRecipeById(@PathVariable Integer id) {
        recipeService.deleteRecipeById(id);
    }

    @GetMapping("/{id}")
    public RecipeDTO getRecipeById(@PathVariable Integer id) {
        return recipeService.getRecipeById(id);
    }

    @GetMapping
    public List<RecipeDTO> getAllRecipes() {
        return recipeService.getAllRecipes();
    }
}
