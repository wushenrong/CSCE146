/*
 * Samuel Wu
 * 2024-11-04
 */

package labs.lab06;

public class StringLinkedQueue {
    private StringNode head;
    private StringNode tail;

    public StringLinkedQueue() {
        head = null;
        tail = null;
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

    public String dequeue() {
        if (head == null) {
            return null;
        }

        String data = head.data;
        head = head.link;
        return data;
    }

    public int countStrings() {
        int count = 0;

        for (StringNode temp = head; temp != null; temp = temp.link) {
            count++;
        }

        return count;
    }

    private class StringNode {
        String data;
        StringNode link;

        StringNode(String data, StringNode link) {
            this.data = data;
            this.link = link;
        }
    }
}
