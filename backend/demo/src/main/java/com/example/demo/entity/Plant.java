package com.example.demo.entity;

import com.opencsv.bean.CsvBindByName;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;
import org.springframework.stereotype.Component;

@Document(indexName = "plant")
@Component
@Data
public class Plant {
  @Id
  private String id;
  @CsvBindByName(column = "temperature")
  private Double temperature;
  @CsvBindByName(column = "humidity")
  private Double humidity;
  @CsvBindByName(column = "ph")
  private Double ph;
  @CsvBindByName(column = "rainfall")
  private Double rainfall;
  @CsvBindByName(column = "label")
  @Field(fielddata = true, type = FieldType.Text)
  private String label;
}
