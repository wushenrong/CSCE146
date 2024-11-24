/*
 * SPDX-FileCopyrightText: 2024 Samuel Wu
 *
 * SPDX-License-Identifier: MIT
 *
 * Project: Lab 04
 */

package labs;

public class DoubleDoubleLL {
    private DoubleNode head;
    private DoubleNode current;

    public DoubleDoubleLL() {
        head = null;
        current = null;
    }

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

    /**
     * Go to the next node by checking if the current node is not null. Then
     * move the reference of the current node to the next node in the linked
     * list.
     */
    public void gotoNext() {
        if (current == null) {
            return;
        }

        current = current.nextLink;
    }

    public void gotoPrev() {
        if (current == null) {
            return;
        }

        current = current.previousLink;
    }

    public void reset() {
        current = head;
    }

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

    public boolean hasMore() {
        return current != null;
    }

    /**
     * Add a double value to the list after the current node. If the current
     * node or the value of data as a Double class wrapper type is null, do
     * nothing. Else get a temporary reference of the next node. Then create a
     * new node with the value that double links to the current node and the
     * next node before linking that node back to the new node, if that node is
     * not null. Lastly update the reference to the next node to the new node
     * that was created if it is not null.
     */
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

    /**
     * Remove the current node from the double linked list by checking if the
     * current node is null then do nothing. Then if the reference of the
     * current node is pointing at the head of the list, then point the head to
     * the next node after the head, remove the reference to the previous node,
     * and move the current reference to the head of the list before returning.
     * Next if the reference of the current node is pointing at the last node of
     * the list, then move the reference of the current node back one node and
     * remove the reference of next node of the current node with null before
     * returning. Else make the previous node to point to the next node of the
     * current node and vice-versa before moving the reference of the current
     * node to the next node.
     */
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

    /**
     * Gets the double value stored at the current node. Returns the Double
     * class wrapper type so it can return null if the current node is null.
     */
    public Double getCurrent() {
        if (current == null) {
            return null;
        }

        return current.data;
    }

    public void setCurrent(Double data) {
        if (current != null && data != null) {
            current.data = data;
        }
    }

    public void print() {
        for (DoubleNode temp = head; temp != null; temp = temp.nextLink) {
            System.out.println(temp.data);
        }
    }

    /**
     * Checks if a double value is contained in the linked list by iterating
     * though the list. Uses .equals instead of == because this linked list is
     * using the Double class wrapper instead of the double primitive.
     */
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

    /**
     * A Node for a Linked List that stores a class wrapper for the primitive
     * type double and references to the next and previous Nodes.
     */
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
