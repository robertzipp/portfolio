package cave_model.maze;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.LinkedList;
import java.lang.Math.*;
import java.util.Random;

public class PerfectMaze implements cave_model.maze.BaseMaze {

  /**
   * Implements BaseMaze interface to create perfect maze. Given the number of locations in the maze
   * as n = numberOfRows x numberOfColumns, the remaining number of walls must be equal to
   * numberOfEdges - n + 1
   */

  static int iterationCount = 0;

  private Character[][] mazeGrid;
  private Character start;
  private Character goal;
  private ArrayList<Character[]> wallsRemoved;
  private ArrayList<Character[]> wallsSaved;
  private ArrayList<Character[]> initialWallSets;
  private ArrayList<ArrayList<Character[]>> wallSets;
  private int n;
  private int columns;
  private int rows;
  private int numWallsNeedToRemain;
  private int playerGoldTotal;
  private String playerInfo;
  private boolean playerSolved;


  public PerfectMaze(Character start, Character goal, int columns, int rows, String player) {
    this.mazeGrid = new Character[rows][columns];
    this.start = start;
    this.goal = goal;
    this.wallsRemoved = new ArrayList<Character[]>();
    this.wallsSaved = new ArrayList<Character[]>();
    this.wallSets = new ArrayList<ArrayList<Character[]>>();
    this.initialWallSets = new ArrayList<Character[]>();
    this.n = columns * rows;
    this.columns = columns;
    this.rows = rows;
    this.playerInfo = player;
    this.playerGoldTotal = 0;
    this.playerSolved = false;
  }

  public PerfectMaze() {
    this.start = 'a'; // ASCII code 97
    this.goal = 'x';
    this.wallsRemoved = new ArrayList<Character[]>();
    this.wallsSaved = new ArrayList<Character[]>();
    this.initialWallSets = new ArrayList<Character[]>();
    this.wallSets = new ArrayList<ArrayList<Character[]>>();
    this.columns = 6;
    this.rows = 4;
    this.n = columns * rows;
    this.mazeGrid = new Character[this.rows][this.columns];
    this.playerGoldTotal = 0;
    this.playerInfo = "Player 1 ";
    this.playerSolved = false;
  }


  @Override
  public void renderMaze() {
    System.out.println();
    boolean isRendered = false;
    int localRenderingIndex = 0;
    int currentASCII = 97;
    Character[] edgePair = new Character[2];

    for (int i = 0; i < rows; i++) {
      for (int j = 0; j < columns; j++) {
        this.mazeGrid[i][j] = (char) currentASCII;
        currentASCII++;
      }
    }
    System.out.println("Current maze rendering: ");
    System.out.println();
    for (int i = 0; i < rows; i++) {
      System.out.print(this.mazeGrid[i][0] + " ");
      System.out.print(this.mazeGrid[i][1] + " ");
      System.out.print(this.mazeGrid[i][2] + " ");
      System.out.print(this.mazeGrid[i][3] + " ");
      System.out.print(this.mazeGrid[i][4] + " ");
      System.out.print(this.mazeGrid[i][5] + " ");
      System.out.println();
    }

    for (int i = 0; i < rows; i++) {
      for (int j = 0; j < columns; j++) {
        edgePair[0] = this.mazeGrid[i][j];
        if (i < rows - 1) {
          edgePair[1] = this.mazeGrid[i + 1][j];
          Character[] toStore = new Character[2];
          toStore[0] = edgePair[0];
          toStore[1] = edgePair[1];
          this.initialWallSets.add(toStore);

          // Initialize initial sets
          ArrayList<Character[]> anonymousArrayList = new ArrayList<Character[]>();
          anonymousArrayList.add(edgePair);
          this.wallSets.add(anonymousArrayList);
        }
        if (j < columns - 1) {
          edgePair[1] = this.mazeGrid[i][j + 1];
          Character[] toStore = new Character[2];
          toStore[0] = edgePair[0];
          toStore[1] = edgePair[1];
          this.initialWallSets.add(toStore);

          // Initialize initial sets
          ArrayList<Character[]> anonymousArrayList = new ArrayList<Character[]>();
          anonymousArrayList.add(edgePair);
          this.wallSets.add(anonymousArrayList);
        }
      }
    }

    this.mazeHelper();



  }

