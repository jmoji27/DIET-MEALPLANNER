package com.example.demo.entity;
import jakarta.persistence. *;

@Entity
public class Recipe{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="RID")
    private Integer id;

    @Column(name="RNAME")
    private String name;

    @Column(name="DIET_ID")
    private Integer dietId;

    public Recipe() {
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


}
