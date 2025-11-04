/*
 * SPDX-FileCopyrightText: 2024 Samuel Wu
 *
 * SPDX-License-Identifier: MIT
 */

package homework.homework04;

import labs.lab05.IQueue;

public class GenericLinkedQueue<T> implements IQueue<T> {
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

  public GenericLinkedQueue() {
    head = null;
    tail = null;
  }

  public int countQueue() {
    int count = 0;

    for (Node temp = head; temp != null; temp = temp.link) {
      count++;
    }

    return count;
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
