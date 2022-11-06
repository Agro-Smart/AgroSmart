package com.example.demo.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class PlantDto {
  private String name;
  private Integer sold;
  private Integer soldPrise;
  private Double profit;
}
