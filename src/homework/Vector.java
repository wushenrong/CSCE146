/*
 * SPDX-FileCopyrightText: 2024 Samuel Wu
 *
 * SPDX-License-Identifier: MIT
 *
 * Project: Homework 00
 */

package homework;

import java.util.Scanner;

/// A Vector utility class to calculate vector operations.
public class Vector {
  public static final Scanner KEYBOARD_SCANNER = new Scanner(System.in);

  /// A main method to demonstrate the vector operations functions.
  public static void main(String[] args) throws Exception {
    System.out.println("Vector Operations Program");

    String input = "";

    // Continually prints out the user interface and performs the correct
    // operation based on user selection until the user enters 'Q' which
    // break out of the loop.
    while (true) {
      System.out.println("Please make a selection:");
      System.out.println("Enter A to add 2 vectors");
      System.out.println("Enter S to subtract 2 vectors");
      System.out.println("Enter M to find the magnitude of a vector");
      System.out.println("Enter Q to quit");

      input = KEYBOARD_SCANNER.nextLine();

      if (input.equalsIgnoreCase("A")) {
        System.out.println("Enter the size of the vectors:");
        int vectorSize = getVectorSize();

        System.out.println("Enter values for the first vector:");
        double[] vector1 = createVector(vectorSize);
        System.out.println("Enter values for the second vector:");
        double[] vector2 = createVector(vectorSize);

        double[] output = addVectors(vector1, vector2);

        System.out.println(vectorToString(vector1));
        System.out.println("+");
        System.out.println(vectorToString(vector2));
        System.out.println("=");
        System.out.println(vectorToString(output));
      } else if (input.equalsIgnoreCase("S")) {
        System.out.println("Enter the size of the vectors:");
        int vectorSize = getVectorSize();

        System.out.println("Enter values for the first vector:");
        double[] vector1 = createVector(vectorSize);
        System.out.println("Enter values for the second vector:");
        double[] vector2 = createVector(vectorSize);

        double[] output = subtractVectors(vector1, vector2);

        System.out.println(vectorToString(vector1));
        System.out.println("-");
        System.out.println(vectorToString(vector2));
        System.out.println("=");
        System.out.println(vectorToString(output));
      } else if (input.equalsIgnoreCase("M")) {
        System.out.println("Enter the size of the vector:");
        int vectorSize = getVectorSize();

        System.out.println("Enter values for the vector:");
        double[] vector = createVector(vectorSize);

        double output = findVectorMagnitude(vector);

        System.out.println("The magnitude is: " + output);
      } else if (input.equalsIgnoreCase("Q")) {
        System.out.println("Goodbye");
        break;
      } else {
        System.out.println("Error: Invalid selection. Please try again");
      }

      System.out.println();
    }

    KEYBOARD_SCANNER.close();
  }

  /// Get the size of the vector from the user. If the size is invalid, then ask the user to input a
  /// valid size.
  ///
  /// @return The size of the user requested vector.
  public static int getVectorSize() {
    int vectorSize = KEYBOARD_SCANNER.nextInt();
    KEYBOARD_SCANNER.nextLine();

    while (vectorSize <= 0) {
      System.out.println("Error: Invalid size. Please try again");
      vectorSize = KEYBOARD_SCANNER.nextInt();
      KEYBOARD_SCANNER.nextLine();
    }

    return vectorSize;
  }

  /// Create a vector using an array and get vector values from the user.
  ///
  /// @param vectorSize The size of the vector, usually user requested.
  /// @return A vector with user requested values.
  public static double[] createVector(int vectorSize) {
    double[] vector = new double[vectorSize];

    for (int i = 0; i < vector.length; i++) {
      vector[i] = KEYBOARD_SCANNER.nextDouble();
      KEYBOARD_SCANNER.nextLine();
    }

    return vector;
  }

  /// Adds the vectors by each of its component and returns a new vector for the result.
  ///
  /// @param vector1 First vector to add.
  /// @param vector2 Second vector to add.
  /// @return A vector with the sum of the two vectors.
  public static double[] addVectors(double[] vector1, double[] vector2) {
    double[] output = new double[vector1.length];

    for (int i = 0; i < output.length; i++) {
      output[i] = vector1[i] + vector2[i];
    }

    return output;
  }

  /// Subtracts the vectors by each of its component and returns a new vector for the result.
  ///
  /// @param vector1 The vector to subtract from.
  /// @param vector2 The vector to subtract.
  /// @return A vector with the difference of the two vectors.
  public static double[] subtractVectors(double[] vector1, double[] vector2) {
    double[] outputVector = new double[vector1.length];

    for (int i = 0; i < outputVector.length; i++) {
      outputVector[i] = vector1[i] - vector2[i];
    }

    return outputVector;
  }

  /// Finding the magnitude of a vector by adding the squares of each component and then square
  /// rooting the result using [Math].
  ///
  /// @param vector The vector which we get the magnitude of.
  /// @return The magnitude of the vector.
  public static double findVectorMagnitude(double[] vector) {
    double magnitude = 0.0;

    for (double component : vector) {
      magnitude += component * component;
    }

    return Math.sqrt(magnitude);
  }

  /// {@return a clean string representation with angle brackets. Example: "<1.0, 2.0, 3.0>"}
  ///
  /// @param vector The vector to turn into a string representation.
  public static String vectorToString(double[] vector) {
    StringBuffer output = new StringBuffer("<");

    for (int i = 0; i < vector.length; i++) {
      output.append(vector[i]);

      if (i < vector.length - 1) {
        output.append(", ");
      }
    }

    return output.append(">").toString();
  }
}
