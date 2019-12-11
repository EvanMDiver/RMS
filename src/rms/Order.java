package rms;

import java.util.HashMap;
import java.util.Map;

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

    public void PrintOrder() {
        itemList.forEach((key, value) -> System.out.println(value + "x " + key));
        System.out.println("Total Price: $" + this.getPrice());
    }


    public void submitOrder(OrderDatabase db) {
        db.add(this);

    }

    public double getPrice() {
        double price = 0.0;
        for (Map.Entry<FoodItem, Integer> entry : itemList.entrySet()) {
            price += entry.getKey().price * entry.getValue();
        }
        return price;
    }

}
