package com.example.demo.service;

import com.example.demo.ResourceNotFoundException;
import com.example.demo.dto.DietDTO;
import com.example.demo.entity.Diet;
import com.example.demo.repository.DietRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class DietService {

    private final DietRepository dietRepository;

    public DietService(DietRepository dietRepository) {
        this.dietRepository = dietRepository;
    }

    public DietDTO insertDiet(DietDTO dietDTO) {
        Diet diet = mapDTOToEntity(dietDTO);
        Diet saved = dietRepository.save(diet);
        return mapEntityToDTO(saved);
    }

    public void deleteDietById(Integer id) {
        Diet diet = dietRepository.findDietById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Diet with id " + id + " not found"));
        dietRepository.delete(diet);
    }

    public DietDTO updateDiet(DietDTO dietDTO) {
        Diet diet = mapDTOToEntity(dietDTO);
        Diet updated = dietRepository.save(diet);
        return mapEntityToDTO(updated);
    }

    public DietDTO getDietById(Integer id) {
        Diet diet = dietRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Diet with id " + id + " not found"));
        return mapEntityToDTO(diet);
    }

    public List<DietDTO> getAllDiet() {
        return dietRepository.findAll()
                .stream()
                .map(this::mapEntityToDTO)
                .collect(Collectors.toList());
    }

    public List<DietDTO> getDietByName(String name) {
        List<Diet> diets = dietRepository.findDietByName(name);
        if (diets.isEmpty()) {
            throw new ResourceNotFoundException("Diet with name " + name + " was not found");
        }
        return diets.stream()
                .map(this::mapEntityToDTO)
                .collect(Collectors.toList());
    }

    public List<DietDTO> getDietByGoal(String goal) {
        return dietRepository.findDietByGoalLike(goal)
                .stream()
                .map(this::mapEntityToDTO)
                .collect(Collectors.toList());
    }

    private Diet mapDTOToEntity(DietDTO dietDTO) {
        Diet diet = new Diet();
        if (dietDTO.getDid() != null) {
            diet.setDid(dietDTO.getDid());
        }
        diet.setdName(dietDTO.getDname());
        diet.setGoal(dietDTO.getGoal());
        diet.setDescription(dietDTO.getDescription());
        return diet;
    }

    private DietDTO mapEntityToDTO(Diet diet) {
        return new DietDTO(
                diet.getDid(),
                diet.getdName(),
                diet.getGoal(),
                diet.getDescription()
        );
    }
}
