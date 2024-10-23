/*
 * Samuel Wu
 * 2024-09-25
 */

package homework.homework02;

public class GenericLinkedList<T> {
    private class Node {
        T data;
        Node link;

        public Node(T data, Node link) {
            this.data = data;
            this.link = link;
        }
    }

    private Node head;
    private Node current;
    private Node previous;

    public GenericLinkedList() {
        head = null;
        current = null;
        previous = null;
    }

    public void add(T data) {
        if (data == null) {
            return;
        }

        if (head == null) {
            head = new Node(data, null);
            current = head;
            return;
        }

        Node temp = head;

        while (temp.link != null) {
            temp = temp.link;
        }

        temp.link = new Node(data, null);
    }

    public void next() {
        if (current != null) {
            previous = current;
            current = current.link;
        }
    }

    public boolean hasNext() {
        return current != null;
    }

    public T getCurrent() {
        if (current == null) {
            return null;
        }

        return current.data;
    }

    public void setCurrent(T data) {
        if (current != null && data != null) {
            current.data = data;
        }
    }

    public void removeCurrent() {
        if (current == null) {
            return;
        }

        if (current == head) {
            head = head.link;
        }

        previous.link = current.link;
        current = current.link;
    }

    public void resetCurrent() {
        current = head;
        previous = null;
    }
}
