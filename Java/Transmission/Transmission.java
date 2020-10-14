public interface Transmission {

  /** Interface to build Transmission classes. Objects represent a single car
   *  transmission.
   *  @author Robert "Bobby" Zipp
   *  @since 09/17/2020 */

  //=============================================================

/** Methods:
 *
 *  increaseSpeed: returns a Transmission object with speed increased by 2 and
 *  the appropriate gear.
 *  Why not return void? Allows for multiple calls, e.g.:
 *    (1) Transmission a = AutomaticTransmission();
 *    (2)  a.increaseSpeed(). increaseSpeed(). increaseSpeed() */


 public Transmission increaseSpeed();

 /**
  * decreaseSpeed:  returns a Transmission object with speed decreased by 2 and the
  * appropriate gear. This method should throw an IllegalStateException
  * if the speed becomes invalid.
  *
  */

 public Transmission decreaseSpeed();

  /**
   * decreaseSpeed:  returns a Transmission object with speed decreased by 2 and the
   * appropriate gear. This method should throw an IllegalStateException
   * if the speed becomes invalid.
   *
   */

 public int getSpeed();

  /**
   * getSpeed: returns current speed. Default measured by mph. Cannot be negative.
   *
   */

 public int getCurrentGear();

  /**
   * getCurrentGear: returns current gear out of 6 based on preset speed thresholds.
   *
   */
}
