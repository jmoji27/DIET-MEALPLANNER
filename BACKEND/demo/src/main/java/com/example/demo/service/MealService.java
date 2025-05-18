package com.example.demo.service;
import com.example.demo.dto.WeeklyPlanDTO;
import com.example.demo.dto.WeeklyPlanRequest;
import com.example.demo.entity.Recipe;
import com.example.demo.entity.WeeklyPlanning;
import com.example.demo.repository.RecipeRepository;
import com.example.demo.repository.UserRepository;
import com.example.demo.repository.WeeklyPlanningRepository;
import org.hibernate.annotations.Array;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.time.LocalDate;
import com.example.demo.entity.User;
import java.util.*;

@Service
public class MealService {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RecipeRepository recipeRepository;

    @Autowired
    private WeeklyPlanningRepository weeklyPlanRepository;

//    public List<WeeklyPlanDTO> generateWeeklyPlan(Integer dietId) {
//        List<Recipe> recipes = recipeRepository.findByDietId(dietId);
//        Collections.shuffle(recipes);
//
//        List<WeeklyPlanDTO> plan = new ArrayList<>();
//        LocalDate[] days = {};
//        String[] mealTypes = {"Breakfast", "Lunch", "Dinner"};
//
//        int rIndex = 0;
//        for (LocalDate day : days) {
//            for (String type : mealTypes) {
//                if (rIndex >= recipes.size()) break;
//                Recipe r = recipes.get(rIndex++);
//                plan.add(new WeeklyPlanDTO(day, type, r.getId(), r.getName()));
//            }
//        }
//        return plan;
//    }

    public List<WeeklyPlanDTO> generateWeeklyPlan(Integer dietId) {
        List<Recipe> recipes = recipeRepository.findByDId(dietId);
        Collections.shuffle(recipes);

        List<WeeklyPlanDTO> plan = new ArrayList<>();
        String[] mealTypes = {"Breakfast", "Lunch", "Dinner"};

        int rIndex = 0;
        LocalDate startDate = LocalDate.now();

        for (int i = 0; i < 7; i++) {
            LocalDate day = startDate.plusDays(i);
            for (String type : mealTypes) {
                if (rIndex >= recipes.size()) break;
                Recipe r = recipes.get(rIndex++);
                plan.add(new WeeklyPlanDTO(day, type, r.getId(), r.getName()));
            }
        }

        return plan;
    }



//    public void saveWeeklyPlan(Integer userId, List<WeeklyPlanDTO> plan) {
//        for (WeeklyPlanDTO entry : plan) {
//            WeeklyPlanning wp = new WeeklyPlanning();
//            wp.setUserId(userId);
//            wp.setDate(LocalDate.now());
//            wp.setMealType(entry.getMealType());
//            wp.setRecipeId(entry.getRecipeId());
//            weeklyPlanRepository.save(wp);
//        }
//    }

    public void saveWeeklyPlan(Integer userId, List<WeeklyPlanDTO> plan) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found"));

        for (WeeklyPlanDTO entry : plan) {
            WeeklyPlanning wp = new WeeklyPlanning();
            wp.setUser(user); // ✅ use User entity
            wp.setDate(entry.getDate());
            wp.setMealType(entry.getMealType());

            // You also need to fetch the Recipe entity
            Recipe recipe = recipeRepository.findById(entry.getRecipeId())
                    .orElseThrow(() -> new RuntimeException("Recipe not found"));

            wp.setRecipe(recipe); // ✅ set full Recipe entity

            weeklyPlanRepository.save(wp);
        }
    }

    public void saveWeeklyPlan(WeeklyPlanRequest request) {
    }

//    public void saveWeeklyPlan(WeeklyPlanRequest request) {
//    }
}
