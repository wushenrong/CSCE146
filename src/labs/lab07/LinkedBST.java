/*
 * Samuel Wu
 * 2024-11-09
 */

package labs.lab07;

public class LinkedBST<T extends Comparable<T>> {
    private Node root;

    public void add(T data) {
        if (data == null) {
            return;
        }

        root = add(root, data);
    }

    private Node add(Node node, T data) {
        if (node == null) {
            node = new Node(data);
        } else if (data.compareTo(node.data) > 0) {
            node.rightChild = add(node.rightChild, data);
        } else if (data.compareTo(node.data) < 0) {
            node.leftChild = add(node.leftChild, data);
        }

        return node;
    }

    public void remove(T data) {
        if (data == null) {
            return;
        }

        root = remove(root, data);
    }

    private Node remove(Node node, T data) {
        if (node == null) {
            return null;
        }

        if (data.compareTo(node.data) > 0) {
            node.rightChild = remove(node.rightChild, data);
        } else if (data.compareTo(node.data) < 0) {
            node.leftChild = remove(node.leftChild, data);
        } else {
            if (node.rightChild == null) {
                return node.leftChild;
            }

            if (node.leftChild == null) {
                return node.rightChild;
            }

            Node temp = findMinNode(node.rightChild);
            node.data = temp.data;
            node.rightChild = remove(node.rightChild, data);
        }

        return node;
    }

    private Node findMinNode(Node node) {
        if (node == null) {
            return null;
        }

        if (node.leftChild == null) {
            return node;
        }

        return findMinNode(node.leftChild);
    }

    public boolean search(T data) {
        if (data == null) {
            return false;
        }

        return search(root, data);
    }

    private boolean search(Node node, T data) {
        if (node == null) {
            return false;
        }

        if (data.compareTo(node.data) > 0) {
            return search(node.rightChild, data);
        }

        if (data.compareTo(node.data) < 0) {
            return search(node.leftChild, data);
        }

        return true;
    }

    public void printPreOrder() {
        printPreOrder(root);
    }

    private void printPreOrder(Node node) {
        if (node == null) {
            return;
        }

        System.out.println(node.data);
        printPreOrder(node.leftChild);
        printPreOrder(node.rightChild);
    }

    public void printInOrder() {
        printInOrder(root);
    }

    private void printInOrder(Node node) {
        if (node == null) {
            return;
        }

        printInOrder(node.leftChild);
        System.out.println(node.data);
        printInOrder(node.rightChild);
    }

    public void printPostOrder() {
        printPostOrder(root);
    }

    private void printPostOrder(Node node) {
        if (node == null) {
            return;
        }

        printPostOrder(node.leftChild);
        printPostOrder(node.rightChild);
        System.out.println(node.data);
    }

    private class Node {
        T data;
        Node leftChild;
        Node rightChild;

        Node(T data) {
            this.data = data;
        }
    }
}
