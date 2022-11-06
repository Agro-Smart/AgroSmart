package com.example.demo.api;

import com.example.demo.dto.PlantDto;
import com.example.demo.entity.Plant;
import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/plant")
public interface PlantApi {
  @GetMapping
  List<Plant> getAllPlants();

  @GetMapping("/{label}")
  List<Plant> getPlantsOfType(@PathVariable String label);

  @GetMapping("/sales")
  List<PlantDto> getPlantsSales();
}
