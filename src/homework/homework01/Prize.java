/*
 * SPDX-FileCopyrightText: 2024 Samuel Wu
 *
 * SPDX-License-Identifier: MIT
 */

package homework.homework01;

public class Prize {
  public static final String DEFAULT_NAME = "none";
  public static final String DELIMITER = "\t";
  public static final int NUMBER_OF_FIELDS = 2;

  private String name;
  private double price;

  public Prize() {
    name = DEFAULT_NAME;
    price = 0.0;
  }

  public Prize(String name, double price) {
    setName(name);
    setPrice(price);
  }

  public String getName() {
    return name;
  }

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
    final int prime = 31;
    int result = 1;
    result = prime * result + ((name == null) ? 0 : name.hashCode());
    long temp;
    temp = Double.doubleToLongBits(price);
    result = prime * result + (int) (temp ^ (temp >>> 32));
    return result;
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj) {
      return true;
    }

    if (obj == null) {
      return false;
    }

    if (getClass() != obj.getClass()) {
      return false;
    }

    Prize other = (Prize) obj;

    if (name == null) {
      if (other.name != null) {
        return false;
      }
    } else if (!name.equals(other.name)) {
      return false;
    }

    if (Double.doubleToLongBits(price) != Double.doubleToLongBits(other.price)) {
      return false;
    }

    return true;
  }
}
