package com.example.demo.repository;

import com.example.demo.entity.Recipe;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface RecipeRepository extends JpaRepository<Recipe, Integer> {

    @Query(value="SELECT * FROM recipe WHERE  RNAME ILIKE %:name%", nativeQuery = true)
    List<Recipe> findByName(@Param("name") String name);

    @Query(value="SELECT * FROM recipe WHERE DIET_ID =:dietId", nativeQuery = true)
    Recipe findByDietId(@Param("dietId") Integer dietId);

    @Query(value = """
    SELECT r.*
    FROM recipe r
    JOIN diet d ON r.DIET_ID = d.DID
    WHERE LOWER(d.dName) LIKE LOWER(CONCAT('%', :dietName, '%'))
    """, nativeQuery = true)
    List<Recipe> findRecipesByDietName(@Param("dietName") String dietName);

    @Query(value = "SELECT * FROM recipe WHERE diet_id = :dietId", nativeQuery = true)
    List<Recipe> findByDId(@Param("dietId") Integer dietId);



//    @Query(value = "SELECT * FROM recipe WHERE DIET_ID = :dietId", nativeQuery = true)
//    List<Recipe> findByDietId(@Param("dietId") Integer dietId);




}
