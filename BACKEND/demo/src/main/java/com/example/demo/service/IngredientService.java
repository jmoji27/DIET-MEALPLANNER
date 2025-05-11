package com.example.demo.service;
import java.util.List;

import com.example.demo.ResourceNotFoundException;
import com.example.demo.entity.Ingredient;
import com.example.demo.repository.IngredientRepository;



import org.springframework.stereotype.Service;

@Service
public class IngredientService {
    private  IngredientRepository ingredientRepository;

    public IngredientService(IngredientRepository ingredientRepository) {
        this.ingredientRepository = ingredientRepository;
    }

    public List<Ingredient> getAllIngredients() {
        return ingredientRepository.findAll();
    }

    public void insertIngredient(Ingredient ingredient) {
        ingredientRepository.save(ingredient);
    }

    public void deleteIngredient(Ingredient ingredient) {
        ingredientRepository.delete(ingredient);
    }
    public void updateIngredient(Ingredient ingredient) {
        ingredientRepository.save(ingredient);
    }

    public Ingredient findIngredientById(Integer id) {
        return ingredientRepository.findById(id).orElseThrow(()->new ResourceNotFoundException(id + "Not Found"));
    }

    public List<Ingredient> findIngredientByName(String name) {
        List<Ingredient> ingredients =  ingredientRepository.findByName(name);
        if(ingredients.isEmpty()) {
            throw new ResourceNotFoundException("Ingredient with name " +  name + " not found");
        }
        return ingredients;
    }

    public List<Ingredient> findIngredientByCalories(double calories) {
        return ingredientRepository.findByCalories(calories);
    }
    public List<Ingredient> findIngredientByCarbs(double carbs) {
        return ingredientRepository.findByCarbs(carbs);
    }
    public List<Ingredient> findTopByProtein() {
        return ingredientRepository.findTopByProtein();
    }
    public List<Ingredient> findIngredientByExtremeCalories(){
        return ingredientRepository.findExtremeCalories();
    }
    public List<Ingredient> findIngredientByCalorieRange(Integer min, Integer max) {
        return ingredientRepository.findByCalorieRange(min, max);
    }



}