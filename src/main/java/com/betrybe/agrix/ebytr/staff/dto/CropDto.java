package com.betrybe.agrix.ebytr.staff.dto;

import com.betrybe.agrix.ebytr.staff.entity.Crop;
import java.time.LocalDate;

/**
 * crop from entity.
 */
public record CropDto(Long id,
                      String name,
                      Double plantedArea,
                      Long farmId,
                      LocalDate plantedDate,
                      LocalDate harvestDate) {
  /**
   * crop from entity.
   */
  public static CropDto fromEntity(Crop crop) {
    return new CropDto(
            crop.getId(),
            crop.getName(),
            crop.getPlantedArea(),
            crop.getFarmId().getId(),
            crop.getPlantedDate(),
            crop.getHarvestDate()
    );
  }
}
