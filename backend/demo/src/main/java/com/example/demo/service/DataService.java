package com.example.demo.service;

import com.example.demo.entity.EconomicRecord;
import com.example.demo.entity.Plant;
import com.example.demo.repository.EconomicRecordRepository;
import com.example.demo.repository.PlantRepository;
import com.opencsv.CSVReaderBuilder;
import com.opencsv.bean.CsvToBeanBuilder;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.apache.commons.collections4.IterableUtils;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
@RequiredArgsConstructor
public class DataService {
  private final PlantRepository plantRepository;
  private final EconomicRecordRepository economicRecordRepository;
  public Integer uploadPlantsToDB(MultipartFile file) {
    List<Plant> plants = parsePlants(file);
    return IterableUtils.size(plantRepository.saveAll(plants));
  }

  public Integer uploadSalesToDB(MultipartFile file) {
    return economicRecordRepository.saveAll(parseEconomicRecords(file)).size();
  }

  private List<Plant> parsePlants(MultipartFile file) {
    try {
      CSVReaderBuilder readerBuilder =
          new CSVReaderBuilder(new InputStreamReader(file.getInputStream()));
      CsvToBeanBuilder<Plant> builder =
          new CsvToBeanBuilder<Plant>(readerBuilder.build())
              .withType(Plant.class);
      return builder.build().parse();
    } catch (IOException e) {
      throw new RuntimeException(e.getMessage());
    }
  }

  private List<EconomicRecord> parseEconomicRecords(MultipartFile file) {
    try {
      CSVReaderBuilder readerBuilder =
          new CSVReaderBuilder(new InputStreamReader(file.getInputStream()));
      CsvToBeanBuilder<EconomicRecord> builder =
          new CsvToBeanBuilder<EconomicRecord>(readerBuilder.build())
              .withType(EconomicRecord.class);
      return builder.build().parse();
    } catch (IOException e) {
      throw new RuntimeException(e.getMessage());
    }
  }
}
