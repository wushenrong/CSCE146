/*
 * Samuel Wu
 * 2024-10-08
 */

package labs.lab05;

public interface QueueI<T> {
    public void enqueue(T data);

    public T dequeue();

    public T peek();

    public void print();
}
