package vitals;

import vitals.interfaces.VitalsInterface;
import vitals.test.VitalsTest;

public class Main {

  public static void main(final String[] args) {
    VitalsTest vitalTests = new VitalsTest();
    VitalsInterface vitals;

    // Positive Case
    vitals = new Temperature(25f);
    testVitalBatteryStatus(vitals, vitalTests);

    vitals = new StateOfCharge(70f);
    testVitalBatteryStatus(vitals, vitalTests);

    vitals = new ChargeRate(0.7f);
    testVitalBatteryStatus(vitals, vitalTests);

    // Negative Case
    vitals = new Temperature(50f);
    testVitalBatteryStatus(vitals, vitalTests);

    vitals = new StateOfCharge(85f);
    testVitalBatteryStatus(vitals, vitalTests);

    vitals = new ChargeRate(0.9f);
    testVitalBatteryStatus(vitals, vitalTests);


  }

  /**
   * @param vitalStatusMap
   * @param vitalTests
   */
  private static void testVitalBatteryStatus(final VitalsInterface vitals, final VitalsTest vitalTests) {
    vitalTests.assertVitals(vitals.checkVitalsStatus(), vitals.getClass().getSimpleName());
  }
}
