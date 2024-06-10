package com.betrybe.agrix.ebytr.staff.controller;

import com.betrybe.agrix.ebytr.staff.dto.FertilizerCreationDto;
import com.betrybe.agrix.ebytr.staff.dto.FertilizerDto;
import com.betrybe.agrix.ebytr.staff.entity.Fertilizer;
import com.betrybe.agrix.ebytr.staff.exception.FertilizerNotFoundException;
import com.betrybe.agrix.ebytr.staff.service.FertilizerService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

/**
 * fertilizer controller.
 */
@RestController
@RequestMapping(value = "/fertilizers")
@Secured({ "ADMIN" })
public class FertilizerController {
  private final FertilizerService fertilizerService;

  @Autowired
  public FertilizerController(FertilizerService fertilizerService) {
    this.fertilizerService = fertilizerService;
  }

  @PostMapping
  @ResponseStatus(HttpStatus.CREATED)
  public FertilizerDto createNewFertilizer(@RequestBody FertilizerCreationDto dto) {
    return FertilizerDto.fromEntity(fertilizerService.createNewFertilizer(dto.toEntity()));
  }

  /**
   * get fertilizers.
   */
  @GetMapping
  @ResponseStatus(HttpStatus.OK)
  public List<FertilizerDto> getAllFertilizers() {
    List<Fertilizer> fertilizerList = fertilizerService.getAllFertilizers();

    return fertilizerList.stream().map(FertilizerDto::fromEntity).toList();
  }

  @GetMapping("/{id}")
  @ResponseStatus(HttpStatus.OK)
  public FertilizerDto getFertilizerById(@PathVariable Long id) throws FertilizerNotFoundException {
    return FertilizerDto.fromEntity(fertilizerService.getFertilizerById(id));
  }
}
