package com.betrybe.agrix.ebytr.staff.dto;

import com.betrybe.agrix.ebytr.staff.entity.Farm;

/**
 * summary.
 */
public record FarmDto(Long id, String name, double size) {
  /**
   * dto para farm.
   */
  public static FarmDto fromEntity(Farm farm) {
    return new FarmDto(
            farm.getId(),
            farm.getName(),
            farm.getSize()
    );
  }
}
