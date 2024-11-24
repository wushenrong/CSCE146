/*
 * SPDX-FileCopyrightText: 2024 Samuel Wu
 *
 * SPDX-License-Identifier: MIT
 */

package homework.homework01;

import java.util.Scanner;

public class PrizeGameFrontEnd {
    public static final Scanner KEYBOARD_SCANNER = new Scanner(System.in);
    public static final PrizeGameManager GAME_MANAGER = new PrizeGameManager();

    public static void main(String[] args) {
        printGreetings();
        getPrizeListFile();

        boolean quit = false;

        while (!quit) {
            printChoices();

            int choice = KEYBOARD_SCANNER.nextInt();
            KEYBOARD_SCANNER.nextLine();

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

        KEYBOARD_SCANNER.close();
    }

    public static void printGreetings() {
        System.out.println("Welcome to the showcase showdown!");
    }

    public static void printChoices() {
        System.out.println("What would like to do:");
        System.out.println("Enter 1 for a new game.");
        System.out.println("Enter 2 to exit.");
    }

    public static void newGame() {
        GAME_MANAGER.newGame();

        double totalPrizePrice = GAME_MANAGER.getTotalPrizePrice();

        System.out.println("Your goal for this game is to guess the total price of "
                + PrizeGameManager.NUMBER_OF_GAME_PRIZES + " prizes without going over and within "
                + PrizeGameManager.PRICE_TOLERANCE + " of its actual price.");
        System.out.println("Here are your " + PrizeGameManager.NUMBER_OF_GAME_PRIZES + " prizes:");

        GAME_MANAGER.printGamePrizes();

        System.out.println(
                "Enter your guess for the price of the " + PrizeGameManager.NUMBER_OF_GAME_PRIZES + " prizes:");

        double guess = KEYBOARD_SCANNER.nextDouble();
        KEYBOARD_SCANNER.nextLine();

        if (GAME_MANAGER.checkPriceGuess(guess)) {
            System.out.println("Congratulations, you win!!!");
        } else {
            System.out.println("Sorry you lose.");
        }

        System.out.println("The actual price of the 5 prizes is " + totalPrizePrice);
    }

    public static void getPrizeListFile() {
        System.out.println("Please enter the filename of the prize list for this game:");
        String prizeListFile = KEYBOARD_SCANNER.nextLine();

        GAME_MANAGER.readPrizeList("./" + prizeListFile);
    }
}
