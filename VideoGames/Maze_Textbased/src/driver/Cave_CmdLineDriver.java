package driver;

import java.util.Random;
import java.util.Scanner;

import cave_model.CaveModel;
import controller.WumpusController;

public class Cave_CmdLineDriver {

  public static void main(String[] args) {

    System.out.println("Welcome to Hunt the Wumpus.");
    char currentPoint = 'a';
    int currentCoords_a = 0;
    int currentCoords_b = 0;
    boolean inCave = false;
    int arrows = 5;

    String selectMoveAttempt = "";
    Scanner commandLine = new Scanner(System.in);
    WumpusController workingController = new WumpusController();
    CaveModel workingModel = workingController.getModel();
    workingModel.renderMaze();
    Character[][] mazeGrid = workingModel.getMazeGrid();
    System.out.println("Please enter player name");
    String playerName = commandLine.nextLine();
    workingModel.setPlayerInfo(playerName);
    System.out.println("Confirmed. Do you want to build a custom game map" +
            "or use the default map? Enter c for custom and d for default");
    String inputChar =  commandLine.nextLine();
    char in = inputChar.charAt(0);
    if (in == 'c') {
      System.out.println("Custom maps will be available in a future release.");
      return;
    }


    while (workingModel.getStatus() == 0) {
      System.out.println("Shoot or Move (S-M)?");
      String inputChar_move =  commandLine.nextLine();
      char in_Move = inputChar_move.charAt(0);
      if (in_Move == 'S' && arrows > 0) {
        String shotDirection = "";
        System.out.println("Choose direction to shoot: N or S or E or W: ");
        shotDirection = commandLine.next();
        char shotDirection_char = shotDirection.charAt(0);
        System.out.println("Choose how far to shoot (in number of caves)");
        int shotLength = commandLine.nextInt();
        workingModel.setStatus(workingController.runShot(currentCoords_a,
                currentCoords_b, shotLength, shotDirection_char));
        String leftover = commandLine.nextLine();
        arrows--;
        System.out.println("You now have " + arrows + " arrows left.");
        if (arrows == 0 && workingModel.getStatus() == 0) {
          workingModel.setStatus(2);
        }
      }

      if (in_Move == 'M') {
        char moveAttempt = '0';
        int[] coordResult;
        workingController.setModel(workingModel);
        System.out.println("Current location = " + currentPoint);
        System.out.println("Choose direction to move: N or S or E or W: ");
        selectMoveAttempt = commandLine.next();
        char moveAttempt_dir = selectMoveAttempt.charAt(0);
        System.out.println("Selected " + moveAttempt_dir);
        coordResult = workingController.runMove(moveAttempt_dir, currentCoords_a, currentCoords_b);
        currentCoords_a = coordResult[0];
        currentCoords_b = coordResult[1];
        moveAttempt = mazeGrid[currentCoords_a][currentCoords_b];
        boolean localBlock = false;
        for (Character[] pair : workingModel.getWallsSaved()) {
          Character a = pair[0];
          Character b = pair[1];
          if ((a == currentPoint || a == moveAttempt) && (b == currentPoint || b == moveAttempt)) {
            System.out.println("Wall has blocked your path. Try again.");
            localBlock = true;
            break;
          }
        }
        if (localBlock) {
          continue;
        } else {
          if (currentCoords_a == workingModel.getWumpusLocation()[0]
          && currentCoords_b == workingModel.getWumpusLocation()[1]){
            System.out.println("Oh no! You got eaten by the wumpus.");
            workingModel.setStatus(2);
            break;
          }
          boolean hasBats = false;
          boolean hasPit = false;
          Random renderRandom = new Random();
          for (Integer[] coords : workingModel.getBatLocations()) {
            int a = coords[0];
            int b = coords[1];
            if (a == currentCoords_a && b == currentCoords_b ) {
                  if (workingController.checkForBats()) {
                    hasBats = true;
                    currentCoords_a = renderRandom.nextInt(workingModel.getRows());
                    currentCoords_b = renderRandom.nextInt(workingModel.getColumns());
                    moveAttempt = mazeGrid[currentCoords_a][currentCoords_b];
                  }
            }
          }

          for (Integer[] coords : workingModel.getPitLocations()) {
            int a = coords[0];
            int b = coords[1];
            if (a == currentCoords_a && b == currentCoords_b ) {
              if (workingController.checkForPit()) {
                hasPit = true;
              } }
              if (hasPit && hasBats) {
                int saved = renderRandom.nextInt(2);
                if (saved == 1 ) {
                  System.out.println("Some superbats saved you before you fell into a pit!");
                  break;
                }
              }
              else {
                workingModel.setStatus(2);
                break;
              }
            }

          currentPoint = moveAttempt;
        }
      }


    System.out.println("Loading ... ");
      }

    if (workingModel.getStatus() == 1) {
      System.out.println("You won the game!");
    }
    if (workingModel.getStatus() == 2) {
      System.out.println("Sorry, you lost this time.");
    }
    }
}

