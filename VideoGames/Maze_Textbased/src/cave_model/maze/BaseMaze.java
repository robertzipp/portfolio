package cave_model.maze;

import java.util.ArrayList;

public interface BaseMaze {

  /** interface for building all 3 types of mazes
   *  Note: Given the number of locations in the maze as n = numberOfRows x numberOfColumns,
   *  the remaining number of walls must be between 0 (a maze where all locations are rooms with
   *  4 doors) and numberOfEdges - n + 1 (a perfect maze).
   * */


  public void renderMaze();

  public void mazeHelper();

  public void setMazeDimensions(int x, int y);

  public void setGoalLocation(Character c);

  public Character getGoalLocation();

  public void checkForGold();

  public void checkForRobber();

  public int getPlayerGold();

  public boolean getSolved();

  public void setSolved(boolean b);

  public String getPlayerInfo();

  public String getMazeType();

  public Character getStartPoint();

  public void setStartPoint(Character c);

  public void setPlayerInfo(String s);

  public ArrayList<Character[]> getInitialWallSets();

  public void setInitialWallSets(ArrayList<Character[]> initialWallSets);

  public ArrayList<ArrayList<Character[]>> getWallSets();

  public void setWallSets(ArrayList<ArrayList<Character[]>> wallSets);

  public Character[][] getMazeGrid();

  public void setMazeGrid(Character[][] mazeGrid);

  public ArrayList<Character[]> getWallsRemoved() ;

  public void setWallsRemoved(ArrayList<Character[]> wallsRemoved);

  public ArrayList<Character[]> getWallsSaved();

  public void setWallsSaved(ArrayList<Character[]> wallsSaved);

  public int getColumns();

  public void setColumns(int columns);

  public int getRows() ;

  public void setRows(int rows);

}
