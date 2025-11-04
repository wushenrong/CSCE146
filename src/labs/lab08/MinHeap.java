/*
 * SPDX-FileCopyrightText: 2024 Samuel Wu
 *
 * SPDX-License-Identifier: MIT
 */

package labs.lab08;

public class MinHeap<T extends Comparable<T>> {
  public static final int DEFAULT_SIZE = 64;

  private static int leftIndex(int index) {
    return index * 2 + 1;
  }

  private static int parentIndex(int index) {
    return (index - 1) / 2;
  }

  private static int rightIndex(int index) {
    return index * 2 + 2;
  }

  private T[] heap;

  private int lastIndex;

  public MinHeap() {
    init(DEFAULT_SIZE);
  }

  public MinHeap(int size) {
    init(size);
  }

  public void add(T data) {
    if (data == null || lastIndex >= heap.length) {
      return;
    }

    heap[lastIndex] = data;
    bubbleUp();
    lastIndex++;
  }

  @SuppressWarnings("unchecked")
  public void init(int size) {
    heap = size >= 2 ? (T[]) new Comparable[size] : (T[]) new Comparable[DEFAULT_SIZE];
    lastIndex = 0;
  }

  public T peek() {
    return heap[0];
  }

  public void print() {
    for (int i = 0; i < lastIndex; i++) {
      System.out.println(heap[i]);
    }
  }

  public T remove() {
    if (lastIndex <= 0) {
      return null;
    }

    final T ret = heap[0];
    heap[0] = heap[lastIndex - 1];
    lastIndex--;

    bubbleDown();

    return ret;
  }

  private void bubbleDown() {
    int index = 0;

    while (leftIndex(index) < lastIndex) {
      int smallestIndex = leftIndex(index);

      if (rightIndex(index) < lastIndex
          && heap[leftIndex(index)].compareTo(heap[rightIndex(index)]) > 0) {
        smallestIndex = rightIndex(index);
      }

      if (heap[index].compareTo(heap[smallestIndex]) <= 0) {
        break;
      }
      T temp = heap[index];
      heap[index] = heap[smallestIndex];
      heap[smallestIndex] = temp;

      index = smallestIndex;
    }
  }

  private void bubbleUp() {
    int index = lastIndex;

    while (index > 0 && heap[parentIndex(index)].compareTo(heap[index]) > 0) {
      T temp = heap[parentIndex(index)];
      heap[parentIndex(index)] = heap[index];
      heap[index] = temp;
      index = parentIndex(index);
    }
  }
}
