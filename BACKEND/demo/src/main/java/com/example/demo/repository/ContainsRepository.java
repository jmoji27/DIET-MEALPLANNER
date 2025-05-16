package com.example.demo.repository;

import com.example.demo.entity.Contains;
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
    @Query(value="SELECT * FROM contains WHERE rid = :recipeId", nativeQuery = true)
    List<Contains> findByRecipeId(@Param("recipeId") Integer recipeId);




}
