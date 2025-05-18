package com.example.demo.controller;

import com.example.demo.dto.DietDTO;
import com.example.demo.entity.Diet;
import com.example.demo.service.DietService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/diet")
public class DietController {

    private final DietService dietService;

    public DietController(DietService dietService) {
        this.dietService = dietService;
    }

    @PostMapping
    public DietDTO insertDiet(@RequestBody DietDTO diet) {
        return dietService.insertDiet(diet);
    }

    @PutMapping("/{id}")
    public DietDTO updateDiet(@PathVariable Integer id, @RequestBody DietDTO diet) {
        diet.setDid(id); // force ID from path
        return dietService.updateDiet(diet);
    }

    @DeleteMapping("/{id}")
    public void deleteDietById(@PathVariable Integer id) {
        dietService.deleteDietById(id);
    }

    @GetMapping("/name/{name}")
    public List<DietDTO> getDietByName(@PathVariable String name) {
        return dietService.getDietByName(name);
    }

    @GetMapping
    public List<DietDTO> getAllDiets() {
        return dietService.getAllDiet();
    }

    @GetMapping("/goal/{goal}")
    public List<DietDTO> getDietByGoal(@PathVariable String goal) {
        return dietService.getDietByGoal(goal);
    }

    @GetMapping("/id/{id}")
    public DietDTO getDietById(@PathVariable Integer id) {
        return dietService.getDietById(id);
    }
}
