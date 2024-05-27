package com.betrybe.agrix.ebytr.staff.exception;

/**
 * farm not found.
 */
public class FarmNotFoundException extends NotFoundException {
  /**
   * farm not found.
   */
  public FarmNotFoundException() {
    super("Fazenda não encontrada!");
  }
}
