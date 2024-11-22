/*
 * Samuel Wu
 * 2024-11-02
 */

package homework.homework04;

public class GenericLinkedQueue<T> {
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

        tail.link = temp;
        tail = tail.link;
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
        if (head == null) {
            return null;
        }

        return head.data;
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
