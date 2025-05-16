package com.example.demo.repository;

import com.example.demo.entity.Diet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface DietRepository extends JpaRepository<Diet,  Integer> {
    @Query(value="SELECT * FROM diet WHERE d_name = :name", nativeQuery=true)
    List<Diet> findDietByName(@Param("name") String name);

    @Query(value="SELECT * FROM diet WHERE did  = :id ", nativeQuery=true)
    Optional<Diet> findDietById(@Param("id") Integer id);

    @Query(value = "SELECT * FROM diet WHERE goal ILIKE %:goal%", nativeQuery = true)
    List<Diet> findDietByGoalLike(@Param("goal") String goal);






}
