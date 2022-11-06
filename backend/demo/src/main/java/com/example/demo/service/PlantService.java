package com.example.demo.service;

import com.example.demo.entity.Plant;
import com.example.demo.repository.PlantRepository;
import java.time.LocalDate;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PlantService {
  private final PlantRepository plantRepository;

  public List<Plant> getAllPlantsList() {
    return plantRepository.findAll();
  }

  public List<Plant> getPlantsOfType(String label) {
    return plantRepository.findByLabel(label);
  }
}
