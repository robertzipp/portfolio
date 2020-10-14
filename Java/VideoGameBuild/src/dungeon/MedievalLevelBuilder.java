package dungeon;


/** @author robertzipp
 *  @since 10/03/2020
 *
 *  A class that builds a Medieval level as instructed in Lab 3. Builder method returns verified
 *  object of MedievalLevelBuilder based on specified parameters for targets.
 *
 * @param 'medievalLevel' - base class around which this class acts as a wrapper
 * @param 'MedievalLevelName'
 * @param 'target' numbers monster, treasure, rooms
 *
 * Notes: Construction of this class was difficult because of the way the default
 * package was presented. Data structures and interaction pathways were unclear and this caused
 * ambiguous coding situations. See line 111 for example.
 *
 *  */
public class MedievalLevelBuilder {


  Level medievalLevel;
  String MedievalLevelName;
  int targetNumberMonsters;
  int targetNumberTreasure;
  int targetNumberRooms;

  /** Constructor */

  public MedievalLevelBuilder(String medievalLevelName, Level levelNumber, int targetNumberMonsters,
                              int targetNumberRooms, int targetNumberTreasure)
          throws IllegalArgumentException {

    if (targetNumberMonsters < 0) {
      throw new IllegalArgumentException("Number of monsters cannot be negative");
    }

    if (targetNumberRooms < 1) {
      throw new IllegalArgumentException("Number of rooms cannot be less than one");
    }

    if (targetNumberTreasure < 0) {
      throw new IllegalArgumentException("Number of treasure items cannot be less than zero");
    }

    this.MedievalLevelName = medievalLevelName;
    this.medievalLevel = levelNumber;
    this.targetNumberMonsters = targetNumberMonsters;
    this.targetNumberRooms = targetNumberRooms;
    this.targetNumberTreasure = targetNumberTreasure;

  }

  /** Builder class */

  public MedievalLevelBuilder buildMedievalLevel()
          throws IllegalStateException {
    if (this.targetNumberTreasure != this.medievalLevel.getNumberTreasure()) {
      throw new IllegalStateException("Failed: treasure target not met");
    }
    else if (this.targetNumberMonsters != this.medievalLevel.getNumberOfMonsters()) {
      throw new IllegalStateException("Failed: monster target not met");
    }
    else if (this.targetNumberRooms != this.medievalLevel.rooms.size()) {
      throw new IllegalStateException("Failed: level target not met");
    }

    else {
      return this;
    }




  }

  public void addRoom(String roomDescription) throws IllegalStateException {
    if (this.medievalLevel.getNumRooms() >= targetNumberRooms) {
      throw new IllegalStateException("Max number of rooms reached");
    } else this.medievalLevel.addRoom(roomDescription);

    if (!this.medievalLevel.checkIfRoom(roomDescription)) {
      throw new IllegalStateException("Room does not exist");
    } else {
      this.medievalLevel.addRoom(roomDescription);
    }
  }

  public int getTotalTreasureValue() {
    int treasureTotals = 0;
    for (Room room : this.medievalLevel.rooms) {
      Treasure[] localSum = room.getTreasures();
      for (Treasure treasure : localSum) {
        treasureTotals = treasureTotals + treasure.getValue();
      }
    }
    return treasureTotals;
  }
  public void addGoblins(String roomDescription, int numberOfGoblins) throws
          IllegalStateException, IllegalArgumentException {
    if (!this.medievalLevel.checkIfRoom(roomDescription)) {
      throw new IllegalArgumentException("Invalid room");
    } else {
      for (int i = 0; i < numberOfGoblins; i++) {
        if (i >= targetNumberMonsters) {
          throw new IllegalStateException("Max number of monsters exceeded");
        }
      }
    }

    /** note : for each-loop becomes necessary here because ArrayList of attributes do
     *  not allow for reference by indexing, as given in starter package */

    for (Room room : this.medievalLevel.rooms) {
      if (room.getDescription() == roomDescription) {
        for (int i = 0; i < numberOfGoblins; i++) {
          room.addMonster(new Monster("Goblin" + Integer.toString(i),
                  "mischievous and very unpleasant, vengeful, and greedy creature " +
                          "whose primary purpose is to cause trouble to humankind", 7));
        }
      }
    }

  }

