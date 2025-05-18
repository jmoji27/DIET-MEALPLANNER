package com.example.demo.dto;

public class ContainsDTO {
    private Integer recipeId;
    private Integer ingredientId;
    private Double amount;

    public ContainsDTO() {}

    public ContainsDTO(Integer recipeId, Integer ingredientId, Double amount) {
        this.recipeId = recipeId;
        this.ingredientId = ingredientId;
        this.amount = amount;
    }

    public Integer getRecipeId() {
        return recipeId;
    }

    public void setRecipeId(Integer recipeId) {
        this.recipeId = recipeId;
    }

    public Integer getIngredientId() {
        return ingredientId;
    }

    public void setIngredientId(Integer ingredientId) {
        this.ingredientId = ingredientId;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }
}
