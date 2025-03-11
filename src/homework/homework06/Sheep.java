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
    this.name = name != null ? name : DEFAULT_NAME;
  }

  public int getShearingTime() {
    return shearingTime;
  }

  public void setShearingTime(int shearingTime) {
    this.shearingTime = shearingTime >= 1 ? shearingTime : 1;
  }

  public int getArrivalTime() {
    return arrivalTime;
  }

  public void setArrivalTime(int arrivalTime) {
    this.arrivalTime = arrivalTime >= 0 ? arrivalTime : 0;
  }

  @Override
  public String toString() {
    return "Name: " + name + ", Shear Time: " + shearingTime + ", Arrival Time: " + arrivalTime;
  }

  @Override
  public int compareTo(Sheep other) {
    return other == null || shearingTime < other.shearingTime
        ? -1
        : shearingTime > other.shearingTime ? 1 : name.compareTo(other.name);
  }
}
