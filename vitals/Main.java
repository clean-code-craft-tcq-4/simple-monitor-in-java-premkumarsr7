package vitals;

import java.util.HashMap;
import java.util.Map;

public class Main {

  /**
   *
   */
  private static final String CHARGE_RATE = "Charge Rate";
  /**
   *
   */
  private static final String STATE_OF_CHARGE = "State of Charge";
  /**
   *
   */
  private static final String TEMPERATURE = "Temperature";

  static Map<String, Boolean> checkVitalsStatus(final Map<String, Float> vitalValuesMap) {
    Map<String, Boolean> vitalStatusMap = new HashMap<>();
    vitalStatusMap.put(TEMPERATURE, checkTemperatureRange(vitalValuesMap.get(TEMPERATURE)));
    vitalStatusMap.put(STATE_OF_CHARGE, checkChargeStatus(vitalValuesMap.get(STATE_OF_CHARGE)));
    vitalStatusMap.put(CHARGE_RATE, checkRate(vitalValuesMap.get(CHARGE_RATE)));
    return vitalStatusMap;
  }

  static boolean checkTemperatureRange(final float temperature) {
    if ((temperature < 0) || (temperature > 45)) {
      System.out.println("Temperature is out of range!");
      return false;
    }
    return true;
  }

  static boolean checkChargeStatus(final float soc) {
    if ((soc < 20) || (soc > 80)) {
      System.out.println("State of Charge is out of range!");
      return false;
    }
    return true;
  }

  static boolean checkRate(final float chargeRate) {
    if (chargeRate > 0.8) {
      System.out.println("Charge Rate is out of range!");
      return false;
    }
    return true;
  }

  public static void main(final String[] args) {
    Map<String, Float> vitalValuesMap = new HashMap<>();
    Map<String, Boolean> vitalStatusMap = new HashMap<>();
    VitalsTest vitalTests = new VitalsTest();

    // Positive case
    vitalValuesMap.put(TEMPERATURE, 25f);
    vitalValuesMap.put(STATE_OF_CHARGE, 70f);
    vitalValuesMap.put(CHARGE_RATE, 0.7f);
    vitalStatusMap = checkVitalsStatus(vitalValuesMap);

    testVitalBatteryStatus(vitalStatusMap, vitalTests);

    // Negative case
    vitalValuesMap.put(TEMPERATURE, 50f);
    vitalValuesMap.put(STATE_OF_CHARGE, 85f);
    vitalValuesMap.put(CHARGE_RATE, 0.9f);
    vitalStatusMap = checkVitalsStatus(vitalValuesMap);

    testVitalBatteryStatus(vitalStatusMap, vitalTests);

  }

  /**
   * @param vitalStatusMap
   * @param vitalTests
   */
  private static void testVitalBatteryStatus(final Map<String, Boolean> vitalStatusMap, final VitalsTest vitalTests) {
    vitalTests.assertTemparature(vitalStatusMap.get(TEMPERATURE));
    vitalTests.assertChargeStatus(vitalStatusMap.get(STATE_OF_CHARGE));
    vitalTests.assertRate(vitalStatusMap.get(CHARGE_RATE));
  }
}
