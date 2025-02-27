/*
 * SPDX-FileCopyrightText: 2024 Samuel Wu
 *
 * SPDX-License-Identifier: MIT
 */

package labs.lab05;

public class LLQueue<T> implements QueueI<T> {
  private Node head;
  private Node tail;

  public LLQueue() {
    head = null;
    tail = null;
  }

  /**
   * Adds data to the end of the queue by first checking if the data is not `null`, then if the
   * queue is empty, add it as the first and last element of the queue. Else add the data at the end
   * of the linked list queue and mark it as the last element of the queue.
   */
  @Override
  public void enqueue(T data) {
    if (data == null) {
      return;
    }

    Node temp = new Node(data, null);

    if (head == null) {
      head = temp;
      tail = head;
      return;
    }

    tail.link = temp;
    tail = tail.link;
  }

  @Override
  public T dequeue() {
    if (head == null) {
      return null;
    }

    T data = head.data;
    head = head.link;
    return data;
  }

  @Override
  public T peek() {
    if (head == null) {
      return null;
    }

    return head.data;
  }

  @Override
  public void print() {
    for (Node temp = head; temp != null; temp = temp.link) {
      System.out.println(temp.data);
    }
  }

  private class Node {
    T data;
    Node link;

    Node(T data, Node link) {
      this.data = data;
      this.link = link;
    }
  }
}
