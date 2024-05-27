package com.betrybe.agrix.ebytr.staff.service;

import com.betrybe.agrix.ebytr.staff.entity.Farm;
import com.betrybe.agrix.ebytr.staff.exception.FarmNotFoundException;
import com.betrybe.agrix.ebytr.staff.repository.FarmRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * service.
 */
@Service
public class FarmService {
  private final FarmRepository farmRepository;

  @Autowired
  public FarmService(FarmRepository farmRepository) {
    this.farmRepository = farmRepository;
  }

  /**
   * cria uma farm.
   */
  public Farm createFarm(Farm farm) {
    return farmRepository.save(farm);
  }

  public List<Farm> getAll() {
    return farmRepository.findAll();
  }

  public Farm findFarmById(Long id) throws FarmNotFoundException {
    return farmRepository.findById(id).orElseThrow(FarmNotFoundException::new);
  }
}
