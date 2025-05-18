package com.example.demo.service;


import com.example.demo.ResourceNotFoundException;
import com.example.demo.dto.ContainsDTO;
import com.example.demo.dto.IngredientWithKcalDTO;
import com.example.demo.entity.Contains;
import com.example.demo.entity.Ingredient;
import com.example.demo.entity.Recipe;
import com.example.demo.repository.ContainsRepository;
import com.example.demo.repository.IngredientRepository;
import com.example.demo.repository.RecipeRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ContainsService {

    private ContainsRepository containsRepository;
    private IngredientRepository ingredientRepository;
    private RecipeRepository recipeRepository;
    public ContainsService(ContainsRepository containsRepository, IngredientRepository ingredientRepository, RecipeRepository recipeRepository) {
        this.containsRepository = containsRepository;
        this.ingredientRepository = ingredientRepository;
        this.recipeRepository = recipeRepository;
    }

    //only should be accesed by admins
    public void deleteContainsById(Integer id) {
        Contains contains = containsRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Contains not found"));
        containsRepository.delete(contains);
    }

    public ContainsDTO insertContains(ContainsDTO containsDTO) {
        Contains contains = mapDTOToEntity(containsDTO);
        containsRepository.save(contains);
        return mapEntityToDTO(contains);
    }

    public ContainsDTO updateContains(ContainsDTO containsDTO) {
        Contains contains = mapDTOToEntity(containsDTO);
        containsRepository.save(contains);
        return mapEntityToDTO(contains);
    }




    public List<ContainsDTO> getAllContains() {
        return containsRepository.findAll()
                .stream()
                .map(this::mapEntityToDTO)
                .collect(Collectors.toList());



    }
    //can be accesed by everyone

    public ContainsDTO getContainsById(Integer rid, Integer igid) {
        Contains contains = containsRepository.findByCompositeId(rid, igid);
        if (contains == null) {
            throw new ResourceNotFoundException("Contains not found");
        }
        return mapEntityToDTO(contains);
    }

    public List<ContainsDTO> getContainsByMaxKcal(Integer cal) {
        return containsRepository.findContainsByMaxKcal(cal)
                .stream()
                .map(this::mapEntityToDTO)
                .collect(Collectors.toList());
    }

    public List<ContainsDTO> getContainsByMinKcal(Integer cal) {
        return containsRepository.findContainsByMinKcal(cal)
                .stream()
                .map(this::mapEntityToDTO)
                .collect(Collectors.toList());
    }

    public List<Recipe> findRecipeByIngredientId(Integer id) {
        return containsRepository.findRecipesByIngredientId(id);

    }

    public List<Recipe> findRecipeByIngredientName(String name){
        return containsRepository.findRecipesByIngredientName(name);
    }

    public List<IngredientWithKcalDTO> findIngredientByRecipeId(Integer rid) {
        return containsRepository.findIngredientsByRecipeId(rid);
    }


    public Contains mapDTOToEntity(ContainsDTO dto) {
        Recipe recipe = recipeRepository.findById(dto.getRecipeId())
                .orElseThrow(() -> new ResourceNotFoundException("Recipe with id " + dto.getRecipeId() + " not found"));
        Ingredient ingredient = ingredientRepository.findById(dto.getIngredientId())
                .orElseThrow(() -> new ResourceNotFoundException("Ingredient with id " + dto.getIngredientId() + " not found"));

        return new Contains(recipe, ingredient, dto.getAmount());
    }


    private ContainsDTO mapEntityToDTO (Contains contains) {
        return new ContainsDTO(
                contains.getRecipe().getId(),
                contains.getIngredient().getId(),
                contains.getAmount()
        );
    }









}
