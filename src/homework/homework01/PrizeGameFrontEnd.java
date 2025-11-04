/*
 * SPDX-FileCopyrightText: 2024 Samuel Wu
 *
 * SPDX-License-Identifier: MIT
 */

package homework.homework01;

import java.util.Scanner;

/// The main class interface to play the Prize Game.
public class PrizeGameFrontEnd {
  public static final Scanner keyboardScanner = new Scanner(System.in);
  public static final PrizeGameManager gameManager = new PrizeGameManager();

  public static void getPrizeListFile() {
    System.out.println("Please enter the filename of the prize list for this game:");
    String prizeListFile = keyboardScanner.nextLine();

    gameManager.readPrizeList("./" + prizeListFile);
  }

  /// Main function to play the prize game.
  ///
  /// @param args Arguments from the commandline.
  public static void main(String[] args) {
    printGreetings();
    getPrizeListFile();

    boolean quit = false;

    while (!quit) {
      printChoices();

      int choice = keyboardScanner.nextInt();
      keyboardScanner.nextLine();

      switch (choice) {
        case 1:
          newGame();
          break;

        case 2:
          quit = true;
          break;

        default:
          System.out.println("Sorry that is not a valid choice.");
          break;
      }
    }

    System.out.println("Goodbye!");

    keyboardScanner.close();
  }

  public static void newGame() {
    gameManager.newGame();

    System.out.println("Your goal for this game is to guess the total price of "
        + PrizeGameManager.NUMBER_OF_GAME_PRIZES + " prizes without going over and within "
        + PrizeGameManager.PRICE_TOLERANCE + " of its actual price.");
    System.out.println("Here are your " + PrizeGameManager.NUMBER_OF_GAME_PRIZES + " prizes:");

    gameManager.printGamePrizes();

    System.out.println("Enter your guess for the price of the "
        + PrizeGameManager.NUMBER_OF_GAME_PRIZES + " prizes:");

    double guess = keyboardScanner.nextDouble();
    keyboardScanner.nextLine();

    if (gameManager.checkPriceGuess(guess)) {
      System.out.println("Congratulations, you win!!!");
    } else {
      System.out.println("Sorry you lose.");
    }

    double totalPrizePrice = gameManager.getTotalPrizePrice();
    System.out.println("The actual price of the 5 prizes is " + totalPrizePrice);
  }

  public static void printChoices() {
    System.out.println("What would like to do:");
    System.out.println("Enter 1 for a new game.");
    System.out.println("Enter 2 to exit.");
  }

  public static void printGreetings() {
    System.out.println("Welcome to the showcase showdown!");
  }
}
