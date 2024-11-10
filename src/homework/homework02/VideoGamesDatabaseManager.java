/*
 * Samuel Wu
 * 2024-09-25
 */

package homework.homework02;

import java.util.Scanner;

public class VideoGamesDatabaseManager {
    public static Scanner keyboardScanner = new Scanner(System.in);
    public static VideoGamesDatabase database = new VideoGamesDatabase();

    public static void main(String[] args) {
        printGreetings();

        boolean quit = false;

        while (!quit) {
            printChoices();

            String choice = keyboardScanner.nextLine().toLowerCase();

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

        keyboardScanner.close();

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
        String gameQuery = keyboardScanner.nextLine();

        System.out.println("Enter the name of the console or '*' for all consoles:");
        String consoleQuery = keyboardScanner.nextLine();

        if (!database.searchVideoGames(gameQuery, consoleQuery)) {
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

        if (!database.printVideoGamesSearchResults()) {
            System.out.println("Error: No search result, please search for a game.");
            return;
        }

        System.out.println();

        System.out.println("Do you want to save the results to a file? Yes or No?");
        String option = keyboardScanner.nextLine().toLowerCase();

        while (true) {
            if (option.equals("no"))
                break;

            if (option.equals("yes")) {
                writeVideoGamesSearchResults();
                break;
            }

            System.out.println("Error: Invalid option, please type 'Yes' or 'No'.");
            option = keyboardScanner.nextLine().toLowerCase();
        }
    }

    public static void readVideoGamesCollectionFile() {
        System.out.println("Enter the file name of the video games database:");
        String filename = keyboardScanner.nextLine();
        database.readVideoGameCollectionFile("./" + filename);
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
        String filename = keyboardScanner.nextLine();

        System.out.println("Would you like to append to the file? Yes or No");
        String option = keyboardScanner.nextLine().toLowerCase();

        boolean append;

        while (true) {
            if (option.equals("no")) {
                append = false;
                break;
            }

            if (option.equals("yes")) {
                append = true;
                break;
            }

            System.out.println("Error: Invalid option, please type 'Yes' or 'No'.");
            option = keyboardScanner.nextLine().toLowerCase();
        }

        if (!database.writeVideoGamesSearchResults("./" + filename, append)) {
            System.out.println("Error: Failed to write search results to file.");
            System.out.println("Have you search for a game yet?");
            return;
        }

        System.out.println("Results written to " + filename);
    }
}
