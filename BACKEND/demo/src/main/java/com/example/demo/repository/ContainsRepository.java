package com.example.demo.repository;

import com.example.demo.dto.IngredientWithKcalDTO;
import com.example.demo.entity.Contains;
import com.example.demo.entity.Recipe;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ContainsRepository extends JpaRepository<Contains, Integer> {
    @Query(value="SELECT * FROM contains WHERE totalKcal <= :maxKcal", nativeQuery = true)
    List<Contains> findContainsByMaxKcal(@Param("maxKcal") Integer maxKcal);

    @Query(value="SELECT * FROM contains WHERE totalkcal >= :minKcal", nativeQuery = true)
    List<Contains> findContainsByMinKcal(@Param("minKcal") Integer minKcal);

    //get by recipe id
    @Query(value = "SELECT r.* FROM recipe r JOIN contains c ON r.id = c.rid WHERE c.igid = :ingredientId", nativeQuery = true)
    List<Recipe> findRecipesByIngredientId(@Param("ingredientId") Integer ingredientId);

    //get by recipe name
    @Query(value="Select r.* FROM recipe r JOIN contains c ON r.id = c.rid JOIN ingredient i on c.igid = i.id WHERE i.name ILIKE %:ingredientName%", nativeQuery = true)
    List<Recipe> findRecipesByIngredientName(@Param("ingredientName") String ingredientName);

    //get ingredients from recipes
    @Query(value = "SELECT i.*, c.amount, c.total_kcal FROM ingredient i JOIN contains c ON i.id = c.igid WHERE c.rid = :recipeId", nativeQuery = true)
    List<IngredientWithKcalDTO> findIngredientsByRecipeId(@Param("recipeId") Integer recipeId);

    //get ingredients all of em
    @Query(value="SELECT * FROM contains WHERE rid = :rid AND igid = :igid", nativeQuery = true)
    Contains findByCompositeId(@Param("rid") Integer rid, @Param("igid") Integer igid);









}
