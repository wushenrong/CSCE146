/*
 * SPDX-FileCopyrightText: 2024 Samuel Wu
 *
 * SPDX-License-Identifier: MIT
 */

package labs.lab08;

public class Order implements Comparable<Order> {
  public static final String DEFAULT_VALUE = "none";

  private String customer;
  private String foodOrder;
  private int cookingTime;
  private int arrivalTime;
  private int cookingTimeLeft;

  public Order() {
    this(DEFAULT_VALUE, DEFAULT_VALUE, 1, 0);
  }

  public Order(String customer, String foodOrder, int cookingTime, int arrivalTime) {
    setCustomer(customer);
    setFoodOrder(foodOrder);
    setCookingTime(cookingTime);
    setArrivalTime(arrivalTime);
    setCookingTimeLeft(cookingTime);
  }

  public String getCustomer() {
    return customer;
  }

  public void setCustomer(String customer) {
    this.customer = customer != null ? customer : DEFAULT_VALUE;
  }

  public String getFoodOrder() {
    return foodOrder;
  }

  public void setFoodOrder(String foodOrder) {
    this.foodOrder = foodOrder != null ? foodOrder : DEFAULT_VALUE;
  }

  public int getCookingTime() {
    return cookingTime;
  }

  public void setCookingTime(int cookingTime) {
    this.cookingTime = cookingTime >= 1 ? cookingTime : 1;
  }

  public int getArrivalTime() {
    return arrivalTime;
  }

  public void setArrivalTime(int arrivalTime) {
    this.arrivalTime = arrivalTime >= 0 ? arrivalTime : 0;
  }

  public int getCookingTimeLeft() {
    return cookingTimeLeft;
  }

  public void setCookingTimeLeft(int cookingTimeLeft) {
    this.cookingTimeLeft = cookingTimeLeft >= 1 ? cookingTimeLeft : 1;
  }

  /// Decreases the cooking time by 1 minute.
  public void cookForOneMinute() {
    cookingTimeLeft--;
  }

  public boolean isDone() {
    return cookingTimeLeft == 0;
  }

  @Override
  public String toString() {
    return "Customer: "
        + customer
        + ", Order: "
        + foodOrder
        + ", Cooking Time Left: "
        + cookingTimeLeft;
  }

  @Override
  public int compareTo(Order other) {
    return other == null || cookingTime < other.cookingTime
        ? -1
        : cookingTime > other.cookingTime ? 1 : 0;
  }
}
