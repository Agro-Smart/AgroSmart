package com.example.demo.api.impl;

import com.example.demo.api.PlantApi;
import com.example.demo.dto.PlantDto;
import com.example.demo.entity.Plant;
import com.example.demo.service.PlantService;
import com.example.demo.service.SalesService;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class PlantApiImpl implements PlantApi {
  private final PlantService plantService;
  private final SalesService salesService;

  @Override
  public List<Plant> getAllPlants() {
    return plantService.getAllPlantsList();
  }

  @Override
  public List<Plant> getPlantsOfType(String label) {
    return plantService.getPlantsOfType(label);
  }

  @Override
  public List<PlantDto> getPlantsSales() {
    return salesService.getPlantsSales();
  }


}
