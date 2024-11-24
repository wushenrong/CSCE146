/*
 * SPDX-FileCopyrightText: 2024 Samuel Wu
 *
 * SPDX-License-Identifier: MIT
 */

package homework.homework02;

import java.util.Scanner;

public class VideoGamesDatabaseManager {
    public static final Scanner KEYBOARD_SCANNER = new Scanner(System.in);
    public static final VideoGamesDatabase DATABASE = new VideoGamesDatabase();

    public static void main(String[] args) {
        printGreetings();

        boolean quit = false;

        while (!quit) {
            printChoices();

            String choice = KEYBOARD_SCANNER.nextLine().toLowerCase();

            switch (choice) {
            case "quit":
                quit = true;
                break;

            case "load":
                readVideoGamesCollectionFile();
                break;

            case "search":
                searchVideoGamesDatabase();
                break;

            case "print":
                printVideoGamesResult();
                break;

            default:
                System.out.println("Sorry that is not a valid option, please try again:");
                break;
            }
        }

        KEYBOARD_SCANNER.close();

        System.out.println("Goodbye!");
    }

    public static void printGreetings() {
        System.out.println("Welcome to the Video Games Database Manager!");
    }

    public static void printChoices() {
        System.out.println();
        System.out.println("Enter 'load' to load a video games database.");
        System.out.println("Enter 'search' to search the database.");
        System.out.println("Enter 'print' to print current results.");
        System.out.println("Enter 'quit' to quit the database.");
    }

    /**
     * Prompt the user the name of the game and console for searching games, or
     * enter '*' to search all games or console. Then perform the search and
     * checking if the search was successful. If the search was not successful,
     * then prompt the user and return to the main menu to load a video games
     * collection file. Else print the search results.
     */
    public static void searchVideoGamesDatabase() {
        System.out.println();
        System.out.println("Enter the name of the game or '*' for all games:");
        String gameQuery = KEYBOARD_SCANNER.nextLine();

        System.out.println("Enter the name of the console or '*' for all consoles:");
        String consoleQuery = KEYBOARD_SCANNER.nextLine();

        if (!DATABASE.searchVideoGames(gameQuery, consoleQuery)) {
            System.out.println("Error: Something has gone wrong with the search function.");
            System.out.println("Have you load a video game database yet?");
            return;
        }

        printVideoGamesResult();
    }

    /**
     * Print out the search result, if result was not printed, prompt the user
     * to search for a game and return to main menu. Else the results were
     * printed and ask the user if they wants to save the results to a file.
     * Inputs are verified by using a while true loops and if the user say no,
     * return to main menu, if the user says yes, call
     * writeVideoGamesSearchResult before returning to the main menu. Else
     * prompt the user for a valid input.
     */
    public static void printVideoGamesResult() {
        System.out.println();

        if (!DATABASE.printVideoGamesSearchResults()) {
            System.out.println("Error: No search result, please search for a game.");
            return;
        }

        System.out.println();

        System.out.println("Do you want to save the results to a file? Yes or No?");
        String option = KEYBOARD_SCANNER.nextLine().toLowerCase();

        while (true) {
            if (option.equals("no")) {
                return;
            }

            if (option.equals("yes")) {
                writeVideoGamesSearchResults();
                return;
            }

            System.out.println("Error: Invalid option, please type 'Yes' or 'No'.");
            option = KEYBOARD_SCANNER.nextLine().toLowerCase();
        }
    }

    public static void readVideoGamesCollectionFile() {
        System.out.println("Enter the file name of the video games database:");
        String filename = KEYBOARD_SCANNER.nextLine();
        DATABASE.readVideoGameCollectionFile("./" + filename);
    }

    /**
     * Write search results to a file. Prompt the user for the filename and ask
     * if they want to append or overwrite the file using the same input
     * validation check as the printVideoGamesResult. Then write the results to
     * the file. If the operation was successful, print out that the operation
     * was successful, else ask the user to search for a game.
     */
    public static void writeVideoGamesSearchResults() {
        System.out.println("Enter the name of the file to write results to:");
        String filename = KEYBOARD_SCANNER.nextLine();

        boolean append = promptToAppendFile();

        if (!DATABASE.writeVideoGamesSearchResults("./" + filename, append)) {
            System.out.println("Error: Failed to write search results to file.");
            System.out.println("Have you search for a game yet?");
            return;
        }

        System.out.println("Results written to " + filename);
    }

    private static boolean promptToAppendFile() {
        System.out.println("Would you like to append to the file? Yes or No");
        String option = KEYBOARD_SCANNER.nextLine().toLowerCase();

        while (true) {
            if (option.equals("no")) {
                return false;
            }

            if (option.equals("yes")) {
                return true;
            }

            System.out.println("Error: Invalid option, please type 'Yes' or 'No'.");
            option = KEYBOARD_SCANNER.nextLine().toLowerCase();
        }
    }
}
