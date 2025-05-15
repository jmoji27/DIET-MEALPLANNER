package com.example.demo.service;

import com.example.demo.ResourceNotFoundException;
import com.example.demo.entity.Diet;
import com.example.demo.repository.DietRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DietService {
    private DietRepository dietRepository;
    public DietService(DietRepository dietRepository) {
        this.dietRepository = dietRepository;
    }

    //only should be accesed by admins
    public void insertDiet(Diet diet) {
        dietRepository.save(diet);
    }

    public void deleteDietById(Integer id) {
        Diet diet = dietRepository.findDietById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Diet with id " + id + " not found"));
        dietRepository.delete(diet);
    }




    public void updateDiet(Diet diet) {
        dietRepository.save(diet);
    }

    //for every user to do

    public Diet getDietById(Integer id) {
        return dietRepository.findById(id)
                .orElseThrow(()-> new ResourceNotFoundException("The diet with id : " + id + "Was not Found"));
    }

    public List<Diet> getAllDiet() {
        return dietRepository.findAll();
    }

    public List<Diet> getDietByName(String name) {
        List<Diet> diets = dietRepository.findDietByName(name);
        if (diets.isEmpty()) {
            throw new ResourceNotFoundException("The diet with name : " + name + " was not found");
        }
        return diets;
    }


    public List<Diet> getDietByGoal(String goal) {
        return dietRepository.findDietByGoalLike(goal);
    }
}
