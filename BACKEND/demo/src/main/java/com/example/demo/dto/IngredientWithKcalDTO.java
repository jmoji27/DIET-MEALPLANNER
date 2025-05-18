package com.example.demo.dto;

public class IngredientWithKcalDTO {
    private Integer id;
    private String name;
    private Double totalKcal;
    private Double amount;

    public IngredientWithKcalDTO() {
    }

    public IngredientWithKcalDTO(Integer id, String name, Double totalKcal, Double amount) {
        this.id = id;
        this.name = name;
        this.totalKcal = totalKcal;
        this.amount = amount;
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

    public Double getTotalKcal() {
        return totalKcal;
    }

    public void setTotalKcal(Double totalKcal) {
        this.totalKcal = totalKcal;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }
}
