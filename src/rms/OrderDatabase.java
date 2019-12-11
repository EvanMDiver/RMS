package rms;

import java.util.ArrayList;

public class OrderDatabase {

    public ArrayList<Order> orderList = new ArrayList<>();

    public void add(Order order) {
        orderList.add(order);
    }

    public void queueOrder(Order order) {
        //send orderlist to cook
    }
}
