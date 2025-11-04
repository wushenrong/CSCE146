/*
 * SPDX-FileCopyrightText: 2024 Samuel Wu
 *
 * SPDX-License-Identifier: MIT
 */

package labs.lab03;

import java.util.Objects;

public class GroceryItem {
  public static final String DEFAULT_NAME = "none";
  public static final double DEFAULT_VALUE = 0.0;

  private String name;
  private double value;

  public GroceryItem() {
    this(DEFAULT_NAME, DEFAULT_VALUE);
  }

  public GroceryItem(String name, double value) {
    setName(name);
    setValue(value);
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj) {
      return true;
    }

    if (!(obj instanceof GroceryItem other)) {
      return false;
    }

    return Objects.equals(name, other.name)
        && Double.doubleToLongBits(value) == Double.doubleToLongBits(other.value);
  }

  public String getName() {
    return name;
  }

  public double getValue() {
    return value;
  }

  @Override
  public int hashCode() {
    return Objects.hash(name, value);
  }

  public void setName(String name) {
    this.name = name != null ? name : DEFAULT_NAME;
  }

  public void setValue(double value) {
    this.value = value >= DEFAULT_VALUE ? value : DEFAULT_VALUE;
  }

  @Override
  public String toString() {
    return "Grocery Item Name: " + name + " Value: " + value;
  }
}
