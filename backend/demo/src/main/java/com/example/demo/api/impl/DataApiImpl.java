package com.example.demo.api.impl;

import com.example.demo.api.DataApi;
import com.example.demo.service.DataService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.multipart.MultipartFile;

@Controller
@RequiredArgsConstructor
public class DataApiImpl implements DataApi {
  private final DataService dataService;
  @Override
  public Integer uploadPlantsData(MultipartFile file) {
    return dataService.uploadPlantsToDB(file);
  }

  @Override
  public Integer uploadSalesData(MultipartFile file) {
    return dataService.uploadSalesToDB(file);
  }
}
