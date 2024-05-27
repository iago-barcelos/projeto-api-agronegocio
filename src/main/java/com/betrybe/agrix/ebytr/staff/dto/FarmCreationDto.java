package com.betrybe.agrix.ebytr.staff.dto;

import com.betrybe.agrix.ebytr.staff.entity.Farm;

/**
 * farm creation dto.
 */
public record FarmCreationDto(String name, double size) {
  public Farm toEntity() {
    return new Farm(name, size);
  }
}
