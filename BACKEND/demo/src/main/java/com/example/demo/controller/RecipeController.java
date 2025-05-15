package com.example.demo.controller;

import com.example.demo.entity.Recipe;
import com.example.demo.service.RecipeService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/recipe")
public class RecipeController {
    private final RecipeService recipeService;

    public RecipeController(RecipeService recipeService) {
        this.recipeService = recipeService;
    }
    //Methods the admin should only be able to use
    @PostMapping
    public void insertRecipe(@RequestBody Recipe recipe){
        recipeService.insertRecipe(recipe);
    }

    @DeleteMapping
    public void deleteRecipeById(@RequestParam  Integer id){
        recipeService.deleteRecipeById(id);
    }

    @PutMapping("/{id}")
    public void updateRecipe(@PathVariable Integer id, @RequestBody Recipe recipe){
        recipe.setId(id);
        recipeService.updateRecipe(recipe);
    }

    @GetMapping("/diet-id/{id}")
    public Recipe getRecipeByDietId(@PathVariable Integer id) {
        return recipeService.findRecipeByDietId(id);
    }

    @GetMapping("/id/{id}")
    public Recipe getRecipeById(@PathVariable Integer id) {
        return recipeService.findRecipeById(id);
    }


    //Methods everyone should be able to use

    @GetMapping("/diet-name/{name}")
    public List<Recipe> getRecipeByDietName(@PathVariable String name) {
        return recipeService.findRecipesByDietName(name);
    }

    @GetMapping
    public List<Recipe> getAllRecipes() {
        return recipeService.getAllRecipes();
    }


    @GetMapping("/name/{name}")
    public  List<Recipe> getRecipeByName(@PathVariable String name) {
        return recipeService.findRecipesByName(name);
    }

}