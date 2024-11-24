/*
 * SPDX-FileCopyrightText: 2024 Samuel Wu
 *
 * SPDX-License-Identifier: MIT
 */

package homework.homework06;

import java.io.File;
import java.util.Scanner;

import homework.homework04.GenericLinkedQueue;

public class SheepScheduler {
    public static final Scanner KEYBOARD_SCANNER = new Scanner(System.in);

    private static GenericLinkedQueue<Sheep> sheepToBeSorted;
    private static GenericLinkedQueue<Sheep> sheepSchedule;
    private static Sheep[] sheepToBeScheduled;

    public static void main(String[] args) {
        printGreetings();

        boolean quit = false;

        while (!quit) {
            promptForSheep();
            prepareSchedule();
            createSchedule();
            printSchedule();

            quit = promptForNewSchedule();
        }

        System.out.println("Goodbye");

        KEYBOARD_SCANNER.close();
    }

    public static void printGreetings() {
        System.out.println("Welcome to the Sheep Shearing Scheduler!");
    }

    public static void printSchedule() {
        sheepSchedule.print();
    }

    /**
     * Create a shearing schedule by shearing each sheep via simulation and
     * adding each sheep by their time of arrival and shearing them. If the
     * sheep is done shearing, add the sheep to the schedule.
     */
    public static void createSchedule() {
        sheepSchedule = new GenericLinkedQueue<>();

        SheepShearer sheepShearer = new SheepShearer();
        int currentTime = 0;
        int currentSheep = 0;

        while (true) {
            while (currentSheep < sheepToBeScheduled.length
                    && currentTime == sheepToBeScheduled[currentSheep].getArrivalTime()) {
                sheepShearer.addSheep(sheepToBeScheduled[currentSheep]);
                currentSheep++;
            }

            if (sheepShearer.isDone()) {
                break;
            }

            Sheep shearedSheep = sheepShearer.shearSheep();

            if (shearedSheep != null) {
                sheepSchedule.enqueue(shearedSheep);
            }

            currentTime++;
        }
    }

    /**
     * Prepare the simulation of the schedule by creating an array and
     * populating the array with sheep from the file. Then quick sort the array
     * by arrival time.
     */
    public static void prepareSchedule() {
        int numberOfSheep = sheepToBeSorted.countQueue();
        sheepToBeScheduled = new Sheep[numberOfSheep];

        for (int i = 0; i < numberOfSheep; i++) {
            sheepToBeScheduled[i] = sheepToBeSorted.dequeue();
        }

        quickSortSheepByArrivalTime(0, sheepToBeScheduled.length - 1);
    }

    private static void quickSortSheepByArrivalTime(int start, int end) {
        if (start >= end) {
            return;
        }

        int pivot = partition(start, end);
        quickSortSheepByArrivalTime(start, pivot - 1);
        quickSortSheepByArrivalTime(pivot + 1, end);
    }

    private static int partition(int start, int end) {
        int pivot = sheepToBeScheduled[end].getArrivalTime();
        int i = start;

        for (int j = start; j <= end; j++) {
            if (sheepToBeScheduled[j].getArrivalTime() < pivot) {
                Sheep temp = sheepToBeScheduled[i];
                sheepToBeScheduled[i] = sheepToBeScheduled[j];
                sheepToBeScheduled[j] = temp;
                i++;
            }
        }

        Sheep temp = sheepToBeScheduled[i];
        sheepToBeScheduled[i] = sheepToBeScheduled[end];
        sheepToBeScheduled[end] = temp;
        return i;
    }

    public static void promptForSheep() {
        System.out.println("Please enter the filename for the sheep file: ");
        String filename = KEYBOARD_SCANNER.nextLine();
        readSheepFile("./" + filename);
    }

    /**
     * Prompt the user if they want to create another schedule. If yes, return
     * false for not quitting the scheduler. If no, return true to quit. Else
     * prompt for a valid input.
     */
    public static boolean promptForNewSchedule() {
        while (true) {
            System.out.println("\nDo you want to create a new shearing schedule? Yes or No");
            String input = KEYBOARD_SCANNER.nextLine();

            if (input.equalsIgnoreCase("Yes")) {
                return false;
            }

            if (input.equalsIgnoreCase("No")) {
                return true;
            }

            System.out.println("Error: Invalid input.");
        }
    }

    /**
     * Get sheep from a sheep list by creating a new GenericLinkedQueue to store
     * the sheep for sorting. Then read each line of the file for the sheep.
     * Next split the line to get the name, shearing time, and arrival time of
     * the sheep. If there are 3 fields in the line, create a new sheep. Else
     * process the next line.
     */
    public static void readSheepFile(String filename) {
        sheepToBeSorted = new GenericLinkedQueue<>();

        try (Scanner fileScanner = new Scanner(new File(filename))) {
            while (fileScanner.hasNextLine()) {
                String line = fileScanner.nextLine();
                String[] fields = line.split(Sheep.DELIMITER);

                if (fields.length != Sheep.NUMBER_OF_FIELDS) {
                    continue;
                }

                String sheepName = fields[0];
                int sheepShearTime = Integer.parseInt(fields[1]);
                int sheepArrivalTime = Integer.parseInt(fields[2]);

                sheepToBeSorted.enqueue(new Sheep(sheepName, sheepShearTime, sheepArrivalTime));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
