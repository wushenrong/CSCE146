/*
 * SPDX-FileCopyrightText: 2024 Samuel Wu
 *
 * SPDX-License-Identifier: MIT
 */

package labs.lab05;

public interface IQueue<T> {
  void enqueue(T data);

  T dequeue();

  T peek();

  void print();
}
