/*
 * SPDX-FileCopyrightText: 2024 Samuel Wu
 *
 * SPDX-License-Identifier: MIT
 *
 * Project: Lab 00
 */

package labs;

import java.util.Scanner;

/// A class with a main function to demonstrate the bubble sort algorithm.
public class BubbleSorter {
  /// The max size of an array for sort.
  public static final int ARRAY_SIZE = 10;

  /// A main function that ask the user to input {@value #ARRAY_SIZE} integer values and sorts them
  /// using bubble sort.
  ///
  /// @param args Arguments passed in by the commandline.
  public static void main(String[] args) {
    Scanner keyboardScanner = new Scanner(System.in);

    System.out.println("Enter " + ARRAY_SIZE + " numbers and I will sort them:");

    int[] numbers = new int[ARRAY_SIZE];

    for (int i = 0; i < numbers.length; i++) {
      System.out.println("Enter value " + (i + 1) + ": ");
      numbers[i] = keyboardScanner.nextInt();
      keyboardScanner.nextLine();
      System.out.println();
    }

    // Bubble sort numbers
    boolean hasSwapped;

    do {
      hasSwapped = false;

      for (int i = 0; i < numbers.length - 1; i++) {
        if (numbers[i] > numbers[i + 1]) {
          // Swap numbers
          int temp = numbers[i];
          numbers[i] = numbers[i + 1];
          numbers[i + 1] = temp;
          hasSwapped = true;
        }
      }
    } while (hasSwapped);

    for (int number : numbers) {
      System.err.println(number);
    }

    keyboardScanner.close();
  }
}
