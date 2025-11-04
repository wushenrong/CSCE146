/*
 * SPDX-FileCopyrightText: 2024 Samuel Wu
 *
 * SPDX-License-Identifier: MIT
 */

package labs.lab05;

public class Process {
  public static final String DEFAULT_NAME = "none";
  public static final double DEFAULT_COMPLETION_TIME = 0.0;

  private String name;
  private double completionTime;

  public Process() {
    this(DEFAULT_NAME, DEFAULT_COMPLETION_TIME);
  }

  public Process(String name, double completionTime) {
    setName(name);
    setCompletionTime(completionTime);
  }

  public double getCompletionTime() {
    return completionTime;
  }

  public String getName() {
    return name;
  }

  public void setCompletionTime(double completionTime) {
    this.completionTime =
        completionTime >= DEFAULT_COMPLETION_TIME ? completionTime : DEFAULT_COMPLETION_TIME;
  }

  public void setName(String name) {
    this.name = name != null ? name : DEFAULT_NAME;
  }

  @Override
  public String toString() {
    return "Process Name: " + name + " Completion Time: " + completionTime;
  }
}
