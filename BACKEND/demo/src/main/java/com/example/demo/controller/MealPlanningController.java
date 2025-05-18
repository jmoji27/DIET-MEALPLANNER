package com.example.demo.controller;
import com.example.demo.dto.WeeklyPlanDTO;
import com.example.demo.service.MealService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import com.example.demo.dto.WeeklyPlanRequest;
import java.util.*;

@RestController
@RequestMapping("/api/meal")
public class MealPlanningController {

    @Autowired MealService mealService;

    @GetMapping("/generate-weekly")
    public List<WeeklyPlanDTO> generateRandomPlan(@RequestParam Integer dietId) {
        return mealService.generateWeeklyPlan(dietId);
    }

    @PostMapping("/save-weekly-plan")
    public ResponseEntity<?> savePlan(@RequestBody WeeklyPlanRequest request) {
        mealService.saveWeeklyPlan(request);
        return ResponseEntity.ok("Plan saved.");
    }
}
