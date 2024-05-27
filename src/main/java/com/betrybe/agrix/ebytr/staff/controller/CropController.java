package com.betrybe.agrix.ebytr.staff.controller;

import com.betrybe.agrix.ebytr.staff.dto.CropDto;
import com.betrybe.agrix.ebytr.staff.dto.FertilizerDto;
import com.betrybe.agrix.ebytr.staff.entity.Crop;
import com.betrybe.agrix.ebytr.staff.entity.Fertilizer;
import com.betrybe.agrix.ebytr.staff.exception.CropNotFoundException;
import com.betrybe.agrix.ebytr.staff.exception.FertilizerNotFoundException;
import com.betrybe.agrix.ebytr.staff.service.CropService;
import java.time.LocalDate;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

/**
 * crop controller.
 */
@RestController
@RequestMapping(value = "/crops")
public class CropController {
  private final CropService cropService;

  @Autowired
  public CropController(CropService cropService) {
    this.cropService = cropService;
  }

  /**
   * find all crops.
   */
  @GetMapping
  @ResponseStatus(HttpStatus.OK)
  public List<CropDto> findAll() {
    List<Crop> crops = cropService.getAllCrops();

    return crops.stream().map(CropDto::fromEntity).toList();
  }

  @GetMapping("/{id}")
  @ResponseStatus(HttpStatus.OK)
  public CropDto cropInfo(@PathVariable Long id) throws CropNotFoundException {
    return CropDto.fromEntity(cropService.findCropById(id));
  }

  /**
   * Get crops by date.
   */
  @GetMapping("/search")
  public List<CropDto> getCropsByDate(@RequestParam String start, String end) {
    List<Crop> cropsList = cropService.getCropByDate(
            LocalDate.parse(start), LocalDate.parse(end)
    );

    return cropsList.stream().map(CropDto::fromEntity).toList();
  }

  /**
   * insert fertilizer into crop.
   */
  @PostMapping("/{cropId}/fertilizers/{fertilizerId}")
  @ResponseStatus(HttpStatus.CREATED)
  public ResponseEntity<String> insertFertilizerIntoCrop(
          @PathVariable Long cropId, @PathVariable Long fertilizerId)
          throws CropNotFoundException, FertilizerNotFoundException {
    try {
      Crop newCrop = cropService.insertFertilizerIntoCrop(cropId, fertilizerId);
      return ResponseEntity
              .status(HttpStatus.CREATED)
              .body("Fertilizante e plantação associados com sucesso!");

    } catch (CropNotFoundException | FertilizerNotFoundException exception) {
      return ResponseEntity
              .status(HttpStatus.NOT_FOUND)
              .body(exception.getMessage());
    }
  }

  /**
   * get fertilizers from a crop.
   */
  @GetMapping("/{cropId}/fertilizers")
  @ResponseStatus(HttpStatus.OK)
  public List<FertilizerDto> getFertilizersFromCrop(@PathVariable Long cropId)
          throws CropNotFoundException {
    List<Fertilizer> fertilizers = cropService.getFertilizersFromCrop(cropId);

    return fertilizers.stream().map(FertilizerDto::fromEntity).toList();
  }
}
