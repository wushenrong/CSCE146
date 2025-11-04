/*
 * SPDX-FileCopyrightText: 2024 Samuel Wu
 *
 * SPDX-License-Identifier: MIT
 */

package labs.lab05;

public class LinkedListQueue<T> implements IQueue<T> {
  private class Node {
    T data;
    Node link;

    Node(T data, Node link) {
      this.data = data;
      this.link = link;
    }
  }

  private Node head;

  private Node tail;

  public LinkedListQueue() {
    head = null;
    tail = null;
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

    if (tail != null) {
      tail.link = temp;
      tail = tail.link;
    }
  }

  @Override
  public T peek() {
    return head == null ? null : head.data;
  }

  @Override
  public void print() {
    for (Node temp = head; temp != null; temp = temp.link) {
      System.out.println(temp.data);
    }
  }
}
