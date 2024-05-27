package com.betrybe.agrix.ebytr.staff.dto;

import com.betrybe.agrix.ebytr.staff.entity.Crop;
import com.betrybe.agrix.ebytr.staff.entity.Fertilizer;

/**
 * fertilizer dto.
 */
public record FertilizerDto(Long id, String name, String brand, String composition) {
  /**
   * from entity method.
   */
  public static FertilizerDto fromEntity(Fertilizer fertilizer) {
    return new FertilizerDto(
            fertilizer.getId(),
            fertilizer.getName(),
            fertilizer.getBrand(),
            fertilizer.getComposition()
    );
  }
}
