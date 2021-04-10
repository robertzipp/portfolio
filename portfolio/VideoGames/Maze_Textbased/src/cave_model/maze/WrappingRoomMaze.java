package cave_model.maze;

import java.util.ArrayList;

public class WrappingRoomMaze extends cave_model.maze.RoomMaze {


  public WrappingRoomMaze(Character start, Character goal, int columns, int rows, String player, int maxWalls) {
    super(start, goal, columns, rows, player, maxWalls);
  }

  public WrappingRoomMaze() {
    super();
  }

  @Override
  // Overrides rendering stage to include "wrapped" edges
  public void renderMaze() {
    int columns = super.getColumns();
    int rows = super.getRows();
    Character[][] mazeGrid = super.getMazeGrid();
    ArrayList<Character[]> initialWallSets = super.getInitialWallSets();
    ArrayList<Character[]> removedWallSets = super.getWallsRemoved();
    ArrayList<Character[]> savedWallSets = super.getWallsSaved();
    ArrayList<ArrayList<Character[]>> wallSets = super.getWallSets();
    Character start = super.getStart();
    Character goal = super.getGoal();

    boolean isRendered = false;
    int localRenderingIndex = 0;
    int currentASCII = 97;
    Character[] edgePair = new Character[2];

    for (int i = 0; i < rows; i++) {
      for (int j = 0; j < columns; j++) {
        mazeGrid[i][j] = (char) currentASCII;
        currentASCII++;
      }
    }
    System.out.println("Current maze rendering: ");
    System.out.println();
    for (int i = 0; i < rows; i++) {
      System.out.print(mazeGrid[i][0] + " ");
      System.out.print(mazeGrid[i][1] + " ");
      System.out.print(mazeGrid[i][2] + " ");
      System.out.print(mazeGrid[i][3] + " ");
      System.out.print(mazeGrid[i][4] + " ");
      System.out.print(mazeGrid[i][5] + " ");
      System.out.println();
    }

    for (int i = 0; i < rows; i++) {
      for (int j = 0; j < columns; j++) {
        edgePair[0] = mazeGrid[i][j];
        if (i < rows - 1) {
          edgePair[1] = mazeGrid[i + 1][j];
          Character[] toStore = new Character[2];
          toStore[0] = edgePair[0];
          toStore[1] = edgePair[1];
          if(toStore[0] != toStore[1]) {
            initialWallSets.add(toStore);
          }

          // Initialize initial sets
          ArrayList<Character[]> anonymousArrayList = new ArrayList<Character[]>();
          anonymousArrayList.add(edgePair);
          wallSets.add(anonymousArrayList);
        }
        // wrapping edges
        if (i == rows - 1) {
          edgePair[1] = mazeGrid[i][0];
          Character[] toStore = new Character[2];
          toStore[0] = edgePair[0];
          toStore[1] = edgePair[1];
          if(toStore[0] != toStore[1]) {
            initialWallSets.add(toStore);
          }
          // Initialize initial sets
          ArrayList<Character[]> anonymousArrayList = new ArrayList<Character[]>();
          anonymousArrayList.add(edgePair);
          wallSets.add(anonymousArrayList);
        }
        if (i == 0 && j != 0) {
          edgePair[1] = mazeGrid[i][columns - 1];
          Character[] toStore = new Character[2];
          toStore[0] = edgePair[0];
          toStore[1] = edgePair[1];
          if(toStore[0] != toStore[1]) {
            initialWallSets.add(toStore);
          }
          // Initialize initial sets
          ArrayList<Character[]> anonymousArrayList = new ArrayList<Character[]>();
          anonymousArrayList.add(edgePair);
          wallSets.add(anonymousArrayList);
        }
        if (j < columns - 1) {
          edgePair[1] = mazeGrid[i][j];
          Character[] toStore = new Character[2];
          toStore[0] = edgePair[0];
          toStore[1] = edgePair[1];
          if(toStore[0] != toStore[1]) {
            initialWallSets.add(toStore);
          }

          // Initialize initial sets
          ArrayList<Character[]> anonymousArrayList = new ArrayList<Character[]>();
          anonymousArrayList.add(edgePair);
          wallSets.add(anonymousArrayList);
        }
        // wrapping edges
        if (j == columns - 1) {
          edgePair[1] = mazeGrid[0][j];
          Character[] toStore = new Character[2];
          toStore[0] = edgePair[0];
          toStore[1] = edgePair[1];
          if(toStore[0] != toStore[1]) {
            initialWallSets.add(toStore);
          }

          // Initialize initial sets
          ArrayList<Character[]> anonymousArrayList = new ArrayList<Character[]>();
          anonymousArrayList.add(edgePair);
          wallSets.add(anonymousArrayList);
        }
        if (i != 0 && j == 0) {
          edgePair[1] = mazeGrid[rows - 1][j];
          Character[] toStore = new Character[2];
          toStore[0] = edgePair[0];
          toStore[1] = edgePair[1];
          if(toStore[0] != toStore[1]) {
            initialWallSets.add(toStore);
          }

          // Initialize initial sets
          ArrayList<Character[]> anonymousArrayList = new ArrayList<Character[]>();
          anonymousArrayList.add(edgePair);
          wallSets.add(anonymousArrayList);
        }
      }
    }

    this.mazeHelper();
  }

}
