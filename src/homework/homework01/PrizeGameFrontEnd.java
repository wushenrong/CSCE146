/*
 * Samuel Wu
 * 2024-09-15
 */

package homework.homework01;

import java.util.Scanner;

public class PrizeGameFrontEnd {
    public static Scanner keyboardScanner = new Scanner(System.in);
    public static PrizeGameManager prizeGameManager = new PrizeGameManager();

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

            case 9:
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

    public static void printGreetings() {
        System.out.println("Welcome to the showcase showdown!");
    }

    public static void printChoices() {
        System.out.println("What would like to do:");
        System.out.println("Enter 1 for a new game.");
        System.out.println("Enter 9 to exit.");
    }

    public static void newGame() {
        prizeGameManager.newGame();

        double totalPrizePrice = prizeGameManager.getTotalPrizePrice();

        System.out.println("Your goal for this game is to guess the total price of "
                + PrizeGameManager.NUMBER_OF_GAME_PRIZES + " prizes without going over and within "
                + PrizeGameManager.PRICE_TOLERANCE + " of its actual price.");
        System.out.println("Here are your " + PrizeGameManager.NUMBER_OF_GAME_PRIZES + " prizes:");

        prizeGameManager.printGamePrizes();

        System.out.println(
                "Enter your guess for the price of the " + PrizeGameManager.NUMBER_OF_GAME_PRIZES + " prizes:");

        double guess = keyboardScanner.nextDouble();
        keyboardScanner.nextLine();

        if (prizeGameManager.checkPriceGuess(guess)) {
            System.out.println("Congratulations, you win!!!");
        } else {
            System.out.println("Sorry you lose.");
        }

        System.out.println("The actual price of the 5 prizes is " + totalPrizePrice);
    }

    public static void getPrizeListFile() {
        System.out.println("Please enter the filename of the prize list for this game:");

        String prizeListFile = keyboardScanner.nextLine();
        prizeGameManager.readPrizeList("./" + prizeListFile);
    }
}
