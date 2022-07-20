package vitals.test;

import vitals.interfaces.VitalsInterface;

/*
 * Copyright (c) Robert Bosch GmbH. All rights reserved.
 */

/**
 * @author msp5cob
 */

public class VitalsTest {

  public void assertVitals(final VitalsInterface vital, final String vitalName) {
    if (!vital.checkVitalsStatus()) {
      System.out.println("ERROR --- Battery " + vitalName + " is out of range!");
    }
    else if (!vital.isWarningToBeThrown()) {
      System.out.println("WARNING --- Battery " + vitalName + " is close to out of range!");
    }
  }
}
