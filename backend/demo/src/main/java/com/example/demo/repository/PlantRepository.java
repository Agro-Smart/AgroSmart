package com.example.demo.repository;

import com.example.demo.entity.Plant;
import java.util.List;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

public interface PlantRepository extends ElasticsearchRepository<Plant, String> {
  List<Plant> findAll();

  List<Plant> findByLabel(String label);
}
