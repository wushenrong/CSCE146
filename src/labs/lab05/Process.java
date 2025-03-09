/*
 * SPDX-FileCopyrightText: 2024 Samuel Wu
 *
 * SPDX-License-Identifier: MIT
 */

package labs.lab05;

public class Process {
  private String name;
  private double completionTime;

  public Process() {
    name = "none";
    completionTime = 0.0;
  }

  public Process(String name, double completionTime) {
    setName(name);
    setCompletionTime(completionTime);
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name != null ? name : "none";
  }

  public double getCompletionTime() {
    return completionTime;
  }

  public void setCompletionTime(double completionTime) {
    this.completionTime = completionTime >= 0.0 ? completionTime : 0.0;
  }

  @Override
  public String toString() {
    return "Process Name: " + name + " Completion Time: " + completionTime;
  }
}
