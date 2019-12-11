package rms;

public class FoodItem {

    public enum StatusEnum {}
    private String name;

    public StatusEnum status;

    public FoodItem(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return   name ;
    }

    public FoodItem clone() {
        return new FoodItem(name);
    }
}
