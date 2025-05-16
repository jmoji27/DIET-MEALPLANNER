package com.example.demo.entity;

import jakarta.persistence.*;

@Entity
@Table(name="contains")
public class Contains {

    @EmbeddedId
    private ContainsId id;

    @ManyToOne
    @MapsId("rid")
    @JoinColumn(name="rid")
    private Recipe recipe;

    @ManyToOne
    @MapsId("igid")
    @JoinColumn(name="igid")
    private Ingredient ingredient;

    private Double amount;
    private Double totalKcal;


    public Contains(){

    }

    //COnstructor that calculates totalkcal when created
    public Contains(Recipe recipe, Ingredient ingredient, Double amount) {
        this.recipe = recipe;
        this.ingredient = ingredient;
        this.amount = amount;
        this.id = new ContainsId(recipe.getId(), ingredient.getId());
        calculateTotalKcal();


    }

    private void calculateTotalKcal() {
        // Assuming calories is per 100g or per unit depending on how you manage it
        this.totalKcal = (ingredient.getCalories() * amount) / 100.0;
    }

    public ContainsId getId() {
        return id;
    }

    public void setId(ContainsId id) {
        this.id = id;
    }

    public Recipe getRecipe() {
        return recipe;
    }

    public void setRecipe(Recipe recipe) {
        this.recipe = recipe;
        if(ingredient != null){
            this.id = new ContainsId(recipe.getId(), ingredient.getId());
        }
    }

    public Ingredient getIngredient() {
        return ingredient;
    }

    public void setIngredient(Ingredient ingredient) {
        this.ingredient = ingredient;
        if (recipe != null) {
            this.id = new ContainsId(recipe.getId(), ingredient.getId());
        }
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
        calculateTotalKcal();
    }
    public Double getTotalKcal() {
        return totalKcal;
    }
}
