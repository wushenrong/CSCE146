/*
 * SPDX-FileCopyrightText: 2024 Samuel Wu
 *
 * SPDX-License-Identifier: MIT
 */

package labs.lab05;

public interface IQueue<T> {
  T dequeue();

  void enqueue(T data);

  T peek();

  void print();
}
