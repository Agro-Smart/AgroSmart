package com.example.demo.entity.converver;

import com.example.demo.entity.Plant;
import org.elasticsearch.common.UUIDs;
import org.springframework.data.elasticsearch.core.event.BeforeConvertCallback;
import org.springframework.data.elasticsearch.core.mapping.IndexCoordinates;
import org.springframework.stereotype.Component;

@Component
public class PlantBeforeConvertCallback implements BeforeConvertCallback<Plant> {

  @Override
  public Plant onBeforeConvert(Plant plant, IndexCoordinates indexCoordinates) {
    if (plant.getId() == null) {
      plant.setId(UUIDs.randomBase64UUID());
    }
    return plant;
  }
}
