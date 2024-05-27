package com.betrybe.agrix.ebytr.staff.service;

import com.betrybe.agrix.ebytr.staff.entity.Crop;
import com.betrybe.agrix.ebytr.staff.entity.Farm;
import com.betrybe.agrix.ebytr.staff.entity.Fertilizer;
import com.betrybe.agrix.ebytr.staff.exception.CropNotFoundException;
import com.betrybe.agrix.ebytr.staff.exception.FarmNotFoundException;
import com.betrybe.agrix.ebytr.staff.exception.FertilizerNotFoundException;
import com.betrybe.agrix.ebytr.staff.repository.CropRepository;
import com.betrybe.agrix.ebytr.staff.repository.FertilizerRepository;
import java.time.LocalDate;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * crop service.
 */
@Service
public class CropService {
  private final CropRepository cropRepository;
  private final FarmService farmService;
  private final FertilizerService fertilizerService;
  private final FertilizerRepository fertilizerRepository;

  /**
   * constructor.
   */
  @Autowired
  public CropService(
          CropRepository cropRepository,
          FarmService farmService,
          FertilizerService fertilizerService,
          FertilizerRepository fertilizerRepository) {
    this.cropRepository = cropRepository;
    this.farmService = farmService;
    this.fertilizerService = fertilizerService;
    this.fertilizerRepository = fertilizerRepository;
  }

  /**
   * create new crop.
   */
  public Crop createNewCrop(Long farmId, Crop crop) throws FarmNotFoundException {
    Farm farm = farmService.findFarmById(farmId);
    crop.setFarmId(farm);
    return cropRepository.save(crop);
  }

  public List<Crop> getAllCrops()  {
    return cropRepository.findAll();
  }

  public Crop findCropById(Long id) throws CropNotFoundException {
    return cropRepository.findById(id).orElseThrow(CropNotFoundException::new);
  }

  /**
   * get crop by date.
   */
  public List<Crop> getCropByDate(LocalDate start, LocalDate end) {
    List<Crop> cropList = cropRepository.findAll();

    return cropList.stream().filter(crop -> !crop
            .getHarvestDate().isBefore(start) && !crop
            .getHarvestDate().isAfter(end)).toList();
  }

  /**
   * insert fertilizer into crop.
   */
  public Crop insertFertilizerIntoCrop(Long cropId, Long fertilizerId)
          throws CropNotFoundException, FertilizerNotFoundException {
    Crop crop = cropRepository.findById(cropId).orElseThrow(CropNotFoundException::new);
    Fertilizer fertilizer = fertilizerRepository.findById(fertilizerId)
            .orElseThrow(FertilizerNotFoundException::new);

    crop.getFertilizers().add(fertilizer);

    return cropRepository.save(crop);
  }

  /**
   * get fertilizers from a crop.
   */
  public List<Fertilizer> getFertilizersFromCrop(Long cropId) throws CropNotFoundException {
    Crop crop = cropRepository.findById(cropId)
            .orElseThrow(CropNotFoundException::new);

    return crop.getFertilizers();
  }
}
