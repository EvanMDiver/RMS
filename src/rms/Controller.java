package rms;

import javafx.util.Pair;

import java.util.ArrayList;

public class Controller {

    public Table currTable;
    public Waiter currWaiter = new Waiter();
    public Menu menu = new Menu();
    private OrderDatabase db = new OrderDatabase();
	
	
    public void selectTable(Integer tableID) {
        currTable = currWaiter.getTable(tableID);
    }

    public void selectItem(Integer itemID, Integer quantity) {
        FoodItem item = menu.getItem(itemID);
        currTable.addItem(item, quantity);
    }

    public void submitOrder() {
        currTable.submitOrder(db);
    }

    public Controller() {
        ArrayList<Pair<String, Double>> menuItems = new ArrayList<>();
        menuItems.add(new Pair<>("Burger", 5.00));
        menuItems.add(new Pair<>("Big Burger", 7.21));
        menuItems.add(new Pair<>("Fries", 0.70));
        menuItems.add(new Pair<>("Big Fries", 1.23));
        menuItems.add(new Pair<>("Soda", 1.50));
        menuItems.add(new Pair<>("Big Soda", 2.05));
        int id = 0;
        for (Pair<String, Double> item : menuItems) {
            menu.add(++id, new FoodItem(item.getKey(), item.getValue()));
        }
    }
}
