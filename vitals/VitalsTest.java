package vitals;

/*
 * Copyright (c) Robert Bosch GmbH. All rights reserved.
 */

/**
 * @author msp5cob
 */
public class VitalsTest {

  public void assertTemparature(final boolean tempStatus) {
    if (!tempStatus) {
      System.out.println("Battery Temperature is out of range!");
    }
  }

  public void assertChargeStatus(final boolean chargeStatus) {
    if (!chargeStatus) {
      System.out.println("Battery State of Charge is out of range!");
    }
  }

  public void assertRate(final boolean rateStatus) {
    if (!rateStatus) {
      System.out.println("Battery Charge Rate is out of range!");
    }
  }
}
