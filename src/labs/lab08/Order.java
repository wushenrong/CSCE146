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

  @Override
  public int compareTo(Order other) {
    return other == null || cookingTime < other.cookingTime ? -1
        : cookingTime > other.cookingTime ? 1 : 0;
  }

  /// Decreases the cooking time by 1 minute.
  public void cookForOneMinute() {
    cookingTimeLeft--;
  }

  public int getArrivalTime() {
    return arrivalTime;
  }

  public int getCookingTime() {
    return cookingTime;
  }

  public int getCookingTimeLeft() {
    return cookingTimeLeft;
  }

  public String getCustomer() {
    return customer;
  }

  public String getFoodOrder() {
    return foodOrder;
  }

  public boolean isDone() {
    return cookingTimeLeft == 0;
  }

  public void setArrivalTime(int arrivalTime) {
    this.arrivalTime = arrivalTime >= DEFAULT_ARRIVAL_TIME ? arrivalTime : DEFAULT_ARRIVAL_TIME;
  }

  public void setCookingTime(int cookingTime) {
    this.cookingTime = cookingTime >= DEFAULT_COOKING_TIME ? cookingTime : DEFAULT_COOKING_TIME;
  }

  public void setCookingTimeLeft(int cookingTimeLeft) {
    this.cookingTimeLeft =
        cookingTimeLeft >= DEFAULT_COOKING_TIME ? cookingTimeLeft : DEFAULT_COOKING_TIME;
  }

  public void setCustomer(String customer) {
    this.customer = customer != null ? customer : DEFAULT_VALUE;
  }

  public void setFoodOrder(String foodOrder) {
    this.foodOrder = foodOrder != null ? foodOrder : DEFAULT_VALUE;
  }

  @Override
  public String toString() {
    return "Customer: " + customer + ", Order: " + foodOrder + ", Cooking Time Left: "
        + cookingTimeLeft;
  }
}
