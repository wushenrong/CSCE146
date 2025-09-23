/*
 * SPDX-FileCopyrightText: 2024 Samuel Wu
 *
 * SPDX-License-Identifier: MIT
 */

package labs.lab08;

public class Order implements Comparable<Order> {
  public static final String DEFAULT_VALUE = "none";
  public static final int DEFAULT_COOKING_TIME = 1;
  public static final int DEFAULT_ARRIVAL_TIME = 0;

  private String customer;
  private String foodOrder;
  private int cookingTime;
  private int arrivalTime;
  private int cookingTimeLeft;

  public Order() {
    this(DEFAULT_VALUE, DEFAULT_VALUE, DEFAULT_COOKING_TIME, DEFAULT_ARRIVAL_TIME);
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
    this.cookingTime = cookingTime >= DEFAULT_COOKING_TIME ? cookingTime : DEFAULT_COOKING_TIME;
  }

  public int getArrivalTime() {
    return arrivalTime;
  }

  public void setArrivalTime(int arrivalTime) {
    this.arrivalTime = arrivalTime >= DEFAULT_ARRIVAL_TIME ? arrivalTime : DEFAULT_ARRIVAL_TIME;
  }

  public int getCookingTimeLeft() {
    return cookingTimeLeft;
  }

  public void setCookingTimeLeft(int cookingTimeLeft) {
    this.cookingTimeLeft =
        cookingTimeLeft >= DEFAULT_COOKING_TIME ? cookingTimeLeft : DEFAULT_COOKING_TIME;
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
    return "Customer: " + customer + ", Order: " + foodOrder + ", Cooking Time Left: "
        + cookingTimeLeft;
  }

  @Override
  public int compareTo(Order other) {
    return other == null || cookingTime < other.cookingTime ? -1
        : cookingTime > other.cookingTime ? 1 : 0;
  }
}
