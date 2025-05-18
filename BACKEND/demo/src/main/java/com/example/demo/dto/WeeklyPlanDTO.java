package com.example.demo.dto;
import lombok.*;
import org.springframework.cglib.core.Local;

import java.time.LocalDate;
import java.util.List;

@Data
@AllArgsConstructor
public class WeeklyPlanDTO {
    private LocalDate date;
    private String mealType;
    private Integer recipeId;
    private String recipeName;

//    public LocalDate getDate() {
//    }

}
