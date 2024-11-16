/*
 * Samuel Wu
 * 2024-10-08
 */

package labs.lab05;

public interface QueueI<T> {
    void enqueue(T data);

    T dequeue();

    T peek();

    void print();
}
