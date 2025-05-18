package com.example.demo.dto;

public class DietDTO {
    private Integer did;
    private String dname;
    private String goal;
    private String description;

    public DietDTO(){}
    public DietDTO(Integer did, String dname, String goal, String description) {
        this.did = did;
        this.dname = dname;
        this.goal = goal;
        this.description = description;
    }

    public Integer getDid() {
        return did;
    }

    public void setDid(Integer did) {
        this.did = did;
    }

    public String getDname() {
        return dname;
    }

    public void setDname(String dname) {
        this.dname = dname;
    }

    public String getGoal() {
        return goal;
    }

    public void setGoal(String goal) {
        this.goal = goal;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
