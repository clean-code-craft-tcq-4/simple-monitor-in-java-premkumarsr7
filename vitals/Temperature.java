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

  private final float temperature;

  public Temperature(final float temperature) {
    this.temperature = temperature;
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public boolean checkVitalsStatus() {
    return !((this.temperature < lowerLimit) || (this.temperature > upperLimit));
  }

}