  public void mazeHelper() {

    // helper function
    // create arraylists from single sets
    for (Character[] pairs : this.initialWallSets) {
      ArrayList<Character[]> newAnonymousWallSet = new ArrayList<Character[]>();
      newAnonymousWallSet.add(pairs);
      wallSets.add(newAnonymousWallSet);
    }
    int localRenderingIndex_Col;
    int localRenderingIndex_Row;
    Random renderRandom = new Random();
    Character[] edgePair = new Character[2];

    // process unchecked wall sets
      int countdown = this.initialWallSets.size();
      while (countdown > 0) {
        //choose random edge
        int chosen = renderRandom.nextInt(Math.abs(this.initialWallSets.size()));
        Character[] anonymousPairChosen = this.initialWallSets.get(chosen);

        for (ArrayList<Character[]> pairSet : this.wallSets) {
          LinkedList<Character> containsChar = new LinkedList<Character>();
          for (Character[] pairs : pairSet) {
            // store all characters in this set as chars
            containsChar.add(pairs[0]);
            containsChar.add(pairs[1]);

          }
          if (containsChar.contains(anonymousPairChosen[0]) && containsChar.contains(anonymousPairChosen[1])) {
            if (!this.wallsRemoved.contains(anonymousPairChosen) &&
                    !this.wallsSaved.contains(anonymousPairChosen)) {
              this.wallsSaved.add(anonymousPairChosen);
              countdown--;
              break;
            }
          } else if (containsChar.contains(anonymousPairChosen[0]) || containsChar.contains(anonymousPairChosen[1])) {
            if (!this.wallsSaved.contains(anonymousPairChosen) &&
                    !this.wallsRemoved.contains(anonymousPairChosen)) {
              this.wallsRemoved.add(anonymousPairChosen);
              pairSet.add(anonymousPairChosen);
              countdown--;
              break;
            }
          }
        }
      }
  }


  public void setPlayerInfo(String playerInfo) {
    this.playerInfo = playerInfo;
  }

  public boolean isPlayerSolved() {
    return playerSolved;
  }

  public boolean getSolved(){
    return this.playerSolved;
  }

  public void setSolved(boolean b) {
    this.playerSolved = b;
  }

  public void setPlayerSolved(boolean playerSolved) {
    this.playerSolved = playerSolved;
  }



  @Override
  public void setMazeDimensions(int col, int row) {
    this.columns = col;
    this.rows = row;

  }

  @Override
  public void setGoalLocation(Character c) {
    this.goal = c;

  }

  @Override
  public Character getGoalLocation() {
    return this.goal;
  }

  @Override
  public void checkForGold() {

    Random renderRandom = new Random();
    int choice = renderRandom.nextInt(4);
    if (choice == 4) {
      this.playerGoldTotal = this.playerGoldTotal + renderRandom.nextInt(20);
      System.out.println("This location has gold! Current total = " + this.playerGoldTotal);
    }
  }

  @Override
  public void checkForRobber() {
    Random renderRandom = new Random();
    int choice = renderRandom.nextInt(9);
    double current = this.playerGoldTotal;
    if (choice == 9) {
      current = current * (.90);
      System.out.println("This room had a robber :( ");
    }
    this.playerGoldTotal = (int) Math.round(current);
    System.out.println("Your gold total is now " + this.playerGoldTotal);
  }


  @Override
  public int getPlayerGold() {
    return this.playerGoldTotal;
  }

  @Override
  public String getPlayerInfo() {
    return this.playerInfo;
  }

  @Override
  public String getMazeType() {
      return this.getClass().toString();
  }

  @Override
  public Character getStartPoint() {
        return this.start;
  }

  @Override
  public void setStartPoint(Character c) {
    this.start = c;

  }


  public ArrayList<Character[]> getWallsRemoved() {
    return wallsRemoved;
  }

  public void setWallsRemoved(ArrayList<Character[]> wallsRemoved) {
    this.wallsRemoved = wallsRemoved;
  }

  public ArrayList<Character[]> getWallsSaved() {
    return wallsSaved;
  }

  public void setWallsSaved(ArrayList<Character[]> wallsSaved) {
    this.wallsSaved = wallsSaved;
  }

  public int getColumns() {
    return columns;
  }

  public void setColumns(int columns) {
    this.columns = columns;
  }

  public int getRows() {
    return rows;
  }

  public void setRows(int rows) {
    this.rows = rows;
  }

  public Character[][] getMazeGrid() {
    return mazeGrid;
  }

  public void setMazeGrid(Character[][] mazeGrid) {
    this.mazeGrid = mazeGrid;
  }

  public Character getStart() {
    return start;
  }

  public void setStart(Character start) {
    this.start = start;
  }

  public Character getGoal() {
    return goal;
  }

  public void setGoal(Character goal) {
    this.goal = goal;
  }

  public ArrayList<Character[]> getInitialWallSets() {
    return initialWallSets;
  }

  public void setInitialWallSets(ArrayList<Character[]> initialWallSets) {
    this.initialWallSets = initialWallSets;
  }

  public ArrayList<ArrayList<Character[]>> getWallSets() {
    return wallSets;
  }

  public void setWallSets(ArrayList<ArrayList<Character[]>> wallSets) {
    this.wallSets = wallSets;
  }
}
