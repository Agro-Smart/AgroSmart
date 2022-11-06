package com.example.demo.api;

import com.example.demo.validator.ValidFileStructure;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

@RequestMapping("/data")
public interface DataApi {
  @PostMapping("/plants")
  @ResponseBody
  Integer uploadPlantsData(@RequestParam("file") @Valid @ValidFileStructure MultipartFile file);

  @PostMapping("/sales")
  @ResponseBody
  Integer uploadSalesData(@RequestParam("file") @Valid @ValidFileStructure MultipartFile file);
}
