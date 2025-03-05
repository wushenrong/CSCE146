/*
 * SPDX-FileCopyrightText: 2024 Samuel Wu
 *
 * SPDX-License-Identifier: MIT
 */

package homework.homework06;

public class Sheep implements Comparable<Sheep> {
  public static final String DELIMITER = "\t";
  public static final int NUMBER_OF_FIELDS = 3;

  public static final String DEFAULT_NAME = "unknown";

  private String name;
  private int shearingTime;
  private int arrivalTime;

  public Sheep() {
    name = DEFAULT_NAME;
    shearingTime = 1;
    arrivalTime = 0;
  }

  public Sheep(String name, int shearingTime, int arrivalTime) {
    setName(name);
    setShearingTime(shearingTime);
    setArrivalTime(arrivalTime);
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

  public int getShearingTime() {
    return shearingTime;
  }

  public void setShearingTime(int shearingTime) {
    if (shearingTime >= 1) {
      this.shearingTime = shearingTime;
    } else {
      this.shearingTime = 1;
    }
  }

  public int getArrivalTime() {
    return arrivalTime;
  }

  public void setArrivalTime(int arrivalTime) {
    if (arrivalTime >= 0) {
      this.arrivalTime = arrivalTime;
    } else {
      this.arrivalTime = 0;
    }
  }

  @Override
  public String toString() {
    return "Name: " + name + ", Shear Time: " + shearingTime + ", Arrival Time: " + arrivalTime;
  }

  @Override
  public int compareTo(Sheep other) {
    if (other == null) {
      return -1;
    }

    if (shearingTime < other.shearingTime) {
      return -1;
    }

    if (shearingTime > other.shearingTime) {
      return 1;
    }

    return name.compareTo(other.name);
  }
}
