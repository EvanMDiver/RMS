package rms;

import java.util.HashMap;

public class Order {

	public HashMap<FoodItem, Integer> itemList = new HashMap<>();
	public String status;

	public void initialize() {
		this.status = "ordering";
    }

	public void addItem(FoodItem item, Integer quantity) {
		if (itemList.containsKey(item)) {
			itemList.put(item, itemList.get(item) + quantity);
		} else {
			itemList.put(item, quantity);
		}
	}

	public void submitOrder(OrderDatabase db) {
		db.add(this);
    }

}
