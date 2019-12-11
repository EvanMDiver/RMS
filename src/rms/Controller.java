package rms;

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
}
