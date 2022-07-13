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

}
