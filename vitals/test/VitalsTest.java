package vitals.test;

import org.junit.Test;

/*
 * Copyright (c) Robert Bosch GmbH. All rights reserved.
 */

/**
 * @author msp5cob
 */

public class VitalsTest {

  @Test
  public void assertVitals(final boolean vitalStatus, final String vitalName) {
    if (vitalStatus) {
      System.out.println("Battery " + vitalName + " is within range!");
    }
    else {
      System.out.println("Battery " + vitalName + " is out of range!");
    }
  }
}
