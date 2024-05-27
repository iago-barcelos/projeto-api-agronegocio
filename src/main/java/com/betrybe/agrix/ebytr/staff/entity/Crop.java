package com.betrybe.agrix.ebytr.staff.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import java.time.LocalDate;
import java.util.List;


/**
 * crop entity.
 */
@Entity
@Table(name = "crop")
public class Crop {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  private String name;
  private double plantedArea;

  @Column(name = "planted_date")
  private LocalDate plantedDate;

  @Column(name = "harvest_date")
  private LocalDate harvestDate;

  @ManyToOne
  @JoinColumn(name = "farm_id")
  private Farm farmId;

  @ManyToMany
  @JoinTable(
          name = "crop_fertilizer",
          joinColumns = @JoinColumn(name = "crop_id"),
          inverseJoinColumns = @JoinColumn(name = "fertilizer_id")
  )
  private List<Fertilizer> fertilizers;

  public Crop() {
  }

  /**
   * construtor.
   */
  public Crop(String name, double plantedArea, LocalDate plantedDate, LocalDate harvestDate) {
    this.name = name;
    this.plantedArea = plantedArea;
    this.plantedDate = plantedDate;
    this.harvestDate = harvestDate;
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public double getPlantedArea() {
    return plantedArea;
  }

  public void setPlantedArea(double plantedArea) {
    this.plantedArea = plantedArea;
  }

  public Farm getFarmId() {
    return farmId;
  }

  public void setFarmId(Farm farmId) {
    this.farmId = farmId;
  }

  public LocalDate getPlantedDate() {
    return plantedDate;
  }

  public void setPlantedDate(LocalDate plantedDate) {
    this.plantedDate = plantedDate;
  }

  public LocalDate getHarvestDate() {
    return harvestDate;
  }

  public void setHarvestDate(LocalDate harvestDate) {
    this.harvestDate = harvestDate;
  }

  public List<Fertilizer> getFertilizers() {
    return fertilizers;
  }

  public void setFertilizers(List<Fertilizer> fertilizers) {
    this.fertilizers = fertilizers;
  }
}
