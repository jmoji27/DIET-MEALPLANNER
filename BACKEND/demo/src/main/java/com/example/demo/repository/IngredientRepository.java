package com.example.demo.repository;

import com.example.demo.entity.Ingredient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import java.util.List;

public interface IngredientRepository extends JpaRepository<Ingredient, Integer>{

        @Query(value ="SELECT * FROM ingredient WHERE calories <= :maxCal" ,nativeQuery=true)
    List<Ingredient> findByCalories(@Param("maxCal") double maxCal);

        @Query(value="SELECT * FROM ingredient WHERE carbs <= :maxCarb", nativeQuery=true)
    List<Ingredient> findByCarbs(@Param("maxCarb") double maxCarb);

    @Query(value = "SELECT * FROM ingredient ORDER BY protein DESC", nativeQuery = true)
    List<Ingredient> findTopByProtein();

    @Query(value="SELECT * FROM ingredient WHERE calories =(SELECT MAX(calories) FROM ingredient)", nativeQuery=true)
    List<Ingredient> findExtremeCalories();

    @Query(value="SELECT i FROM Ingredient i WHERE i.calories BETWEEN :min AND :max")
    List<Ingredient> findByCalorieRange(@Param("min") int min, @Param("max") int max);

    @Query(value = "SELECT * FROM ingredient WHERE LOWER(name) LIKE LOWER(CONCAT('%', :searchName, '%'))", nativeQuery = true)
    List<Ingredient> findByName(@Param("searchName") String searchName);






}





