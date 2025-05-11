package com.example.demo.controller;

import com.example.demo.entity.Ingredient;
import com.example.demo.service.IngredientService;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@RestController
@RequestMapping("api/v1/Ingredient")
public class IngredientController {
    private final IngredientService ingredientService;
    public IngredientController(IngredientService IngredientService, IngredientService ingredientService) {
        this.ingredientService = ingredientService;
    }
    //this part here will be the ones for admin
    //so when your part comes and you see this
    //know this are the ones for admin

    @PutMapping("/{id}")
    public void updateIngredient(@PathVariable Ingredient update) {
        ingredientService.updateIngredient(update);
    }

    @PostMapping
    public void insertIngredient(@RequestBody Ingredient ingredient) {
        ingredientService.insertIngredient(ingredient);
    }

    @DeleteMapping
    public void deleteIngredient(@RequestBody Ingredient ingredient) {
        ingredientService.deleteIngredient(ingredient);
    }

    @GetMapping("/{id}")
    public Ingredient getIngredientById(@PathVariable Integer id) {
        return ingredientService.findIngredientById(id);
    }


    //These next ones are for
    //the normal users and amdin wtvr yk what i mean
    //for everyone

    @GetMapping
    public List<Ingredient> getAllIngredients() {
        return ingredientService.getAllIngredients();
    }

    @GetMapping("/name/{name}")
    public List<Ingredient> getIngredientByName(@PathVariable String name) {
        return ingredientService.findIngredientByName(name);
    }

    @GetMapping("/calories/{calories}")
    public List<Ingredient> getIngredientByCalories(@PathVariable Integer calories) {
        return ingredientService.findIngredientByCalories(calories);
    }

    @GetMapping("/carbs/{carbs}")
    public List<Ingredient> getIngredientByCarbs(@PathVariable Integer carbs) {
        return ingredientService.findIngredientByCarbs(carbs);
    }

    @GetMapping("/ExtremeCalories/{extreme_calories}")
    public List<Ingredient> getIngredientByExtreme(@PathVariable Integer extreme_calories) {
        return ingredientService.findIngredientByExtremeCalories();
    }

    @GetMapping("/calorie-range")
    public List<Ingredient> getByCalorieRange(
            @RequestParam Integer min,
            @RequestParam Integer max
    ) {
        return ingredientService.findIngredientByCalorieRange(min, max);
    }















}