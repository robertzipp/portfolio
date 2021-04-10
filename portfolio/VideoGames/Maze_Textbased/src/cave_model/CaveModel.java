package cave_model;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Random;

import cave_model.maze.RoomMaze;

public class CaveModel extends RoomMaze {

  private int status; // 0 = in play, 1 = win, 2 = loss
  private int[] wumpusLocation;
  private boolean wumpusRendered;
  private int n_Pits;
  private int n_Bats;
  private LinkedList<Integer[]> batLocations;
  private LinkedList<Integer[]> pitLocations;

  public CaveModel(Character start, Character goal, int columns, int rows, String player,
                   int maxWalls, LinkedList<Integer[]> batLocations,
                   LinkedList<Integer[]> pitLocations, int[] wumpusLocation, int n_pits, int n_bats) {
    super(start, goal, columns, rows, player, maxWalls);
    this.status = 0;
    this.wumpusRendered = false;
    this.batLocations = batLocations;
    this.pitLocations = pitLocations;
    this.wumpusLocation = wumpusLocation;
    this.n_Pits = n_pits;
    this.setPitLocations(n_pits);
    this.n_Bats = n_bats;
    this.setBatLocations(n_bats);
  }

  public CaveModel() {
    super();
    this.status = 0;
    this.batLocations = new LinkedList<Integer[]>();
    this.pitLocations = new LinkedList<Integer[]>();
    this.wumpusLocation = new int[2];
    this.wumpusRendered = false;
    this.n_Pits = 1;
    this.n_Bats = 1;

  }

  public void setBatLocations(int n){
    Random renderRandom = new Random();
    Character[][] workingGrid = this.getMazeGrid();
    for (int i = 0; i < n; n++) {
      int row = renderRandom.nextInt(this.getRows());
      int col = renderRandom.nextInt(this.getColumns());
      Integer[] hasBat = new Integer[2];
      hasBat[0] = row;
      hasBat[1] = col;
      this.batLocations.add(hasBat);
    }
  }


  public void setPitLocations(int n){
    Random renderRandom = new Random();
    Character[][] workingGrid = this.getMazeGrid();
    for (int i = 0; i < n; n++) {
      int row = renderRandom.nextInt(this.getRows());
      int col = renderRandom.nextInt(this.getColumns());
      Integer[] hasPit = new Integer[2];
      hasPit[0] = row;
      hasPit[1] = col;
      this.pitLocations.add(hasPit);
    }

  }

  public int getStatus() {
    return status;
  }

  public void setStatus(int status) {
    this.status = status;
  }

  public int[] getWumpusLocation() {
    return this.wumpusLocation;
  }

  public boolean checkIfCave(int coord_A, int coord_B) {
    int numLocalEdges = 0;
   Character[][] gridForCheck =  this.getMazeGrid();
   Character current = gridForCheck[0][1];
   for (Character[] edges : this.getWallsSaved()) {
     if (edges[0] == current || edges[1] == current) {
       numLocalEdges++;
     }
   }
    return numLocalEdges != 2;
  }

  public LinkedList<Integer[]> getBatLocations() {
    return batLocations;
  }

  public LinkedList<Integer[]> getPitLocations() {
    return pitLocations;
  }

  public void renderWumpusLocation() {
  Random renderRandom = new Random();
    while (!this.wumpusRendered) {
    this.wumpusLocation[0] = renderRandom.nextInt(this.getRows());
    this.wumpusLocation[1] = renderRandom.nextInt(this.getColumns());
    if (this.checkIfCave(this.wumpusLocation[0], this.wumpusLocation[1])) {
      wumpusRendered = true; }
    }
  }
}
