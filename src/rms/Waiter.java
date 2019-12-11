package rms;

import java.util.HashMap;
import java.util.Map;

public class Waiter {


    public Waiter() {
        tables = new HashMap<Integer, Table>();
        for (int i = 1; i < 10; i++){
            tables.put(i, new Table());
        }
    }

    public HashMap<Integer, Table> tables;

    public Table getTable(Integer tableID) {
        if (tables.containsKey(tableID)) {
            return tables.get(tableID);
        } else {
            return null;
        }

    }
}
