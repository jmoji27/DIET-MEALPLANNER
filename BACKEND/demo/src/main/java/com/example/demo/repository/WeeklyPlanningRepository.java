//package com.example.demo.repository;
//
//public interface WeeklyPlanningRepository extends JpaRepository<WeeklyPlanning, Long> {
//    List<WeeklyPlanning> findByUserId(Long userId);
//}


package com.example.demo.repository;

import com.example.demo.entity.WeeklyPlanning;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface WeeklyPlanningRepository extends JpaRepository<WeeklyPlanning, Integer> {
    List<WeeklyPlanning> findByUser_Uid(Integer userId); // uses nested field in entity
}
