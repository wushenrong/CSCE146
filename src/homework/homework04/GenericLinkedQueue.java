/*
 * SPDX-FileCopyrightText: 2024 Samuel Wu
 *
 * SPDX-License-Identifier: MIT
 */

package homework.homework04;

import labs.lab05.IQueue;

public class GenericLinkedQueue<T> implements IQueue<T> {
  private Node head;
  private Node tail;

  public GenericLinkedQueue() {
    head = null;
    tail = null;
  }

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

  public T dequeue() {
    if (head == null) {
      return null;
    }

    T data = head.data;
    head = head.link;
    return data;
  }

  public T peek() {
    return head == null ? null : head.data;
  }

  public void print() {
    for (Node temp = head; temp != null; temp = temp.link) {
      System.out.println(temp.data);
    }
  }

  public int countQueue() {
    int count = 0;

    for (Node temp = head; temp != null; temp = temp.link) {
      count++;
    }

    return count;
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
