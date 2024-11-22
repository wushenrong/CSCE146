/*
 * Samuel Wu
 * 2024-11-16
 */

package labs.lab08;

public class OrderScheduler {
    private MinHeap<Order> orders;
    private Order currentOrder;
    private int currentMinute;
    private int totalOrders;
    private int totalWaitingTime;

    public OrderScheduler() {
        orders = new MinHeap<>();
        currentOrder = null;
        currentMinute = 0;
        totalOrders = 0;
        totalWaitingTime = 0;
    }

    /**
     * Return the current order that we are preparing.
     */
    public Order getCurrentOrder() {
        return currentOrder;
    }

    /**
     * Add an order by increment the number of orders we have added and if the
     * current order is null, make the order as the current order to prepare.
     * Else add the order to the orders heap that is heapified by shortest time
     * to cook.
     */
    public void addOrder(Order data) {
        if (data == null) {
            return;
        }

        totalOrders++;

        if (currentOrder == null) {
            currentOrder = data;
            return;
        }

        orders.add(data);
    }

    /**
     * Advance time by incrementing the current time by one minute and cook the
     * the current order by one minute. If the current order is done cooking,
     * calculate how long to prepare the order and prepare the next order.
     */
    public void advanceOneMinute() {
        currentMinute++;
        currentOrder.cookForOneMinute();

        if (currentOrder.isDone()) {
            totalWaitingTime += currentMinute - currentOrder.getArrivalTime();
            currentOrder = orders.remove();
        }
    }

    /**
     * Checking if we are done cooking by checking if the current order is null.
     */
    public boolean isDone() {
        return currentOrder == null;
    }

    /**
     * Calculate the average time to prepare every order by dividing the total
     * prepare time of all orders by the number of orders given. Casting the
     * total prepare time to do double division and returning a double.
     */
    public double getAverageWaitingTime() {
        return (double) totalWaitingTime / totalOrders;
    }
}
