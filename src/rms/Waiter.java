package rms;

import java.util.Map;

public class Waiter {

    public Map<Integer, Table> tables;

    public Table getTable(Integer tableID) {
        if (tables.containsKey(tableID)) {
            return tables.get(tableID);
        } else {
            return null;
        }

    }
}
