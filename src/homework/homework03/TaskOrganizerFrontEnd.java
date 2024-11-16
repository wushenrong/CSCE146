/*
 * Samuel Wu
 * 2024-10-25
 */

package homework.homework03;

import java.util.Scanner;

public class TaskOrganizerFrontEnd {
    public static final TaskOrganizer TASK_ORGANIZER = new TaskOrganizer();
    public static final Scanner KEYBOARD_SCANNER = new Scanner(System.in);

    public static void main(String[] args) {
        printGreetings();

        boolean quit = false;

        while (!quit) {
            printOptions();

            String option = KEYBOARD_SCANNER.nextLine().toLowerCase();

            switch (option) {
            case "add":
                addTask();
                break;

            case "remove":
                removeTask();
                break;

            case "print":
                TASK_ORGANIZER.printTasks();
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

        KEYBOARD_SCANNER.close();
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
        TASK_ORGANIZER.addTask(taskToAdd);
    }

    public static void removeTask() {
        Task taskToRemove = promptTask();
        TASK_ORGANIZER.removeTask(taskToRemove);
    }

    public static void readTaskFile() {
        String filename = promptFileName("Enter the filename of the task file to read from:");
        TASK_ORGANIZER.readTaskFile("./" + filename);
    }

    public static void writeTaskFile() {
        String filename = promptFileName("Enter the filename of the task file to write to:");
        TASK_ORGANIZER.writeTaskFile("./" + filename);
    }

    /**
     * Prompt the user for the task's priority and action for adding or removing
     * a task. Then it constructs and returns a new Task.
     */
    public static Task promptTask() {
        System.out.println("Please enter the task's priority:");
        int taskPriority = KEYBOARD_SCANNER.nextInt();
        KEYBOARD_SCANNER.nextLine();

        System.out.println("Please enter the task's action:");
        String taskAction = KEYBOARD_SCANNER.nextLine();

        return new Task(taskPriority, taskAction);
    }

    /**
     * Prompt the user to input a filename for reading and writing a task file.
     * Requires a prompt to ask what the file is used for.
     */
    public static String promptFileName(String prompt) {
        System.out.println(prompt);
        return KEYBOARD_SCANNER.nextLine();
    }
}
