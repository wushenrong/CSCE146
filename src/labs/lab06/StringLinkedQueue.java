/*
 * SPDX-FileCopyrightText: 2024 Samuel Wu
 *
 * SPDX-License-Identifier: MIT
 */

package labs.lab06;

public class StringLinkedQueue {
  private class StringNode {
    String data;
    StringNode link;

    StringNode(String data, StringNode link) {
      this.data = data;
      this.link = link;
    }
  }

  private StringNode head;

  private StringNode tail;

  public StringLinkedQueue() {
    head = null;
    tail = null;
  }

  public int countStrings() {
    int count = 0;

    for (StringNode temp = head; temp != null; temp = temp.link) {
      count++;
    }

    return count;
  }

  public String dequeue() {
    if (head == null) {
      return null;
    }

    String data = head.data;
    head = head.link;
    return data;
  }

  public void enqueue(String data) {
    if (data == null) {
      return;
    }

    StringNode temp = new StringNode(data, null);

    if (head == null) {
      head = temp;
      tail = head;
      return;
    }

    tail.link = temp;
    tail = tail.link;
  }
}
