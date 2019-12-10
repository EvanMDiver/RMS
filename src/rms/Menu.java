package rms;

import java.util.Map;

public class Menu {

    private Map<Integer, FoodItem> items;

    public FoodItem getItem(Integer itemID) {
        if (items.containsKey(itemID)) {
            return items.get(itemID);
        } else {
            return null;
        }
    }

}
