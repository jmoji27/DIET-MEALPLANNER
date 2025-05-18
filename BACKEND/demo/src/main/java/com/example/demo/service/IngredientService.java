package com.example.demo.service;

import com.example.demo.dto.IngredientDTO;
import com.example.demo.entity.Ingredient;
import com.example.demo.repository.IngredientRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class IngredientService {

    private final IngredientRepository ingredientRepository;

    public IngredientService(IngredientRepository ingredientRepository) {
        this.ingredientRepository = ingredientRepository;
    }

    public IngredientDTO insertIngredient(IngredientDTO dto) {
        Ingredient ingredient = mapDTOToEntity(dto);
        Ingredient saved = ingredientRepository.save(ingredient);
        return mapEntityToDTO(saved);
    }

    public IngredientDTO updateIngredient(IngredientDTO dto) {
        Ingredient ingredient = mapDTOToEntity(dto);
        Ingredient updated = ingredientRepository.save(ingredient);
        return mapEntityToDTO(updated);
    }

    public void deleteIngredientById(Integer id) {
        ingredientRepository.deleteById(id);
    }

    public IngredientDTO getIngredientById(Integer id) {
        Ingredient ingredient = ingredientRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Ingredient not found"));
        return mapEntityToDTO(ingredient);
    }

    public List<IngredientDTO> getAllIngredients() {
        return ingredientRepository.findAll()
                .stream()
                .map(this::mapEntityToDTO)
                .collect(Collectors.toList());
    }

    private Ingredient mapDTOToEntity(IngredientDTO dto) {
        Ingredient ingredient = new Ingredient();
        if (dto.getId() != null) ingredient.setId(dto.getId());
        ingredient.setName(dto.getName());
        ingredient.setCalories(dto.getCalories());
        ingredient.setFat(dto.getFat());
        ingredient.setCarbs(dto.getCarbs());
        ingredient.setProtein(dto.getProtein());
        ingredient.setTag(dto.getTag());
        return ingredient;
    }

    private IngredientDTO mapEntityToDTO(Ingredient ingredient) {
        return new IngredientDTO(
                ingredient.getId(),
                ingredient.getName(),
                ingredient.getCalories(),
                ingredient.getFat(),
                ingredient.getCarbs(),
                ingredient.getProtein(),
                ingredient.getTag()
        );
    }
}
