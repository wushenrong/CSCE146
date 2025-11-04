/*
 * SPDX-FileCopyrightText: 2024 Samuel Wu
 *
 * SPDX-License-Identifier: MIT
 */

package labs.lab07;

public class LinkedBinarySearchTree<T extends Comparable<T>> {
  private class Node {
    T data;
    Node leftChild;
    Node rightChild;

    Node(T data) {
      this.data = data;
    }
  }

  private Node root;

  public void add(T data) {
    if (data == null) {
      return;
    }

    root = add(root, data);
  }

  public void printInOrder() {
    printInOrder(root);
  }

  public void printPostOrder() {
    printPostOrder(root);
  }

  public void printPreOrder() {
    printPreOrder(root);
  }

  public void remove(T data) {
    if (data == null) {
      return;
    }

    root = remove(root, data);
  }

  public boolean search(T data) {
    return data != null && search(root, data);
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

  private Node findMinNode(Node node) {
    return node == null ? null : node.leftChild == null ? node : findMinNode(node.leftChild);
  }

  private void printInOrder(Node node) {
    if (node == null) {
      return;
    }

    printInOrder(node.leftChild);
    System.out.println(node.data);
    printInOrder(node.rightChild);
  }

  private void printPostOrder(Node node) {
    if (node == null) {
      return;
    }

    printPostOrder(node.leftChild);
    printPostOrder(node.rightChild);
    System.out.println(node.data);
  }

  private void printPreOrder(Node node) {
    if (node == null) {
      return;
    }

    System.out.println(node.data);
    printPreOrder(node.leftChild);
    printPreOrder(node.rightChild);
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

      if (temp != null) {
        node.data = temp.data;
      }

      node.rightChild = remove(node.rightChild, data);
    }

    return node;
  }

  private boolean search(Node node, T data) {
    return node != null && (data.compareTo(node.data) > 0 ? search(node.rightChild, data)
        : data.compareTo(node.data) >= 0 || search(node.leftChild, data));
  }
}
