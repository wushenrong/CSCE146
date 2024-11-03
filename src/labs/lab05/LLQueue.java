/*
 * Samuel Wu
 * 2024-10-08
 */

package labs.lab05;

public class LLQueue<T> implements QueueI<T> {
    private class Node {
        T data;
        Node link;

        public Node(T data, Node link) {
            this.data = data;
            this.link = link;
        }
    }

    private Node head;
    private Node tail;

    public LLQueue() {
        head = null;
        tail = null;
    }

    /**
     * Adds data to the end of the queue by first checking if the data is not
     * null, then if the queue is empty, add it as the first and last element of
     * the queue. Else add the data at the end of the linked list queue and mark
     * it as the last element of the queue.
     */
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
}
