/*
 * SPDX-FileCopyrightText: 2024 Samuel Wu
 *
 * SPDX-License-Identifier: MIT
 *
 * Project: Lab 02
 */

package labs;

import java.io.File;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.util.Scanner;

/// A utility class to demonstrate file operations
public class FileIoSolutions {

  /// Change all instances of "is" to "was" from a text file regardless of case and prints and
  /// writes the words line by line in a new text file.
  ///
  /// @param inputFilename The file to be read.
  /// @param outputFilename The file for the changes to be written to.
  public static void pastTense(String inputFilename, String outputFilename) {
    // Checks and read the next word in a text file. Next check if the word
    // is "is" or "Is" using a separate check to preserve case. Then change
    // "is" and "Is" to "was" and "Was" respectively if the previous check
    // succeeds. Lastly print and write the word on a new line.
    try (Scanner fileScanner = new Scanner(new File(inputFilename));
        PrintWriter fileWriter = new PrintWriter(new FileOutputStream(new File(outputFilename)))) {
      while (fileScanner.hasNext()) {
        String word = fileScanner.next();

        if (word.equals("is")) {
          word = "was";
        } else if (word.equals("Is")) {
          word = "Was";
        }

        System.out.println(word);
        fileWriter.println(word);
      }
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  /// Finds the total volume of tubes from a file formatted as
  /// "\[Identifier\]\t\[Radius\]\t\[Height\]".
  ///
  /// @param filename A file that contains the radius and height of each tube.
  /// @return The sum of every volumes of each tube in a file.
  public static double totalTubeVolume(String filename) {
    // Sets the delimiter and number of columns that formats our tubes file.
    // We expect that the file is using tabs to separate the data and there
    // are three columns for the identifier, radius and height.
    final String delimiter = "\t";
    final int numberOfColumns = 3;

    double totalVolume = 0.0;

    // Check and read the next line in the file. Then split the line using
    // the delimiter that we defined to separate the identifier, radius and
    // height. Then check if we have splitted three columns of data, if not
    // skip it. Next parse the radius and height of the tubes as doubles.
    // Then calculate the volume as V = radius^2 * pi * height with pi given
    // from the Java Math class. Lastly add the volume to the total volume
    // before returning the total volume after all of the volume of tubes
    // has been added.
    try (Scanner fileScanner = new Scanner(new File(filename))) {
      while (fileScanner.hasNextLine()) {
        String line = fileScanner.nextLine();
        String[] splitLines = line.split(delimiter);

        if (splitLines.length != numberOfColumns) {
          continue;
        }

        double radius = Double.parseDouble(splitLines[1]);
        double height = Double.parseDouble(splitLines[2]);

        totalVolume += radius * radius * Math.PI * height;
      }
    } catch (Exception e) {
      e.printStackTrace();
    }

    return totalVolume;
  }
}
