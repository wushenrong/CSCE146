/*
 * SPDX-FileCopyrightText: 2024 Samuel Wu
 *
 * SPDX-License-Identifier: MIT
 */

package labs.lab08;

public class Order implements Comparable<Order> {
  public static final String DEFAULT_ORDER = "none";

  private String customer;
  private String foodOrder;
  private int cookingTime;
  private int arrivalTime;
  private int cookingTimeLeft;

  public Order() {
    customer = DEFAULT_ORDER;
    foodOrder = DEFAULT_ORDER;
    cookingTime = 1;
    arrivalTime = 0;
    cookingTimeLeft = 1;
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
    if (customer != null) {
      this.customer = customer;
    } else {
      this.customer = DEFAULT_ORDER;
    }
  }

  public String getFoodOrder() {
    return foodOrder;
  }

  public void setFoodOrder(String foodOrder) {
    if (foodOrder != null) {
      this.foodOrder = foodOrder;
    } else {
      this.foodOrder = DEFAULT_ORDER;
    }
  }

  public int getCookingTime() {
    return cookingTime;
  }

  public void setCookingTime(int cookingTime) {
    if (cookingTime >= 1) {
      this.cookingTime = cookingTime;
    } else {
      this.cookingTime = 1;
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

  public int getCookingTimeLeft() {
    return cookingTimeLeft;
  }

  public void setCookingTimeLeft(int cookingTimeLeft) {
    if (cookingTimeLeft >= 1) {
      this.cookingTimeLeft = cookingTimeLeft;
    } else {
      this.cookingTimeLeft = 1;
    }
  }

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
    if (other == null) {
      return -1;
    }

    if (cookingTime < other.cookingTime) {
      return -1;
    }

    if (cookingTime > other.cookingTime) {
      return 1;
    }

    return 0;
  }
}
