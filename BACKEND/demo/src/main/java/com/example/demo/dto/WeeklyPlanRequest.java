package com.example.demo.dto;
import lombok.Data;

import java.time.LocalDate;
import java.util.List;
@Data
public class WeeklyPlanRequest {
    private Integer userId;
    private List<PlanItem> plan;

    @Data
    public static class PlanItem {
        private LocalDate date;
        private String mealType;
        private Long recipeId;
    }
}
