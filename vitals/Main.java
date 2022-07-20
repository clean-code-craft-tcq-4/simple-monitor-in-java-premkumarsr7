package vitals;

import java.util.ArrayList;
import java.util.List;

import vitals.interfaces.VitalsInterface;
import vitals.test.VitalsTest;

public class Main {

  public static void main(final String[] args) {
    List<VitalsInterface> vitalsList = new ArrayList<>();
    VitalsTest vitalTests = new VitalsTest();
    VitalsInterface vitals;
    // Unable to configure jUnit in git
    // since using this logic,
    // if JUnit is available all the Test data can be created and tested inside Junit class itself

    // Positive Case
    vitals = new Temperature(25f);
    testVitalBatteryStatus(vitals, vitalTests);
    vitalsList.add(vitals);
    vitals = new StateOfCharge(70f);
    testVitalBatteryStatus(vitals, vitalTests);
    vitalsList.add(vitals);
    vitals = new ChargeRate(0.7f);
    testVitalBatteryStatus(vitals, vitalTests);
    vitalsList.add(vitals);

    isBatteryOk(vitalsList);

    // Negative Case
    vitals = new Temperature(50f);
    testVitalBatteryStatus(vitals, vitalTests);
    vitalsList.add(vitals);
    vitals = new StateOfCharge(85f);
    testVitalBatteryStatus(vitals, vitalTests);
    vitalsList.add(vitals);
    vitals = new ChargeRate(0.9f);
    testVitalBatteryStatus(vitals, vitalTests);
    vitalsList.add(vitals);

    isBatteryOk(vitalsList);

    // Warning Case
    vitals = new Temperature(39f);
    testVitalBatteryStatus(vitals, vitalTests);
    vitalsList.add(vitals);
    vitals = new StateOfCharge(77f);
    testVitalBatteryStatus(vitals, vitalTests);
    vitalsList.add(vitals);
    vitals = new ChargeRate(0.79f);
    testVitalBatteryStatus(vitals, vitalTests);
    vitalsList.add(vitals);

    isBatteryOk(vitalsList);

  }

  private static boolean isBatteryOk(final List<VitalsInterface> vitals) {
    for (VitalsInterface vital : vitals) {
      if (!vital.checkVitalsStatus()) {
        return false;
      }
    }
    return true;
  }

  /**
   * @param vitalStatusMap
   * @param vitalTests
   */
  private static void testVitalBatteryStatus(final VitalsInterface vitals, final VitalsTest vitalTests) {
    vitalTests.assertVitals(vitals, vitals.getClass().getSimpleName());
  }
}
