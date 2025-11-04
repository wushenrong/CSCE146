/*
 * SPDX-FileCopyrightText: 2024 Samuel Wu
 *
 * SPDX-License-Identifier: MIT
 */

package homework.homework01;

import java.util.Objects;

/// A class representation of a Prize with its name and price.
public class Prize {
  /// The separator for the Prize name and price in a Prize list.
  public static final String DELIMITER = "\t";
  /// How many fields that Prize has.
  public static final int NUMBER_OF_FIELDS = 2;

  /// Default name for Prize.
  public static final String DEFAULT_NAME = "none";
  public static final double DEFAULT_PRICE = 0.0;

  private String name;
  private double price;

  /// Initialize a Prize with {@value #DEFAULT_NAME} as the name and {@value #DEFAULT_PRICE} as the
  // price.
  public Prize() {
    this(DEFAULT_NAME, DEFAULT_PRICE);
  }

  /// Initialize a Prize with a custom name and price.
  ///
  /// @param name The name of the prize.
  /// @param price The price of the prize.
  public Prize(String name, double price) {
    setName(name);
    setPrice(price);
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj) {
      return true;
    }

    if (!(obj instanceof Prize other)) {
      return false;
    }

    return Objects.equals(name, other.name)
        && Double.doubleToLongBits(price) == Double.doubleToLongBits(other.price);
  }

  public String getName() {
    return name;
  }

  public double getPrice() {
    return price;
  }

  @Override
  public int hashCode() {
    return Objects.hash(name, price);
  }

  /// Sets the name of the Prize. If the name is `null`, set it to {@value #DEFAULT_NAME}.
  ///
  /// @param name The name for the prize.
  public void setName(String name) {
    this.name = name != null ? name : DEFAULT_NAME;
  }

  /// Sets the price of the Prize. If the price is negative, set it to {@value #DEFAULT_PRICE}.
  ///
  /// @param price The price for the Prize.
  public void setPrice(double price) {
    this.price = price >= DEFAULT_PRICE ? price : DEFAULT_PRICE;
  }

  @Override
  public String toString() {
    return "Prize: " + name + " Price: " + price;
  }
}
