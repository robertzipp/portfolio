import org.junit.Assert;
import org.junit.Test;
import org.junit.Before;
import org.junit.After;

import dungeon.*;

/**
 * MedievalLevelBuilder Tester.
 *
 * @author <Robert Zipp>
 * @since <pre>Oct 4, 2020</pre>
 * @version 1.0
 */
public class MedievalLevelBuilderTest {

  MedievalLevelBuilder testLevel;
  Level baseLevel;

  @Before
  public void before() throws Exception {
    baseLevel = new Level(1);
    baseLevel.addRoom("MainRoom");
    baseLevel.addRoom("MainRoom2");
    testLevel = new MedievalLevelBuilder("TestLevel", baseLevel, 10, 2, 4);
    testLevel.addGoblins("MainRoom", 7);
    testLevel.addHuman("MainRoom");
    testLevel.addOgre("MainRoom2");
    testLevel.addOrc("MainRoom2");
    testLevel.addPotion("MainRoom");
    testLevel.adGold("MainRoom2", 30);
    testLevel.addSpecial("MainRoom", "Megan Thee Stallion ", 10000);
    testLevel.addWeapon("MainRoom","WAP");
  }


  /**
   *
   * Method: buildMedievalLevel(String medievalLevelName, Level levelNumber, int targetNumberTreasure, int targetNumberMonsters, int targetNumberRooms)
   *
   */
  @Test
  public void testBuildMedievalLevel() throws Exception {
    MedievalLevelBuilder expected = testLevel.buildMedievalLevel();
    Level myTestLevel= new Level(1);
    MedievalLevelBuilder test = new MedievalLevelBuilder("TestLevel", myTestLevel,
            10, 2, 4);

    myTestLevel.addRoom("MainRoom");
    myTestLevel.addRoom("MainRoom2");
    test.addGoblins("MainRoom", 7);
    test.addHuman("MainRoom");
    test.addOgre("MainRoom2");
    test.addOrc("MainRoom2");
    test.addPotion("MainRoom");
    test.adGold("MainRoom2", 30);
    test.addSpecial("MainRoom", "Megan Thee Stallion ", 10000);
    test.addWeapon("MainRoom","WAP");
    MedievalLevelBuilder output = test.buildMedievalLevel();

    Assert.assertEquals(testLevel.getTotalTreasureValue(), output.getTotalTreasureValue());


  }

  /**
   *
   * Method: addRoom(String roomDescription)
   *
   */
  @Test (expected = IllegalStateException.class)
  public void testAddRoom() {
    testLevel.addRoom("Room3");
    testLevel.buildMedievalLevel();
  }

  /**
   *
   * Method: addGoblins(String roomDescription, int numberOfGoblins)
   *
   */
  @Test (expected = IllegalStateException.class)
  public void testAddGoblins()  {
    testLevel.addGoblins("MainRoom", 20);
  }

  /**
   *
   * Method: addOrc(String roomDescription)
   *
   */
  @Test (expected = IllegalArgumentException.class)
  public void testNewMedievalLevel() {
    Level helloTestLevel = new Level(2);
    MedievalLevelBuilder helloTestBuilder =  new MedievalLevelBuilder(
            "HelloTestLevel", helloTestLevel,
            -1, 2, 4);

  }


}
