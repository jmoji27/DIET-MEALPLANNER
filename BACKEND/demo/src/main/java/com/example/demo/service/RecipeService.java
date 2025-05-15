package com.example.demo.service;

import com.example.demo.ResourceNotFoundException;
import com.example.demo.entity.Recipe;
import com.example.demo.repository.RecipeRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service


public class RecipeService {
    private  RecipeRepository recipeRepository;

    public RecipeService(RecipeRepository recipeRepository) {
        this.recipeRepository = recipeRepository;
    }


    //methods I think only the admin should be
    //able to use
    public void insertRecipe(Recipe recipe) {
        recipeRepository.save(recipe);
    }

    public void deleteRecipeById(Integer id) {
        Recipe recipe = findRecipeById(id);
        recipeRepository.delete(recipe);
    }

    public void updateRecipe(Recipe recipe) {
        recipeRepository.save(recipe);
    }

    public Recipe findRecipeById(Integer id) {
        return recipeRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Recipe with ID " + id + " not found"));
    }


    //General Methods

    public List<Recipe> findRecipesByDietName(String name) {

        List<Recipe> recipes = recipeRepository.findRecipesByDietName(name);
        if(recipes.isEmpty()){
            throw new ResourceNotFoundException("Recipe with name " + name + " not found");
        }
        return recipes;

    }


    public List<Recipe> getAllRecipes() {
        return recipeRepository.findAll();
    }


    public List<Recipe> findRecipesByName(String name) {
        List<Recipe> recipes = recipeRepository.findByName(name);
        if(recipes.isEmpty()){
            throw new ResourceNotFoundException("Recipe with name " + name + " not found");
        }
        return recipes;
    }

    public Recipe findRecipeByDietId(Integer dietId) {
        Recipe recipe =  recipeRepository.findByDietId(dietId);
        if (recipe == null) {
            throw new ResourceNotFoundException("Recipe with id " + dietId + " not found");
        }
        return recipe;
    }


}