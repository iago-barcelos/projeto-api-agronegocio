package com.betrybe.agrix.ebytr.staff.dto;

import com.betrybe.agrix.ebytr.staff.entity.Fertilizer;

/**
 * fertilizer creation dto.
 */
public record FertilizerCreationDto(String name, String brand, String composition) {
  public Fertilizer toEntity() {
    return new Fertilizer(name, brand, composition);
  }
}
