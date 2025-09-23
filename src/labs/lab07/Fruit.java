/*
 * SPDX-FileCopyrightText: 2024 Samuel Wu
 *
 * SPDX-License-Identifier: MIT
 */

package labs.lab07;

import java.util.Objects;

public class Fruit implements Comparable<Fruit> {
  public static final int NUMBER_OF_FIELDS = 2;
  public static final String DELIMITER = "\t";

  public static final String TYPE_APPLE = "Apple";
  public static final String TYPE_ORANGE = "Orange";
  public static final String TYPE_BANANA = "Banana";
  public static final String TYPE_KIWI = "Kiwi";
  public static final String TYPE_TOMATO = "Tomato";

  public static final double DEFAULT_WEIGHT = 1.0;

  private String type;
  private double weight;

  public Fruit() {
    this(TYPE_APPLE, DEFAULT_WEIGHT);
  }

  public Fruit(String type, double weight) {
    setType(type);
    setWeight(weight);
  }

  public String getType() {
    return type;
  }

  public void setType(String type) {
    this.type = isTypeValid(type) ? type : TYPE_APPLE;
  }

  public double getWeight() {
    return weight;
  }

  public void setWeight(double weight) {
    this.weight = weight > 0.0 ? weight : DEFAULT_WEIGHT;
  }

  /** Check if the type of the fruit is either an apple, orange, banana, kiwi, or tomato. */
  private static boolean isTypeValid(String fruitType) {
    return fruitType.equals(TYPE_APPLE) || fruitType.equals(TYPE_ORANGE)
        || fruitType.equals(TYPE_BANANA) || fruitType.equals(TYPE_KIWI)
        || fruitType.equals(TYPE_TOMATO);
  }

  @Override
  public String toString() {
    return "Type: " + type + DELIMITER + "Weight: " + weight;
  }

  /**
   * Compare a fruit to another by their weights, if the current fruit is less than the other fruit,
   * return -1. If the current fruit is greater than the other fruit, return 1. Else return -1, 1,
   * or 0 by comparing their type alphabetically.
   */
  @Override
  public int compareTo(Fruit other) {
    return other == null || weight < other.weight ? -1
        : weight > other.weight ? 1 : type.compareTo(other.type);
  }

  @Override
  public int hashCode() {
    return Objects.hash(type, weight);
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj) {
      return true;
    }

    if (!(obj instanceof Fruit)) {
      return false;
    }

    Fruit other = (Fruit) obj;

    return Objects.equals(type, other.type)
        && Double.doubleToLongBits(weight) == Double.doubleToLongBits(other.weight);
  }
}
