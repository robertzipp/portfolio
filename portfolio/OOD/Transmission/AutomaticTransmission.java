public class AutomaticTransmission implements Transmission {

  /** Transmission that adjusts gears automatically, taking 5 speed thresholds for the
   *  6 possible gears in order (speed to go from 1 to 2 or back, speed
   *  to go from 2 to 3 or back, etc.).
   *  Objects represent a single transmission.
   *
   *  Constructor ensures that the input values are valid.
   *
   *  @throws IllegalArgumentException if any of the parameter values are not legal.
   *
   *  @param int current speed
   *  @param int currentGear
   *  @param int[5] transmission thresholds for 6 gears
   *
   *  @constraint no speeds less than 0mph
   *
   *  @author Robert "Bobby" Zipp
   *  @since 09/17/2020
   *
   *
   *  */

  int currentSpeed;
  int currentGear;
  int[] speedThresholds;

  /** Constructors
   *
   *  no-arg constructor: creates thresholds @ 15mph increments */

  public AutomaticTransmission() {
    int baseSpeed = 0;
    this.currentSpeed = 0;
    this.currentGear = 1;
    this.speedThresholds = new int[5];
    this.speedThresholds[0] = baseSpeed;
    for (int i = 1; i < 4; i++) {
      this.speedThresholds[i] = baseSpeed + 15;
    }
  }
  /** Constructor: Assumes equal distance between thresholds and assumes base speed of 0 */

  public AutomaticTransmission(int currentSpeed, int currentGear, int thresholdsEqual)  {
    int baseSpeed = 0;

    if (currentSpeed < 0) {
      throw new IllegalArgumentException("Speed cannot be negative.");
    }
    this.currentSpeed = currentSpeed;

    if (currentGear > 6) {
      throw new IllegalArgumentException("Gear input invalid. Gears range 1-6.");
    }
    this.currentGear = currentGear;

    this.speedThresholds = new int[5];
    this.speedThresholds[0] = baseSpeed;

    if (thresholdsEqual < 0) {
      throw new IllegalArgumentException("Thresholds cannot be negative distance apart");
    }
    for (int i = 1; i < 4; i++) {
      baseSpeed = baseSpeed + thresholdsEqual;
      this.speedThresholds[i] = baseSpeed;
    }
    this.checkGear();
  }

  /** Constructor: Custom input of thresholds and assumes base speed of 0 */

  public AutomaticTransmission(int currentSpeed, int currentGear, int[] thresholds) {
    int baseSpeed = 0;

    if (currentSpeed < 0) {
      throw new IllegalArgumentException("Speed cannot be negative.");
    }
    this.currentSpeed = currentSpeed;

    if (currentGear > 6) {
      throw new IllegalArgumentException("Gear input invalid. Gears range 1-6.");
    }
    this.currentGear = currentGear;

    this.speedThresholds = thresholds;

    this.checkGear();
  }



  @Override
  public Transmission increaseSpeed() {
    this.currentSpeed = this.currentSpeed + 2;
    checkGear();
    return this;
  }

  @Override
  public Transmission decreaseSpeed() {
    this.currentSpeed = this.currentSpeed - 2;
    if (this.currentSpeed < 0) {
      throw new IllegalStateException("Cannot reduce speed below 0");
    }
    checkGear();
    return this;
  }

  @Override
  public int getSpeed() {
    return this.currentSpeed;
  }

  @Override
  public int getCurrentGear() {
    return this.currentGear;
  }

  @Override
  public String toString() {
    return "AutomaticTransmission{" +
            " speed = " + currentSpeed +
            " gear =" + currentGear +
            '}';
  }
  /** helper function used during speed changes */

  public void checkGear() {
    int lowerThresh = this.speedThresholds[(this.currentGear - 1)];
    int upperThresh = this.speedThresholds[this.currentGear];
    if (lowerThresh >= this.currentSpeed) {
      if (this.currentGear == 1) {
        throw new IllegalStateException("Gear is already set to 1");
      }
      else {
        this.currentGear = this.currentGear - 1;
        checkGear();
      }
    }
    if (upperThresh < this.currentSpeed) {
      if (this.currentGear == 6) {
        throw new IllegalStateException("Gear is already set to 6");
      }
      else {
        this.currentGear = currentGear + 1;
        checkGear();
      }
    }
  }

}
