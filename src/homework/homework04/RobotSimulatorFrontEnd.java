/*
 * SPDX-FileCopyrightText: 2024 Samuel Wu
 *
 * SPDX-License-Identifier: MIT
 */

package homework.homework04;

import java.util.Scanner;

public class RobotSimulatorFrontEnd {
  public static final Scanner keyboardScanner = new Scanner(System.in);

  private static RobotSimulator simulator;

  public static void createNewSimulation() {
    simulator = new RobotSimulator();

    System.out.println("Enter file name for the Board:");
    String boardFile = keyboardScanner.nextLine();
    simulator.readBoardFile(boardFile);

    System.out.println("Enter file name for the Commands:");
    String commandsFile = keyboardScanner.nextLine();
    simulator.readCommandFile(commandsFile);
  }

  public static void main(String[] args) {
    printGreetings();

    boolean quit = false;

    while (!quit) {
      createNewSimulation();

      if (simulator == null) {
        System.out.println("Error creating simulation. Exiting...");
        break;
      }

      boolean simulationEnded = false;

      int status = simulator.startSimulation();

      switch (status) {
        case -1:
          System.out.println("Error: The Board is not initialized");
          simulationEnded = true;
          break;

        case 1:
          System.out.println("Error: The Robot cannot be placed down on an Obstacle");
          simulationEnded = true;
          simulator.printBoard();
          break;

        default:
          simulator.printBoard();
          break;
      }

      while (!simulationEnded) {
        status = simulator.runNextCommand();

        switch (status) {
          case -1:
            System.out.println("Error: Board is not initialized or no Commands received");
            simulationEnded = true;
            break;

          case 1:
            System.out.println("Error: The Robot crashed into an obstacle");
            simulationEnded = true;
            break;

          case 2:
            simulationEnded = true;
            break;

          default:
            simulator.printBoard();
            break;
        }
      }

      System.out.println("Simulation End");
      quit = promptForNewSimulation();
    }

    System.out.println("Goodbye!");

    keyboardScanner.close();
  }

  public static void printGreetings() {
    System.out.println("Welcome to the Robot Simulator");
  }

  /**
   * Prompt the user if they want to run another simulation with another board and commands file. If
   * the user answer yes, return false. If no, return true. Else prompt the user again for a yes or
   * no answer.
   */
  public static boolean promptForNewSimulation() {
    while (true) {
      System.out.println("\nDo you want run another simulation? Yes or No");
      String input = keyboardScanner.nextLine();

      if (input.equalsIgnoreCase("Yes")) {
        return false;
      }

      if (input.equalsIgnoreCase("No")) {
        return true;
      }

      System.out.println("Error: Invalid input.");
    }
  }
}
