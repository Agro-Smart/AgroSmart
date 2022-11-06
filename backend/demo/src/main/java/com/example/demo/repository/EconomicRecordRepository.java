package com.example.demo.repository;

import com.example.demo.entity.EconomicRecord;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EconomicRecordRepository extends JpaRepository<EconomicRecord, Long> {
  List<EconomicRecord> findByName(String name);
}
