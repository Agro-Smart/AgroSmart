package com.example.demo.dto;

import java.util.Map;
import lombok.Data;

@Data
public class OverviewGraph {
  private Map<String, Integer> monthly;
}
