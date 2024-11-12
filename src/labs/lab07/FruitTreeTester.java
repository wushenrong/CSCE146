/*
 * Samuel Wu
 * 2024-11-09
 */

package labs.lab07;

import java.io.File;
import java.util.Scanner;

public class FruitTreeTester {
    public static final double FRUIT_WEIGHT_TO_DELETE = 0.4859853412170728;

    public static LinkedBST<Fruit> fruitTree = new LinkedBST<Fruit>();
    public static Scanner keyboardScanner = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("Welcome to the fruit tree!");

        readFruitFile();
        printInOrder();
        printPreOrder();
        printPostOrder();

        keyboardScanner.close();
    }

    public static void readFruitFile() {
        System.out.println("Please enter a Fruit File Name");
        String filename = keyboardScanner.nextLine();

        System.out.println("Populating tree file");

        try (Scanner fileScanner = new Scanner(new File(filename))) {
            while (fileScanner.hasNextLine()) {
                String line = fileScanner.nextLine();
                String[] fields = line.split(Fruit.DELIMITER);

                if (fields.length != Fruit.NUMBER_OF_FIELDS)
                    continue;

                String fruitType = fields[0];
                double fruitWeight = Double.parseDouble(fields[1]);

                fruitTree.add(new Fruit(fruitType, fruitWeight));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void printInOrder() {
        System.out.println("Printing the in-order traversal");
        fruitTree.printInOrder();
        System.out.println();
    }

    public static void printPreOrder() {
        System.out.println("Printing the pre-order traversal");
        fruitTree.printPreOrder();
        System.out.println();
    }

    public static void printPostOrder() {
        System.out.println("Printing the post-order traversal");
        fruitTree.printPostOrder();
        System.out.println();
    }

    public static void deleteFruit() {
        System.out.println("Deleting: " + Fruit.TYPE_APPLE + "\t" + FRUIT_WEIGHT_TO_DELETE);
        fruitTree.remove(new Fruit(Fruit.TYPE_APPLE, FRUIT_WEIGHT_TO_DELETE));
        printInOrder();
    }
}
