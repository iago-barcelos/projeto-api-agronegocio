package com.betrybe.agrix.ebytr.staff.exception;

/**
 * crop not found.
 */
public class CropNotFoundException extends NotFoundException {
  public CropNotFoundException() {
    super("Plantação não encontrada!");
  }
}
