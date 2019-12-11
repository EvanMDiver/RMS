package rms;

import java.util.HashMap;
import java.util.Map;

public class Menu {

    public HashMap<Integer, FoodItem> items;

    public FoodItem getItem(Integer itemID) {
        if (items.containsKey(itemID)) {
            return items.get(itemID);
        } else {
            return null;
        }
    }

    public Menu() {
        this.items = new HashMap<>();
        for (int i = 0; i < 10; i++) {
            this.items.put(i, new FoodItem("Item " + i));
        }
    }
}
