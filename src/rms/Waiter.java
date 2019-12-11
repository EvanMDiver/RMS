package rms;

import java.util.HashMap;

public class Waiter {
    public HashMap<Integer, Table> tables = new HashMap<>();

    public Waiter() {
        tables = new HashMap<Integer, Table>();
        for (int i = 1; i < 10; i++){
            tables.put(i, new Table(i));
        }
    }

    public Table getTable(Integer tableID) {
        if (tables.containsKey(tableID)) {
            return tables.get(tableID);
        } else {
            return null;
        }
    }

}
