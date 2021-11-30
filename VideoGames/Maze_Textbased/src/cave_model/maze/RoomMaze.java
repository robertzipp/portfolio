package cave_model.maze;

import java.util.ArrayList;

public class RoomMaze extends cave_model.maze.PerfectMaze {

  private int maxWalls;

  public RoomMaze(Character start, Character goal, int columns, int rows, String player, int maxWalls) {
    super(start, goal, columns, rows, player);
    this.maxWalls = maxWalls;
  }

  public RoomMaze() {
    super();
    this.maxWalls = -1;
  }

  public int getMaxWalls() {
    return maxWalls;
  }

  public void setMaxWalls(int maxWalls) {
    this.maxWalls = maxWalls;
  }

  public void checkWalls() {
    ArrayList<Character[]> currentRemoved = this.getWallsRemoved();
    ArrayList<Character[]> currentSaved = this.getWallsSaved();
    while (currentRemoved.size() > this.maxWalls) {
      currentRemoved.add(currentSaved.remove(0));
    }
    this.setWallsSaved(currentSaved);
    this.setWallsRemoved(currentRemoved);
  }

}
