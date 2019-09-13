package assignment_6;

/**
 * Created by Draic0 on 12.09.2019.
 */
public class Item {

    private String name;
    private int weight, value, quantity;

    public Item(String name, int weight, int value, int quantity){
        this.name = name;
        this.weight = weight;
        this.value = value;
        this.quantity = quantity;
    }

    public String getName(){
        return name;
    }
    public int getWeight(){
        return weight;
    }
    public int getValue(){
        return value;
    }
    public int getQuantity(){
        return quantity;
    }

    @Override
    public String toString(){
        return name + " - вес: "+weight+" стоимость: "+value;
    }
}
