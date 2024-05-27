package com.betrybe.agrix.ebytr.staff.controller;

import com.betrybe.agrix.ebytr.staff.dto.CropCreationDto;
import com.betrybe.agrix.ebytr.staff.dto.CropDto;
import com.betrybe.agrix.ebytr.staff.dto.FarmCreationDto;
import com.betrybe.agrix.ebytr.staff.dto.FarmDto;
import com.betrybe.agrix.ebytr.staff.entity.Crop;
import com.betrybe.agrix.ebytr.staff.entity.Farm;
import com.betrybe.agrix.ebytr.staff.exception.FarmNotFoundException;
import com.betrybe.agrix.ebytr.staff.service.CropService;
import com.betrybe.agrix.ebytr.staff.service.FarmService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;


/**
 * farm controller.
 */
@RestController
@RequestMapping(value = "/farms")
public class FarmController {
  private final FarmService farmService;
  private final CropService cropService;

  @Autowired
  public FarmController(FarmService farmService, CropService cropService) {
    this.farmService = farmService;
    this.cropService = cropService;
  }

  /**
   * createFarm.
   */
  @PostMapping
  @ResponseStatus(HttpStatus.CREATED)
  public FarmDto createFarm(@RequestBody FarmCreationDto farmCreationDto) {
    return FarmDto.fromEntity(
            farmService.createFarm(farmCreationDto.toEntity())
    );
  }

  @GetMapping
  @ResponseStatus(HttpStatus.OK)
  public List<FarmDto> getAllFarms() {
    List<Farm> farmsList = farmService.getAll();
    return farmsList.stream().map(FarmDto::fromEntity).toList();
  }

  /**
   * find by id.
   */
  @GetMapping("/{id}")
  @ResponseStatus(HttpStatus.OK)
  public FarmDto findById(@PathVariable Long id) throws FarmNotFoundException {
    return FarmDto.fromEntity(
            farmService.findFarmById(id)
    );
  }

  @PostMapping("/{farmId}/crops")
  @ResponseStatus(HttpStatus.CREATED)
  public CropDto createNewCrop(
          @RequestBody CropCreationDto cropCreationDto,
          @PathVariable Long farmId) throws FarmNotFoundException {
    return CropDto.fromEntity(cropService.createNewCrop(farmId, cropCreationDto.toEntity()));
  }

  /**
   * find crops of a farm.
   */
  @GetMapping("/{farmId}/crops")
  @ResponseStatus(HttpStatus.OK)
  public List<CropDto> getCrops(@PathVariable Long farmId) throws FarmNotFoundException {
    Farm farm = farmService.findFarmById(farmId);
    List<Crop> cropDtoList = farm.getCrops();

    return cropDtoList.stream().map(CropDto::fromEntity).toList();
  }
}
