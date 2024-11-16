/*
 * Samuel Wu
 * 2024-09-20
 */

package labs.lab03;

public class GroceryList {
    private ListNode head;
    private ListNode current;
    private ListNode previous;

    public GroceryList() {
        head = new ListNode();
        current = head;
        previous = null;
    }

    /**
     * Go to the next node by checking if the current reference to a node is a
     * node, if there is a node then set the reference of the previous node to
     * the current node and set the reference of the current node to the next
     * node, else do nothing.
     */
    public void gotoNext() {
        if (current != null) {
            previous = current;
            current = current.link;
        }
    }

    public GroceryItem getCurrent() {
        if (current != null) {
            return current.data;
        }

        return null;
    }

    public void setCurrent(GroceryItem data) {
        if (current != null && data != null) {
            current.data = data;
        }
    }

    /**
     * Adds a new grocery item to the linked list by checking if the grocery
     * item to add exists. Then check if the list is empty with a blank node, if
     * it is then add the grocery item to the empty node, else find the last
     * node in the list from the head of the list and then create and link a new
     * node with the item to the node at the end of the list.
     */
    public void addItem(GroceryItem data) {
        if (data == null) {
            return;
        }

        if (head != null && head.data == null) {
            head.data = data;
            return;
        }

        ListNode temp = head;

        while (temp.link != null) {
            temp = temp.link;
        }

        temp.link = new ListNode(data, null);
    }

    /**
     * Add a new grocery item after the current by first checking if either the
     * list, the first node, the reference to the current node, or the grocery
     * item is null. If the previous check succeeds then do nothing, else create
     * a new node with the grocery item and reference to the next node of the
     * current node before referencing this node to the current node's link.
     */
    public void addItemAfterCurrent(GroceryItem data) {
        if (head == null || head.data == null || current == null || data == null) {
            return;
        }

        current.link = new ListNode(data, current.link);
    }

    /**
     * Removing the current node from the linked list by changing the link of
     * the previous node to reference the next node. Then set the reference of
     * the current node to the next node by using the previous node's link. If
     * the current node is a reference to the head of the node, change the
     * reference of the head node to the next node before removing the current
     * node. If the current node is null then do nothing.
     */
    public void removeCurrent() {
        if (current == null) {
            return;
        }

        if (current == head) {
            head = head.link;
            current = head;
            return;
        }

        previous.link = current.link;
        current = current.link;
    }

    public void showList() {
        for (ListNode temp = head; temp != null; temp = temp.link) {
            System.out.println(temp.data);
        }
    }

    /**
     * Checks if a grocery item is in the linked list by looping over the nodes
     * from the head of the list if the nodes exist. Then checking if the
     * contents of grocery item stored in the node equals the grocery item
     * given, if true return true else keep going to the next node in the list
     * until the grocery item is found, or iterated to the end of the list and
     * return false for the item not being found.
     */
    public boolean contains(GroceryItem data) {
        for (ListNode temp = head; temp != null; temp = temp.link) {
            if (temp.data.equals(data)) {
                return true;
            }
        }

        return false;
    }

    public double totalCost() {
        double totalCost = 0.0;

        for (ListNode temp = head; temp != null; temp = temp.link) {
            totalCost += temp.data.getValue();
        }

        return totalCost;
    }

    private class ListNode {
        GroceryItem data;
        ListNode link;

        ListNode() {
            data = null;
            link = null;
        }

        ListNode(GroceryItem data, ListNode link) {
            this.data = data;
            this.link = link;
        }
    }
}
