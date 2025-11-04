/*
 * SPDX-FileCopyrightText: 2024 Samuel Wu
 *
 * SPDX-License-Identifier: MIT
 */

package homework.homework03;

import java.util.Objects;

public class Task {
  public static final String DELIMITER = "\t";
  public static final int NUMBER_OF_FIELDS = 2;

  public static final int NUMBER_OF_PRIORITIES = 5;

  public static final int DEFAULT_PRIORITY = 4;
  public static final String DEFAULT_ACTION = "none";

  private int priority;
  private String action;

  public Task() {
    this(DEFAULT_PRIORITY, DEFAULT_ACTION);
  }

  public Task(int priority, String action) {
    setPriority(priority);
    setAction(action);
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj) {
      return true;
    }

    if (!(obj instanceof Task other)) {
      return false;
    }

    return priority == other.priority && Objects.equals(action, other.action);
  }

  public String getAction() {
    return action;
  }

  public int getPriority() {
    return priority;
  }

  @Override
  public int hashCode() {
    return Objects.hash(priority, action);
  }

  public void setAction(String action) {
    this.action = action != null ? action : DEFAULT_ACTION;
  }

  public void setPriority(int priority) {
    this.priority = priority >= 0 && priority < NUMBER_OF_PRIORITIES ? priority : DEFAULT_PRIORITY;
  }

  @Override
  public String toString() {
    return priority + DELIMITER + action;
  }
}
