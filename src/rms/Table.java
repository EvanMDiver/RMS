package rms;

public class Table {

    public Integer ID;
    public Order currOrder = new Order();

    public Table(Integer id) {
        ID = id;
    }
    public void makeOrder() {
        Order currorder = new Order();
        currorder.initialize();
    }

    public void submitOrder(OrderDatabase db) {
        currOrder.status = "cooking";
        currOrder.submitOrder(db);
    }

    public void addItem(FoodItem item, Integer quantity) {
        currOrder.addItem(item, quantity);
    }
}
