/*
 * SPDX-FileCopyrightText: 2024 Samuel Wu
 *
 * SPDX-License-Identifier: MIT
 */

package labs.lab06;

import java.util.Scanner;

public class SortSorter {
  public static final String SORT_STRING = "sort";
  public static final Scanner KEYBOARD_SCANNER = new Scanner(System.in);
  private static StringLinkedQueue stringsQueue = new StringLinkedQueue();

  /**
   * Sort strings by "sort" by asking the user strings with "sort" and enqueue the strings for
   * sorting. Then count the number of stings in the queue and create a string array. Next dequeue
   * the strings into the array and sort the stings. Lastly print out the sorted strings and prompt
   * the user if they want to sort more strings.
   */
  public static void main(String[] args) {
    System.out.println("Welcome to the Sort Sorter!");

    boolean quit = false;
    while (!quit) {
      System.out.println("Enter any number of strings and I will sort by 'sort'");
      System.out.println("Just hit enter when you are done entering strings\n");

      while (true) {
        String input = KEYBOARD_SCANNER.nextLine();

        if (input.equals("")) {
          break;
        }

        stringsQueue.enqueue(input);
      }

      int numberOfStrings = stringsQueue.countStrings();
      String[] sortedSortStrings = new String[numberOfStrings];

      for (int i = 0; i < numberOfStrings; i++) {
        sortedSortStrings[i] = stringsQueue.dequeue();
      }

      sortSortStrings(sortedSortStrings);

      for (String string : sortedSortStrings) {
        System.out.println(string);
      }

      quit = promptToSortNewStrings();
    }

    KEYBOARD_SCANNER.close();
  }

  /**
   * Method to quick sort an entire string array.
   */
  public static void sortSortStrings(String[] array) {
    quickSortStrings(array, 0, array.length - 1);
  }

  /**
   * Method to recursively quick sort each upper and lower partition of a string by number of
   * "sort".
   */
  public static void quickSortStrings(String[] array, int start, int end) {
    if (start >= end) {
      return;
    }

    int pivot = partition(array, start, end);
    quickSortStrings(array, start, pivot - 1);
    quickSortStrings(array, pivot + 1, end);
  }

  /**
   * Sort strings by using quick sort which has an average time complexity of O(n log n). First
   * select the last string as the initial pivot and get the number of "sort" for all the other
   * strings to compare against. Then sort the strings normally using quick sort and return the new
   * index of the pivot to call quick sort again.
   */
  public static int partition(String[] array, int start, int end) {
    int pivot = countSorts(array[end].toLowerCase());
    int i = start;

    for (int j = start; j <= end; j++) {
      if (countSorts(array[j].toLowerCase()) < pivot) {
        String temp = array[i];
        array[i] = array[j];
        array[j] = temp;
        i++;
      }
    }

    String temp = array[i];
    array[i] = array[end];
    array[end] = temp;
    return i;
  }

  /**
   * Count the number of instance of "sort" in a string by getting the index of the first character
   * of "sort" in the string using String.indexOf. If String.indexOf returns -1, meaning there is no
   * "sort" in the string, return 0 for there are no "sort" in the string. Else recursively call
   * itself with the front of the string including "sort" removed to count additional "sort" and
   * return the result of the recursive call plus one.
   */
  public static int countSorts(String string) {
    int indexOfSort = string.indexOf(SORT_STRING);

    if (indexOfSort == -1) {
      return 0;
    }

    return countSorts(string.substring(indexOfSort + SORT_STRING.length())) + 1;
  }

  public static boolean promptToSortNewStrings() {
    while (true) {
      System.out.println("\nDo you want run sort more strings? Yes or No");
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
}