  public void addOrc(String roomDescription) throws IllegalStateException, IllegalArgumentException {
    if (!this.medievalLevel.checkIfRoom(roomDescription)) {
      throw new IllegalArgumentException("Invalid room");
    } else {
      {
        if (this.medievalLevel.getNumberOfMonsters() >= this.targetNumberMonsters) {
          throw new IllegalStateException("Max number of monsters exceeded");
        } else {
          this.medievalLevel.addMonster(roomDescription, new Monster("Orc",
                  "brutish, aggressive, malevolent being serving evil", 20));
        }
      }
    }
  }

  public void addOgre(String roomDescription)
          throws IllegalStateException, IllegalArgumentException {
    if (!this.medievalLevel.checkIfRoom(roomDescription)) {
      throw new IllegalArgumentException("Invalid room");
    } else {
      {
        if (this.medievalLevel.getNumberOfMonsters() >= this.targetNumberMonsters) {
          throw new IllegalStateException("Max number of monsters exceeded");
        } else {
          this.medievalLevel.addMonster(roomDescription, new Monster("Ogre",
                  "large, hideous man-like being that likes to eat humans for lunch",
                  50));
        }
      }
    }
  }

  public void addHuman(String roomDescription)
          throws IllegalStateException, IllegalArgumentException {
    if (!this.medievalLevel.checkIfRoom(roomDescription)) {
      throw new IllegalArgumentException("Invalid room");
    } else {
      {
        if (this.medievalLevel.getNumberOfMonsters() >= this.targetNumberMonsters) {
          throw new IllegalStateException("Max number of monsters exceeded");
        }

        /** Hit points left undefined in the project description? */

        else {
          this.medievalLevel.addMonster(roomDescription, new Monster("Human",
                  "a human that is a monster nonetheless",
                  100));
        }
      }
    }
  }

  public void addPotion(String roomDescription) throws IllegalStateException, IllegalArgumentException {
    if (!this.medievalLevel.checkIfRoom(roomDescription)) {
      throw new IllegalArgumentException("Invalid room");
    } else {
      {
        if (this.medievalLevel.getNumberTreasure() >= this.targetNumberTreasure) {
          throw new IllegalStateException("Max amount of treaure exceeded");
        } else {
          this.medievalLevel.addTreasure(roomDescription, new Treasure("a healing potion",
                  1));
        }
      }
    }
  }

  public void adGold(String roomDescription, int value) throws
          IllegalStateException, IllegalArgumentException {
    if (!this.medievalLevel.checkIfRoom(roomDescription)) {
      throw new IllegalArgumentException("Invalid room");
    } else {
      {
        if (this.medievalLevel.getNumberTreasure() >= this.targetNumberTreasure) {
          throw new IllegalStateException("Max amount of treasure exceeded");
        } else {
          this.medievalLevel.addTreasure(roomDescription, new Treasure("pieces of gold",
                  value));
        }
      }
    }
  }

  public void addWeapon(String roomDescription, String weaponName)
          throws IllegalStateException, IllegalArgumentException {
    if (!this.medievalLevel.checkIfRoom(roomDescription)) {
      throw new IllegalArgumentException("Invalid room");
    } else {
      {
        if (this.medievalLevel.getNumberTreasure() >= this.targetNumberTreasure) {
          throw new IllegalStateException("Max amount of treasure exceeded");
        } else {
          this.medievalLevel.addTreasure(roomDescription, new Treasure(weaponName,
                  10));
        }
      }
    }
  }

  public void addSpecial(String roomDescription, String specialName, int value)
          throws IllegalStateException, IllegalArgumentException {
    if (!this.medievalLevel.checkIfRoom(roomDescription)) {
      throw new IllegalArgumentException("Invalid room");
    } else {
      {
        if (this.medievalLevel.getNumberTreasure() >= this.targetNumberTreasure) {
          throw new IllegalStateException("Max amount of treasure exceeded");
        } else {
          this.medievalLevel.addTreasure(roomDescription, new Treasure(specialName,
                  value));
        }
      }
    }
  }


}
