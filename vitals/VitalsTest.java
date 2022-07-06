package vitals;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

/*
 * Copyright (c) Robert Bosch GmbH. All rights reserved.
 */

/**
 * @author msp5cob
 */
public class VitalsTest {

  @Test
  public void assertTemparature(final boolean tempStatus) {
    assertTrue("Battery Temperature is out of range!", tempStatus);
  }

  @Test
  public void assertChargeStatus(final boolean chargeStatus) {
    assertTrue("Battery State of Charge is out of range!", chargeStatus);
  }

  @Test
  public void assertRate(final boolean rateStatus) {
    assertTrue("Battery Charge Rate is out of range!", rateStatus);
  }
}
