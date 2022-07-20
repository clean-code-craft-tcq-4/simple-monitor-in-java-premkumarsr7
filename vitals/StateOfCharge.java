/*
 * Copyright (c) Robert Bosch GmbH. All rights reserved.
 */
package vitals;

import vitals.interfaces.VitalsInterface;

/**
 * @author msp5cob
 */
public class StateOfCharge implements VitalsInterface {

  private static float lowerLimit = 20f;

  private static float upperLimit = 80f;

  private final float soc;

  /*
   * Tolerance level to raise warning before raising error in percentage
   */
  private static final float TOLERANCE_FOR_WARNING = 5;

  public StateOfCharge(final float soc) {
    this.soc = soc;
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public boolean checkVitalsStatus() {
    return !((this.soc < lowerLimit) || (this.soc > upperLimit));
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public boolean isWarningToBeThrown() {
    return (this.soc >= (lowerLimit + (lowerLimit * (StateOfCharge.TOLERANCE_FOR_WARNING / 100)))) &&
        (this.soc <= (upperLimit - (upperLimit * (StateOfCharge.TOLERANCE_FOR_WARNING / 100))));
  }

}
