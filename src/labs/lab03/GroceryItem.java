/*
 * SPDX-FileCopyrightText: 2024 Samuel Wu
 *
 * SPDX-License-Identifier: MIT
 */

package labs.lab03;

import java.util.Objects;

public class GroceryItem {
  private String name;
  private double value;

  public GroceryItem() {
    name = "none";
    value = 0.0;
  }

  public GroceryItem(String name, double value) {
    setName(name);
    setValue(value);
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name != null ? name : "none";
  }

  public double getValue() {
    return value;
  }

  public void setValue(double value) {
    this.value = value >= 0.0 ? value : 0.0;
  }

  @Override
  public String toString() {
    return "Grocery Item Name: " + name + " Value: " + value;
  }

  @Override
  public int hashCode() {
    return Objects.hash(name, value);
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj) {
      return true;
    }

    if (!(obj instanceof GroceryItem)) {
      return false;
    }

    GroceryItem other = (GroceryItem) obj;

    return Objects.equals(name, other.name)
        && Double.doubleToLongBits(value) == Double.doubleToLongBits(other.value);
  }
}
