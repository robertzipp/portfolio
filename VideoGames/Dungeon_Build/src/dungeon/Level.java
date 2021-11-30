package dungeon;

import java.util.ArrayList;
import java.util.List;

/**
 * Class representing a level in a dungeon consisting of a number of rooms.
 */
public class Level {

  private final int levelNumber;
  protected List<Room> rooms;

  /**
   * Constructor for a level in our dungeon.
   * 
   * @param levelNumber a numeric representing which level this is.
   */
  public Level(int levelNumber) {
    this.levelNumber = levelNumber;
    this.rooms = new ArrayList<>();
  }

  public boolean checkIfRoom(String roomDescription) {
    boolean roomExists = false;
    for (Room room : this.rooms) {
      if (room.getDescription()  == roomDescription) {
        roomExists = true;
      }
    }
    return roomExists;
  }

  /**
   * Accessor for the level number.
   * @return the level number
   */
  public int getLevelNumber() {
    return levelNumber;
  }

  public int getNumberOfMonsters() {
    int numberOfMonsters = 0;
    for (Room roomsLoop : this.rooms) {
      Monster[] roomMonstersArr = roomsLoop.getMonsters();
      numberOfMonsters = numberOfMonsters + roomMonstersArr.length;
    }
    return numberOfMonsters;
  }

  public int getNumberTreasure() {
    int numberOfTreasure = 0;
    for (Room roomsLoop : this.rooms) {
      Treasure[] treasureArr = roomsLoop.getTreasures();
      numberOfTreasure = numberOfTreasure + treasureArr.length;
    }
    return numberOfTreasure;

  }
  
  /**
   * Add a room to this level.
   * 
   * @param description the description of the room to add
   */
  public void addRoom(String description) {
    rooms.add(new Room(description));
  }

  public int getNumRooms() {
    return rooms.size();
  }



  /**
   * Adds a monster to a room.
   * 
   * @param roomDescription the room to add the monster to // data structures
   *                   don't allow for indexing, replaced w/ string
   * @param m          the monster to add
   */
  public void addMonster(String roomDescription, Monster m) {
    for (Room room : this.rooms) {
      if (room.getDescription() == roomDescription) {
        room.addMonster(m);
      }
    }
  }


  /**
   * Adds a treasure to a room.
   * 
   * @param roomDescription the room number to add the treasure to
   * @param t          the treasure to add
   */
  public void addTreasure(String roomDescription, Treasure t) {
    for (Room room : this.rooms) {
      if (room.getDescription() == roomDescription) {
        room.addTreasure(t);
      }
    }
  }
  
  @Override
  public String toString() {
    String start = String.format("Level %d contains %d rooms:\n", levelNumber, rooms.size());
    StringBuilder sb = new StringBuilder(start);
    for (int i = 0 ; i < rooms.size() ; i++) {
      sb.append("\nRoom " + i + " -- " + rooms.get(i).toString());
    }
    return sb.toString();
  }
}
