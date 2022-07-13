/*
 * Copyright (c) Robert Bosch GmbH. All rights reserved.
 */
package vitals;

import vitals.interfaces.VitalsInterface;

/**
 * @author msp5cob
 */
public class ChargeRate implements VitalsInterface {

  private static float upperLimit = 0.8f;

  private final float chargeRate;

  public ChargeRate(final float chargeRate) {
    this.chargeRate = chargeRate;
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public boolean checkVitalsStatus() {
    return !(this.chargeRate > upperLimit);
  }

}
