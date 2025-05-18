package com.example.demo.controller;

import com.example.demo.dto.IngredientDTO;
import com.example.demo.service.IngredientService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/ingredient")
public class IngredientController {

    private final IngredientService ingredientService;

    public IngredientController(IngredientService ingredientService) {
        this.ingredientService = ingredientService;
    }

    @PostMapping
    public IngredientDTO insertIngredient(@RequestBody IngredientDTO dto) {
        return ingredientService.insertIngredient(dto);
    }

    @PutMapping("/{id}")
    public IngredientDTO updateIngredient(@PathVariable Integer id, @RequestBody IngredientDTO dto) {
        dto.setId(id);
        return ingredientService.updateIngredient(dto);
    }

    @DeleteMapping("/{id}")
    public void deleteIngredientById(@PathVariable Integer id) {
        ingredientService.deleteIngredientById(id);
    }

    @GetMapping("/{id}")
    public IngredientDTO getIngredientById(@PathVariable Integer id) {
        return ingredientService.getIngredientById(id);
    }

    @GetMapping
    public List<IngredientDTO> getAllIngredients() {
        return ingredientService.getAllIngredients();
    }
}
