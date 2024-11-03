/*
 * Samuel Wu
 * 2024-10-25
 */

package homework.homework03;

import java.util.Scanner;

public class TaskOrganizerFrontEnd {
    public static TaskOrganizer taskOrganizer = new TaskOrganizer();
    public static Scanner keyboardScanner = new Scanner(System.in);

    public static void main(String[] args) {
        printGreetings();

        boolean quit = false;

        while (!quit) {
            printOptions();

            String option = keyboardScanner.nextLine().toLowerCase();

            switch (option) {
            case "add":
                addTask();
                break;

            case "remove":
                removeTask();
                break;

            case "print":
                taskOrganizer.printTasks();
                break;

            case "read":
                readTaskFile();
                break;

            case "write":
                writeTaskFile();
                break;

            case "quit":
                quit = true;
                break;

            default:
                System.out.println("Sorry that is not a valid option, please try again:");
                break;
            }
        }

        System.out.println("Goodbye!");

        keyboardScanner.close();
    }

    public static void printGreetings() {
        System.out.println("Welcome to the task organizer!");
    }

    public static void printOptions() {
        System.out.println();
        System.out.println("Enter 'add' to add a new Task");
        System.out.println("Enter 'remove' to remove a Task");
        System.out.println("Enter 'print' to print Tasks");
        System.out.println("Enter 'read' to read a Task file");
        System.out.println("Enter 'write' to write to a Task file");
        System.out.println("Enter 'quit' to exit the task organizer");
    }

    public static void addTask() {
        Task taskToAdd = promptTask();
        taskOrganizer.addTask(taskToAdd);
    }

    public static void removeTask() {
        Task taskToRemove = promptTask();
        taskOrganizer.removeTask(taskToRemove);
    }

    public static void readTaskFile() {
        String filename = promptFileName("Enter the filename of the task file to read from:");
        taskOrganizer.readTaskFile("./" + filename);
    }

    public static void writeTaskFile() {
        String filename = promptFileName("Enter the filename of the task file to write to:");
        taskOrganizer.writeTaskFile("./" + filename);
    }

    /**
     * Prompt the user for the task's priority and action for adding or removing
     * a task. Then it constructs and returns a new Task.
     */
    public static Task promptTask() {
        System.out.println("Please enter the task's priority:");
        int taskPriority = keyboardScanner.nextInt();
        keyboardScanner.nextLine();

        System.out.println("Please enter the task's action:");
        String taskAction = keyboardScanner.nextLine();

        return new Task(taskPriority, taskAction);
    }

    /**
     * Prompt the user to input a filename for reading and writing a task file.
     * Requires a prompt to ask what the file is used for.
     */
    public static String promptFileName(String prompt) {
        System.out.println(prompt);
        String filename = keyboardScanner.nextLine();
        return filename;
    }
}
