package controller;

import java.util.LinkedList;
import java.util.Random;

import cave_model.CaveModel;

public class WumpusController  {


  private CaveModel model;


  public WumpusController(CaveModel model) {
    this.model = model;
    this.model.renderWumpusLocation();

  }
  public WumpusController() {
    this.model = new CaveModel();
    this.model.renderWumpusLocation();

  }

  public CaveModel getModel() {
    return model;
  }

  public void setModel(CaveModel model) {
    this.model = model;
  }

  public boolean checkForBats() {
    boolean hasBats = false;
    Random renderRandom = new Random();
    int result = renderRandom.nextInt(10);
    if (result == 10) {
      System.out.println("Oh no! Bats! You were carried away to a different location ... ");
      return true;
    }
    return false;
  }

  public boolean checkForPit() {
    boolean hasPit = false;
    Random renderRandom = new Random();
    int result = renderRandom.nextInt(20);
    if (result == 10) {
      System.out.println("Oh no! You fell into a pit ... ");
      return true;
    }
    return false;
  }

  public int[] runMove(char moveSelection, int coords_A, int coords_B) {
    switch (moveSelection) {
      case 'N':
        if (coords_A - 1 < 0) {
          System.out.println("Invalid entry, out of bounds");
          break;
        } else {
          coords_A = coords_A - 1;
          break;
        }
      case 'S':
        if ((coords_A + 1) > (this.model.getRows() - 1)) {
          System.out.println("Invalid entry, out of bounds");
          break;
        } else {
          coords_A = coords_A + 1;
          break;
        }
      case 'E':
        if ((coords_B + 1) > (this.model.getColumns() - 1)) {
          System.out.println("Invalid entry, out of bounds");
          break;
        } else {
          coords_B = coords_B + 1;
          break;
        }
      case 'W':
        if (coords_B - 1 < 0) {
          System.out.println("Invalid entry, out of bounds");
          break;
        } else {
          coords_B = coords_B - 1;
          break;
        }
      default:
        throw new IllegalArgumentException("Invalid entry. Try again.");
    }

  int[] result = new int[2];
    result[0] = coords_A;
    result[1] = coords_B;
    return result;
  }
  public int runShot(int coords_a, int coords_b, int numCaves, char direction){
    if (!this.model.checkIfCave(coords_a, coords_b)) {
      System.out.println("This is not a cave, move to a cave and try again.");
    }
    int[] currentWumpusLocation = this.model.getWumpusLocation();
    switch (direction) {
      case 'N':
        if (coords_a - numCaves == currentWumpusLocation[0]) {
          System.out.println("You slayed the Wumpus!");
          return 1;
        }
      case 'S':
        if (coords_a + numCaves == currentWumpusLocation[0]) {
          System.out.println("You slayed the Wumpus!");
          return 1;
        }
      case 'E':
        if (coords_b - numCaves == currentWumpusLocation[1]) {
          System.out.println("You slayed the Wumpus!");
          return 1;
        }
      case 'W':
        if (coords_b + numCaves == currentWumpusLocation[1]) {
          System.out.println("You slayed the Wumpus!");
          return 1;
        }
      default:
        System.out.println("You missed. Keep going!");
    }
    return 0;
  }

}