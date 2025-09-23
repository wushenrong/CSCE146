/*
 * SPDX-FileCopyrightText: 2024 Samuel Wu
 *
 * SPDX-License-Identifier: MIT
 */

package homework.homework03;

import homework.homework02.GenericLinkedList;
import java.io.File;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.util.Scanner;

public class TaskOrganizer {
  private GenericLinkedList<Task>[] organizedTasks;

  public TaskOrganizer() {
    init();
  }

  @SuppressWarnings("unchecked")
  public void init() {
    organizedTasks = new GenericLinkedList[Task.NUMBER_OF_PRIORITIES];

    for (int priority = 0; priority < organizedTasks.length; priority++) {
      organizedTasks[priority] = new GenericLinkedList<>();
    }
  }

  /**
   * Adds a task to the task list and organizes it by its priority and when it was added to the
   * list. If the same task with the same priority was added, skip the task. Then add the task to
   * the task list.
   */
  public void addTask(Task data) {
    if (data == null) {
      return;
    }

    int taskPriority = data.getPriority();

    if (organizedTasks[taskPriority].contains(data)) {
      System.out.println(
          "Task \"" + data.getAction() + "\" with priority " + taskPriority + " already exists");
      System.out
          .println("Skipping Task \"" + data.getAction() + "\" with priority " + taskPriority);
      return;
    }

    organizedTasks[taskPriority].add(data);
  }

  /**
   * Removes a task by getting the task list based on the task's priority, then manually looping
   * through the task list to remove the task. If the current task is equal to the task given,
   * remove it and return. Else move to the next task until there are no task to check. If the task
   * to remove is null, then do nothing.
   */
  public void removeTask(Task data) {
    if (data == null) {
      return;
    }

    int taskPriority = data.getPriority();

    GenericLinkedList<Task> taskList = organizedTasks[taskPriority];

    taskList.resetCurrent();

    while (taskList.hasNext()) {
      if (taskList.getCurrent().equals(data)) {
        taskList.removeCurrent();
        return;
      }

      taskList.next();
    }
  }

  /**
   * Print each task based on their priority from 0 to 4. Loops over the organized tasks array by
   * priority and then looping over the task linked list manually before printing out the task
   * action based on when the task was added to the list.
   */
  public void printTasks() {
    for (int priority = 0; priority < organizedTasks.length; priority++) {
      System.out.println("\n=== Tasks with priority " + priority + " ===");

      GenericLinkedList<Task> taskList = organizedTasks[priority];

      taskList.resetCurrent();

      while (taskList.hasNext()) {
        Task data = taskList.getCurrent();
        System.out.println("[Task] " + data.getAction());
        taskList.next();
      }
    }
  }

  public void readTaskFile(String filename) {
    init();

    try (Scanner fileScanner = new Scanner(new File(filename))) {
      while (fileScanner.hasNext()) {
        String entry = fileScanner.nextLine();
        String[] fields = entry.split(Task.DELIMITER);

        if (fields.length != Task.NUMBER_OF_FIELDS) {
          continue;
        }

        int taskPriority = Integer.parseInt(fields[0]);
        String taskAction = fields[1];

        addTask(new Task(taskPriority, taskAction));
      }
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  public void writeTaskFile(String filename) {
    try (PrintWriter fileWriter = new PrintWriter(new FileOutputStream(filename))) {
      for (int priority = 0; priority < organizedTasks.length; priority++) {
        GenericLinkedList<Task> taskList = organizedTasks[priority];

        taskList.resetCurrent();

        while (taskList.hasNext()) {
          Task data = taskList.getCurrent();
          fileWriter.println(data);
          taskList.next();
        }
      }
    } catch (Exception e) {
      e.printStackTrace();
    }
  }
}
