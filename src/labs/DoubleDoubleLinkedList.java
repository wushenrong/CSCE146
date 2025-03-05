/*
 * SPDX-FileCopyrightText: 2024 Samuel Wu
 *
 * SPDX-License-Identifier: MIT
 *
 * Project: Lab 04
 */

package labs;

/// A double linked list class that holds a list of doubles and can move forwards and backwards.
public class DoubleDoubleLinkedList {
  private DoubleNode head;
  private DoubleNode current;

  /// Creates an empty link list.
  public DoubleDoubleLinkedList() {
    head = null;
    current = null;
  }

  /// Adds a double to the end of the linked list.
  ///
  /// @param data The double value to add.
  public void add(Double data) {
    if (data == null) {
      return;
    }

    if (head == null) {
      head = new DoubleNode(data, null, null);
      current = head;
      return;
    }

    DoubleNode temp = head;

    while (temp.nextLink != null) {
      temp = temp.nextLink;
    }

    temp.nextLink = new DoubleNode(data, null, temp);
  }

  /// Removes a double from the linked list.
  ///
  /// @param data The double value to remove.
  public void remove(Double data) {
    if (data == null) {
      return;
    }

    if (head != null && head.data.equals(data)) {
      head = head.nextLink;
      head.previousLink = null;
      return;
    }

    DoubleNode temp = head;

    while (temp != null) {
      if (temp.data.equals(data)) {
        break;
      }

      temp = temp.nextLink;
    }

    if (temp == null) {
      return;
    }

    if (temp.previousLink != null) {
      temp.previousLink.nextLink = temp.nextLink;
    }

    if (temp.nextLink != null) {
      temp.nextLink.previousLink = temp.previousLink;
    }
  }

  /// Go to the next node by checking if the current node is not null.
  public void gotoNext() {
    if (current == null) {
      return;
    }

    current = current.nextLink;
  }

  /// Go to the previous node by checking if the current node is not null.
  public void gotoPrev() {
    if (current == null) {
      return;
    }

    current = current.previousLink;
  }

  /// Moves the pointer of the current node to the head of the linked list.
  public void reset() {
    current = head;
  }

  /// Moves the pointer of the current node to the end of the linked list.
  public void gotoEnd() {
    if (head == null) {
      current = head;
      return;
    }

    DoubleNode temp = head;

    while (temp.nextLink != null) {
      temp = temp.nextLink;
    }

    current = temp;
  }

  /// Returns true if there are more items in the linked list to process.
  public boolean hasMore() {
    return current != null;
  }

  /// Add a double value to the list after the current node.
  ///
  /// If the current node or data is `null`, do nothing. Else get a temporary reference of the next
  /// node. Then create a new node with the value that double links to the current node and the next
  /// node before linking that node back to the new node, if that node is not `null`. Lastly update
  /// the reference to the next node to the new node that was created if it is not `null`.
  ///
  /// @param data The double value to insert after the current node.
  public void addAfterCurrent(Double data) {
    if (current == null || data == null) {
      return;
    }

    DoubleNode temp = current.nextLink;

    current.nextLink = new DoubleNode(data, temp, current);

    if (temp != null) {
      temp.previousLink = current.nextLink;
    }
  }

  /// Remove the current node from the double linked list.
  ///
  /// First check if the current node is `null` then do nothing. Then if the reference of the
  /// current node is pointing at the head of the  list, then point the head to the next node after
  /// the head, remove the reference to the previous node, and move the current reference to the
  /// head of the list before returning. Next if the reference of the current node is pointing at
  /// the last node of the list, then move the reference of the current node back one node and
  /// remove the reference of next node of the current node with `null` before returning. Else make
  /// the previous node to point to the next node of the current node and vice-versa before moving
  /// the reference of the current node to the next node.
  public void removeCurrent() {
    if (current == null) {
      return;
    }

    if (current == head) {
      head = head.nextLink;
      head.previousLink = null;
      current = head;
      return;
    }

    if (current.nextLink == null) {
      current = current.previousLink;
      current.nextLink = null;
      return;
    }

    current.previousLink.nextLink = current.nextLink;
    current.nextLink.previousLink = current.previousLink;
    current = current.nextLink;
  }

  /// Returns the double value stored at the current node.
  public Double getCurrent() {
    if (current == null) {
      return null;
    }

    return current.data;
  }

  /// Sets the double value of the current value if it is not empty.
  ///
  /// @param data The double value to set the value of the current node
  public void setCurrent(Double data) {
    if (current != null && data != null) {
      current.data = data;
    }
  }

  /// Print out the entire link list to the console.
  public void print() {
    for (DoubleNode temp = head; temp != null; temp = temp.nextLink) {
      System.out.println(temp.data);
    }
  }

  /// Checks if a double value is contained in the linked list by iterating though the list. Uses
  /// the [equals][Double#equals(Object obj)] method instead of `==` because the linked list is
  /// using the [Double] class wrapper instead of the double primitive.
  ///
  /// @param data The double value to see if it is in the linked list.
  /// @return True if the double value is in the list, otherwise false.
  public boolean contains(Double data) {
    if (data == null) {
      return false;
    }

    for (DoubleNode temp = head; temp != null; temp = temp.nextLink) {
      if (temp.data.equals(data)) {
        return true;
      }
    }

    return false;
  }

  /// A node for a Linked List that stores a class wrapper for the primitive type double and
  /// references to the next and previous Nodes.
  private class DoubleNode {
    Double data;
    DoubleNode nextLink;
    DoubleNode previousLink;

    DoubleNode(Double data, DoubleNode nextLink, DoubleNode previousLink) {
      this.data = data;
      this.nextLink = nextLink;
      this.previousLink = previousLink;
    }
  }
}
