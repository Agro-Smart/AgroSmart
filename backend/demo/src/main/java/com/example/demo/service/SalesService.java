package com.example.demo.service;

import static co.elastic.clients.elasticsearch._types.analysis.CharFilterDefinitionBuilders.mapping;
import static java.util.stream.Collectors.collectingAndThen;
import static java.util.stream.Collectors.filtering;
import static java.util.stream.Collectors.groupingBy;

import com.example.demo.dto.PlantDto;
import com.example.demo.entity.EconomicRecord;
import com.example.demo.repository.EconomicRecordRepository;
import java.time.LocalDate;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class SalesService {
  private final EconomicRecordRepository economicRecordRepository;

  public List<PlantDto> getPlantsSales() {
    int year = LocalDate.now().getYear();
    Map<String, List<EconomicRecord>> records = economicRecordRepository.findAll().stream()
        .collect(groupingBy(EconomicRecord::getName));
    return records.entrySet().stream()
        .map(e->mapListPlants(e, year))
        .collect(Collectors.toList());
  }

  private PlantDto mapListPlants(Map.Entry<String, List<EconomicRecord>> economicRecords, int year){
    List<EconomicRecord> records = economicRecords.getValue().stream()
        .filter(economicRecord -> economicRecord.getYear() == year||
            economicRecord.getYear() == year - 1 )
        .sorted(Comparator.comparingInt(EconomicRecord::getYear).reversed())
        .collect(Collectors.toList());
    return PlantDto.builder()
        .name(economicRecords.getKey())
        .sold(records.get(0).getSold())
        .soldPrise(records.get(0).getSold())
        .profit(100*records.get(0).getSold()*records.get(0).getPrice()/records.get(1).getSold()*records.get(1).getPrice())
        .build();
  }
}
