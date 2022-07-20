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

  private final float chargeRateValue;

  /*
   * Tolerance level to raise warning before raising error in percentage
   */
  private final float warningTolerance = 5;


  public ChargeRate(final float chargeRateValue) {
    this.chargeRateValue = chargeRateValue;
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public boolean checkVitalsStatus() {
    return this.chargeRateValue <= upperLimit;
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public boolean isWarningToBeThrown() {
    return this.chargeRateValue <= (upperLimit - (upperLimit * (this.warningTolerance / 100)));
  }

}
