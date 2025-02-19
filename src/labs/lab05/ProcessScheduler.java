/*
 * SPDX-FileCopyrightText: 2024 Samuel Wu
 *
 * SPDX-License-Identifier: MIT
 */

package labs.lab05;

public class ProcessScheduler {
  private QueueI<Process> processes;
  private Process currentProcess;

  public ProcessScheduler() {
    processes = new LLQueue<Process>();
    currentProcess = null;
  }

  public Process getCurrentProcess() {
    return currentProcess;
  }

  /**
   * Adds and runs a new process. If there is a process currently running, add it to our queue.
   */
  public void addProcess(Process process) {
    if (currentProcess == null) {
      currentProcess = process;
      return;
    }

    processes.enqueue(process);
  }

  /**
   * Runs the next process by dequeueing the first element from the queue and set that process to
   * run as the current process. If the next process is null, dequeuing will set it to null, meaning
   * the queue was empty and no new process to run.
   */
  public void runNextProcess() {
    currentProcess = processes.dequeue();
  }

  /**
   * Cancelling the current process by enqueuing the current process to the end of the queue and
   * then replacing the current process with the next process by dequeuing.
   */
  public void cancelCurrentProcess() {
    if (currentProcess != null) {
      processes.enqueue(currentProcess);
      currentProcess = processes.dequeue();
    }
  }

  /**
   * Print out the queue list of processes that still needs to be run. This just runs the print
   * function that is defined in the queue interface and be implemented by an array queue or a
   * linked list queue.
   */
  public void printProcessQueue() {
    processes.print();
  }
}
