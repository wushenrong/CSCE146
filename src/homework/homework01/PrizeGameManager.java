/*
 * Samuel Wu
 * 2024-09-15
 */

package homework.homework01;

import java.io.*;
import java.util.Scanner;

public class PrizeGameManager {
    public static final int DEFAULT_PRIZE_SIZE = 20;
    public static final int NUMBER_OF_GAME_PRIZES = 5;
    public static final double PRICE_TOLERANCE = 1300;

    private Prize[] prizes;
    private Prize[] gamePrizes = new Prize[NUMBER_OF_GAME_PRIZES];

    public PrizeGameManager() {
        init(DEFAULT_PRIZE_SIZE);
    }

    public PrizeGameManager(int prizeSize) {
        init(prizeSize);
    }

    public void init(int prizeSize) {
        if (prizeSize >= 1) {
            prizes = new Prize[prizeSize];
        } else {
            prizes = new Prize[DEFAULT_PRIZE_SIZE];
        }
    }

    public void addPrize(Prize prize) {
        if (prize == null) {
            return;
        }

        for (int i = 0; i < prizes.length; i++) {
            if (prizes[i] == null) {
                prizes[i] = prize;
                break;
            }
        }
    }

    /**
     * Creates a new prize game by randomizing the prizes for the game from the
     * prize list. First the array for game prizes is iterated to fill up the
     * array. Then a prize is selected from the prize list by generating a
     * number between 0 and the size of the prize list minus one for the index
     * of the prize array. Next check if the prize is either null or the prize
     * was selected. If not add it to the array for game prize, else decrement
     * the number of prizes selected. Lastly the loop increments the number of
     * prizes selected.
     */
    public void newGame() {
        for (int i = 0; i < gamePrizes.length; i++) {
            int gamePrize = (int) (Math.random() * prizes.length);

            if (prizes[gamePrize] == null || isGamePrizeSelected(prizes[gamePrize])) {
                i--;
                continue;
            }

            gamePrizes[i] = prizes[gamePrize];
        }
    }

    /**
     * Gets the total price of prizes for the current game by iterating through
     * the array for game, adding the price of the prizes to a sum variable, and
     * lastly returning the sum variable.
     */
    public double getTotalPrizePrice() {
        double totalPrizePrice = 0;

        for (Prize prize : gamePrizes) {
            if (prize != null) {
                totalPrizePrice += prize.getPrice();
            }
        }

        return totalPrizePrice;
    }

    /**
     * Check if a price guess is between the total price of game prizes minus
     * the price tolerance for the game and the total prize of game prizes. If
     * the guess is below the total prize of game prizes minus the price
     * tolerance or above the the total prize of game prizes return false, else
     * return true.
     */
    public boolean checkPriceGuess(double guess) {
        double totalPrizePrice = getTotalPrizePrice();

        if (guess < totalPrizePrice - PRICE_TOLERANCE || guess > totalPrizePrice) {
            return false;
        }

        return true;
    }

    public void printGamePrizes() {
        for (Prize prize : gamePrizes) {
            System.out.println(prize.getName());
        }
    }

    /**
     * Read a file that contain a list of prizes to setup the prize game. First
     * set the delimiter and number of columns that formats the prize list. Next
     * count the number of lines as the number of prizes. Then initialize our
     * prize array to the number of prizes. Next reread the prize file and split
     * the lines using the delimiter and check if the line has the prize name
     * and price for the prize. If the previous check is true, parse the name
     * and price and add the prize to the prize array, else skip to the next
     * line.
     */
    public void readPrizeList(String filename) {
        int numberOfPrizes = 0;

        try (Scanner fileScanner = new Scanner(new File(filename))) {
            while (fileScanner.hasNext()) {
                fileScanner.nextLine();
                numberOfPrizes++;
            }
        } catch (Exception e) {
            e.printStackTrace();
            return;
        }

        init(numberOfPrizes);

        try (Scanner fileScanner = new Scanner(new File(filename))) {
            while (fileScanner.hasNextLine()) {
                String line = fileScanner.nextLine();
                String[] splitLines = line.split(Prize.DELIMITER);

                if (splitLines.length != Prize.NUMBER_OF_FIELDS) {
                    continue;
                }

                String prizeName = splitLines[0];
                Double prizePrice = Double.parseDouble(splitLines[1]);

                addPrize(new Prize(prizeName, prizePrice));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Checking if a prize has been selected for the game by checking each prize
     * in the array of prizes that was selected for the game. If the prizes in
     * the array is not null and one of the selected prizes matched the prize
     * given return true, else return false.
     */
    private boolean isGamePrizeSelected(Prize gamePrize) {
        for (Prize prize : gamePrizes) {
            if (prize != null && prize.equals(gamePrize)) {
                return true;
            }
        }

        return false;
    }
}
