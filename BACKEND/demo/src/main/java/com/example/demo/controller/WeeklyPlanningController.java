package com.example.demo.controller;

import com.example.demo.entity.User;
import com.example.demo.entity.Recipe;
import com.example.demo.entity.WeeklyPlanning;
import com.example.demo.repository.UserRepository;
import com.example.demo.repository.RecipeRepository;
import com.example.demo.repository.WeeklyPlanningRepository;
import com.example.demo.entity.WeeklyPlanRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import org.springframework.security.crypto.password.PasswordEncoder;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;


import java.util.Map;

@RestController
@RequestMapping("/api/planning")
@CrossOrigin
public class WeeklyPlanningController {

    @Autowired
    private WeeklyPlanningRepository planningRepo;

    @Autowired
    private UserRepository userRepo;

    @Autowired
    private RecipeRepository recipeRepo;

    @PostMapping("/add")
    public ResponseEntity<String> addPlan(@RequestBody WeeklyPlanRequest request) {
        try {
            Integer userId = request.getUserId();
            Integer recipeId = request.getRecipeId();
            String mealType = request.getMealType();
            LocalDate date = request.getDate();

            User user = userRepo.findById(userId)
                    .orElseThrow(() -> new RuntimeException("User not found"));
            Recipe recipe = recipeRepo.findById(recipeId)
                    .orElseThrow(() -> new RuntimeException("Recipe not found"));

            WeeklyPlanning plan = new WeeklyPlanning();
            plan.setUser(user);
            plan.setRecipe(recipe);
            plan.setMealType(mealType);
            plan.setDate(date);

            planningRepo.save(plan);

            return ResponseEntity.ok("Meal plan added successfully");
        } catch (Exception e) {
            return ResponseEntity.status(400).body("Error: " + e.getMessage());
        }
    }
}
