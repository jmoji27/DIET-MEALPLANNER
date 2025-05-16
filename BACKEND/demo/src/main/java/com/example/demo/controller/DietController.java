package com.example.demo.controller;

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

   //methods for admin only
    @PostMapping
    public void InsertDiet(@RequestBody Diet diet){
         dietService.insertDiet(diet);
    }
    @PutMapping("/{id}")
    public void updateDiet(@PathVariable Integer id, @RequestBody Diet diet) {
        diet.setDid(id); // force ID from URL path into the object
        dietService.updateDiet(diet);
    }

    @DeleteMapping("/{id}")
    public void deleteDietById(@PathVariable("id") Integer  id){
        dietService.deleteDietById(id);
    }

    //for all users
    @GetMapping("/name/{name}")
        public List<Diet> getDietByName(@PathVariable String name){
            return dietService.getDietByName(name);
        }



    @GetMapping
    public List<Diet> getAllDiets(){
        return dietService.getAllDiet();
    }

    @GetMapping("/goal/{goal}")
    public List<Diet> getDietByGoal(@PathVariable  String goal){
        return dietService.getDietByGoal(goal);
    }

    @GetMapping("/id/{id}")
    public Diet getDietById(@PathVariable Integer id){
        return dietService.getDietById(id);
    }
}
