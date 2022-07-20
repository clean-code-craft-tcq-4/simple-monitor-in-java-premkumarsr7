/*
 * Copyright (c) Robert Bosch GmbH. All rights reserved.
 */
package vitals;

import vitals.interfaces.VitalsInterface;

/**
 * @author msp5cob
 */
public class Temperature implements VitalsInterface {

  private static float lowerLimit = 0f;

  private static float upperLimit = 40f;

  private final float temperatureValue;

  /*
   * Tolerance level to raise warning before raising error in percentage
   */
  private static final float TOLERANCE_FOR_WARNING = 5;

  public Temperature(final float temperatureValue) {
    this.temperatureValue = temperatureValue;
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public boolean checkVitalsStatus() {
    return (this.temperatureValue >= lowerLimit) && (this.temperatureValue <= upperLimit);
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public boolean isWarningToBeThrown() {
    return (this.temperatureValue >= (lowerLimit + (lowerLimit * (Temperature.TOLERANCE_FOR_WARNING / 100)))) &&
        (this.temperatureValue <= (upperLimit - (upperLimit * (Temperature.TOLERANCE_FOR_WARNING / 100))));
  }

}
