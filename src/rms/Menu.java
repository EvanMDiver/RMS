package rms;

import java.util.HashMap;

public class Menu {

    private HashMap<Integer, FoodItem> items = new HashMap<>();

    public HashMap<Integer, FoodItem> getItems() {
        return items;
    }
    
    public FoodItem getItem(Integer itemID) {
        if (items.containsKey(itemID)) {
            return items.get(itemID);
        } else {
            return null;
        }
    }

    public void add(Integer id, FoodItem item) {
        items.put(id, item);
    }

}
