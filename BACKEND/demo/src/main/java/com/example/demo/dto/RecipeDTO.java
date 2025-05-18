package com.example.demo.dto;

public class RecipeDTO {
    private Integer id;
    private String name;
    private Integer dietId;
    private String instructions;

    public RecipeDTO() {
    }

    public RecipeDTO(Integer id, String name, Integer dietId, String instructions) {
        this.id = id;
        this.name = name;
        this.dietId = dietId;
        this.instructions = instructions;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getDietId() {
        return dietId;
    }

    public void setDietId(Integer dietId) {
        this.dietId = dietId;
    }

    public String getInstructions() {
        return instructions;
    }

    public void setInstructions(String instructions) {
        this.instructions = instructions;
    }
}
