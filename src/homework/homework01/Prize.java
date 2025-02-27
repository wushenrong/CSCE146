/*
 * SPDX-FileCopyrightText: 2024 Samuel Wu
 *
 * SPDX-License-Identifier: MIT
 */

package homework.homework01;

import java.util.Objects;

/// A class representation of a Prize with its name and price.
public class Prize {
  public static final String DEFAULT_NAME = "none";
  public static final String DELIMITER = "\t";
  public static final int NUMBER_OF_FIELDS = 2;

  private String name;
  private double price;

  /// Initialize a Prize with {@value #DEFAULT_NAME} as the name and `0.0` as the price.
  public Prize() {
    name = DEFAULT_NAME;
    price = 0.0;
  }

  /// Initialize a Prize with a custom name and price.
  ///
  /// @param name The name of the prize.
  /// @param price The price of the prize.
  public Prize(String name, double price) {
    setName(name);
    setPrice(price);
  }

  public String getName() {
    return name;
  }

  /// Sets the name of the prize. If the name is `null`, set it to {@value #DEFAULT_NAME}.
  ///
  /// @param name The name for the prize.
  public void setName(String name) {
    if (name != null) {
      this.name = name;
    } else {
      this.name = DEFAULT_NAME;
    }
  }

  public double getPrice() {
    return price;
  }

  /// Sets the price of the Prize. If the price is negative, set it to `0.0`.
  ///
  /// @param price The price for the prize.
  public void setPrice(double price) {
    if (price >= 0.0) {
      this.price = price;
    } else {
      this.price = 0.0;
    }
  }

  @Override
  public String toString() {
    return "Prize: " + name + " Price: " + price;
  }

  @Override
  public int hashCode() {
    return Objects.hash(name, price);
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj) {
      return true;
    }

    if (!(obj instanceof Prize)) {
      return false;
    }

    Prize other = (Prize) obj;

    return Objects.equals(name, other.name)
        && Double.doubleToLongBits(price) == Double.doubleToLongBits(other.price);
  }
}
