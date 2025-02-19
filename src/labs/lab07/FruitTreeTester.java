/*
 * SPDX-FileCopyrightText: 2024 Samuel Wu
 *
 * SPDX-License-Identifier: MIT
 */

package labs.lab07;

import java.io.File;
import java.util.Scanner;

public class FruitTreeTester {
  public static final String FRUIT_TYPE_TO_DELETE = Fruit.TYPE_APPLE;
  public static final double FRUIT_WEIGHT_TO_DELETE = 0.485_985_341_217_072_8;

  public static final LinkedBST<Fruit> FRUIT_TREE = new LinkedBST<>();
  public static final Scanner KEYBOARD_SCANNER = new Scanner(System.in);

  /**
   * Main function to test four subfunctions of the tree, adding, printing in order, pre order, and
   * post order, and removing a fruit.
   */
  public static void main(String[] args) {
    System.out.println("Welcome to the fruit tree!");

    readFruitFile();
    printInOrder();
    printPreOrder();
    printPostOrder();
    deleteFruit();

    KEYBOARD_SCANNER.close();
  }

  /**
   * Creating a fruit tree by asking the user for a fruit file. Then read each line of the file and
   * splitting the line by the delimiter. If the number of the fields is not 2, skip the line. Else
   * add the fruit by its type and weight.
   */
  public static void readFruitFile() {
    System.out.println("Please enter the filename for a Fruit File");
    String filename = KEYBOARD_SCANNER.nextLine();

    System.out.println("Populating the fruit tree");

    try (Scanner fileScanner = new Scanner(new File(filename))) {
      while (fileScanner.hasNextLine()) {
        String line = fileScanner.nextLine();
        String[] fields = line.split(Fruit.DELIMITER);

        if (fields.length != Fruit.NUMBER_OF_FIELDS) {
          continue;
        }

        String fruitType = fields[0];
        double fruitWeight = Double.parseDouble(fields[1]);

        FRUIT_TREE.add(new Fruit(fruitType, fruitWeight));
      }
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  public static void printInOrder() {
    System.out.println("Printing the in-order traversal");
    FRUIT_TREE.printInOrder();
    System.out.println();
  }

  public static void printPreOrder() {
    System.out.println("Printing the pre-order traversal");
    FRUIT_TREE.printPreOrder();
    System.out.println();
  }

  public static void printPostOrder() {
    System.out.println("Printing the post-order traversal");
    FRUIT_TREE.printPostOrder();
    System.out.println();
  }

  /**
   * Test if the remove function of the tree is working by removing an existing fruit and print the
   * tree in order to see if the has been removed.
   */
  public static void deleteFruit() {
    System.out
        .println("Deleting: " + FRUIT_TYPE_TO_DELETE + Fruit.DELIMITER + FRUIT_WEIGHT_TO_DELETE);
    FRUIT_TREE.remove(new Fruit(FRUIT_TYPE_TO_DELETE, FRUIT_WEIGHT_TO_DELETE));
    printInOrder();
  }
}
