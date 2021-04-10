import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;


public class AutomaticTransmissionTest {

  /**
   * AutomaticTransmission (implements Transmission) Tester.
   *
   * @author <Robert Zipp>
   * @since <pre>Sep 17, 2020</pre>
   * @version 1.0
   */

  @Test
  public void constructorTest1 () {
    AutomaticTransmission testObj = new AutomaticTransmission(24, 3, 10);
    Assert.assertEquals(testObj.currentGear, 3);
  }

  @Test
  public void constructorTest2 () {
    int[] testArr = new int[5];
    testArr[0] = 0;
    testArr[1] = 7;
    testArr[2] = 20;
    testArr[3] = 47;
    testArr[4] = 95;
    AutomaticTransmission testObj = new AutomaticTransmission(51, 1, testArr);
    Assert.assertEquals(testObj.currentGear, 4);
  }



  @Test
  public void increaseSpeedTest() {
    int[] testArr = new int[5];
    testArr[0] = 0;
    testArr[1] = 7;
    testArr[2] = 20;
    testArr[3] = 47;
    testArr[4] = 95;
    AutomaticTransmission testObj = new AutomaticTransmission(51, 1, testArr);
    testObj.increaseSpeed();
    testObj.increaseSpeed().increaseSpeed().increaseSpeed().increaseSpeed();
    System.out.println(testObj.toString());
    Assert.assertEquals(testObj.currentSpeed, 61);

  }

  @Test
  public void decreaseSpeedTest () {
    AutomaticTransmission testObj = new AutomaticTransmission(5, 1, 10);
    testObj.decreaseSpeed();
    Assert.assertEquals(testObj.currentSpeed, 3);
  }
  @Test (expected = IllegalStateException.class)
  public void decreaseSpeedOverloadTest () {
    AutomaticTransmission testObj = new AutomaticTransmission(5, 1, 10);
    testObj.decreaseSpeed().decreaseSpeed().decreaseSpeed().decreaseSpeed();
  }
  

}