package com.example.demo.service;

import com.example.demo.dto.RecipeDTO;
import com.example.demo.entity.Recipe;
import com.example.demo.repository.RecipeRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class RecipeService {

    private final RecipeRepository recipeRepository;

    public RecipeService(RecipeRepository recipeRepository) {
        this.recipeRepository = recipeRepository;
    }

    public RecipeDTO insertRecipe(RecipeDTO dto) {
        Recipe recipe = mapDTOToEntity(dto);
        Recipe saved = recipeRepository.save(recipe);
        return mapEntityToDTO(saved);
    }

    public RecipeDTO updateRecipe(RecipeDTO dto) {
        Recipe recipe = mapDTOToEntity(dto);
        Recipe updated = recipeRepository.save(recipe);
        return mapEntityToDTO(updated);
    }

    public void deleteRecipeById(Integer id) {
        recipeRepository.deleteById(id);
    }

    public RecipeDTO getRecipeById(Integer id) {
        Recipe recipe = recipeRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Recipe not found"));
        return mapEntityToDTO(recipe);
    }

    public List<RecipeDTO> getAllRecipes() {
        return recipeRepository.findAll()
                .stream()
                .map(this::mapEntityToDTO)
                .collect(Collectors.toList());
    }

    private Recipe mapDTOToEntity(RecipeDTO dto) {
        Recipe recipe = new Recipe();
        if (dto.getId() != null) recipe.setId(dto.getId());
        recipe.setName(dto.getName());
        recipe.setDietId(dto.getDietId());
        recipe.setInstructions(dto.getInstructions());
        return recipe;
    }

    private RecipeDTO mapEntityToDTO(Recipe recipe) {
        return new RecipeDTO(
                recipe.getId(),
                recipe.getName(),
                recipe.getDietId(),
                recipe.getInstructions()
        );
    }
}
