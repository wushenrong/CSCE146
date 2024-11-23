/*
 * Samuel Wu
 * 2024-11-02
 */

package homework.homework04;

import java.io.File;
import java.util.Scanner;

public class RobotSimulator {
    public static final int BOARD_SIZE = 10;
    public static final int START_POSITION = 0;

    public static final char EMPTY = '_';
    public static final char ROBOT = 'O';
    public static final char OBSTACLE = 'X';

    public static final String UP = "Move Up";
    public static final String DOWN = "Move Down";
    public static final String LEFT = "Move Left";
    public static final String RIGHT = "Move Right";

    private char[][] board;
    private GenericLinkedQueue<String> commandsToRun;

    private int commandCounter = 0;
    private int robotXPosition = START_POSITION;
    private int robotYPosition = START_POSITION;

    public RobotSimulator() {
        board = null;
        commandsToRun = null;
    }

    /**
     * Starts the robot simulation by placing the robot down. Returns -1 if the
     * board is not initialized. Returns 1 if the robot is placed on an obstacle
     * at (0, 0). Else return 0 for successfully placing the robot.
     */
    public int startSimulation() {
        commandCounter = 0;

        if (board == null) {
            return -1;
        }

        if (isPositionObstacle(robotXPosition, robotYPosition)) {
            return 1;
        }

        robotXPosition = START_POSITION;
        robotYPosition = START_POSITION;
        board[robotYPosition][robotXPosition] = ROBOT;

        return 0;
    }

    /**
     * Runs the next command in the list of commands. If the queue for commands
     * to run is empty, return -1. If there are no commands to run next, return
     * 2. Next store the robot's previous position into temporary variables.
     * Next check if the command is valid, then move up, down, left, or right.
     * Else if the command is invalid do nothing. Then check if the robot is
     * outside of the board or hits an obstacle, return false. Else update the
     * board to move the robot and return 0.
     */
    public int runNextCommand() {
        if (commandsToRun == null) {
            return -1;
        }

        String command = commandsToRun.dequeue();
        commandCounter++;

        if (command == null) {
            return 2;
        }

        System.out.println("Command " + commandCounter + ": " + command);

        int previousXPosition = robotXPosition;
        int previousYPosition = robotYPosition;

        switch (command) {
        case UP:
            robotYPosition -= 1;
            break;

        case DOWN:
            robotYPosition += 1;
            break;

        case LEFT:
            robotXPosition -= 1;
            break;

        case RIGHT:
            robotXPosition += 1;
            break;

        default:
            break;
        }

        if (!isPositionValid(robotXPosition) || !isPositionValid(robotYPosition)
                || isPositionObstacle(robotXPosition, robotYPosition)) {
            return 1;
        }

        board[robotYPosition][robotXPosition] = ROBOT;
        board[previousYPosition][previousXPosition] = EMPTY;

        return 0;
    }

    private boolean isPositionValid(int position) {
        return position >= 0 && position < board.length;
    }

    /**
     * Check if a position is an obstacle or not. The xPosition is the column of
     * the board and the xPosition is the row of the board. Returns true if the
     * space is a 'X', else return false.
     */
    private boolean isPositionObstacle(int xPosition, int yPosition) {
        return board[yPosition][xPosition] == OBSTACLE;
    }

    public void printBoard() {
        for (int row = 0; row < board.length; row++) {
            for (int column = 0; column < board[row].length; column++) {
                System.out.print(board[row][column]);
            }

            System.out.println();
        }

        System.out.println();
    }

    /**
     * Read and fill the board by reading each line as the row of the board and
     * each character as the column of the board. The board is a 2D array where
     * both the row and column are the same size. Each space of the board is
     * placed in the same position of the array.
     */
    public void readBoardFile(String filename) {
        board = new char[BOARD_SIZE][BOARD_SIZE];

        try (Scanner fileScanner = new Scanner(new File(filename))) {
            int row = 0;

            while (fileScanner.hasNextLine()) {
                String line = fileScanner.nextLine();

                for (int column = 0; column < line.length(); column++) {
                    board[row][column] = line.charAt(column);
                }

                row++;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void readCommandFile(String filename) {
        commandsToRun = new GenericLinkedQueue<>();

        try (Scanner fileScanner = new Scanner(new File(filename))) {
            while (fileScanner.hasNextLine()) {
                commandsToRun.enqueue(fileScanner.nextLine());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
