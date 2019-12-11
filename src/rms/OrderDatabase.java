package rms;

import java.util.ArrayList;

public class OrderDatabase {

    public ArrayList<Order> orderList = new ArrayList<>();

    public void add(Order order) {
        orderList.add(order);
        queueOrder(order);
    }

    public void queueOrder(Order order) {
        order.PrintOrder();
    }
}
