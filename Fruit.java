
import java.text.DecimalFormat;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author doant
 */
class Fruit {
    private String fruitID;
    private String fruitName;
    private double price;
    private int quantity;
    private String origin;

    public Fruit() {
    }

    public Fruit(String fruitID, String fruitName, double price, int quantity, String origin) {
        this.fruitID = fruitID;
        this.fruitName = fruitName;
        this.price = price;
        this.quantity = quantity;
        this.origin = origin;
    }

    public String getFruitID() {
        return fruitID;
    }

    public String getFruitName() {
        return fruitName;
    }

    public String getOrigin() {
        return origin;
    }

    public int getQuantity() {
        return quantity;
    }

    public double getPrice() {
        return price;
    }

    public void setFruitID(String fruitID) {
        this.fruitID = fruitID;
    }

    public void setFruitName(String fruitName) {
        this.fruitName = fruitName;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String display(int order) {
        DecimalFormat df = new DecimalFormat("0.#");
        return String.format("%7s%-9s%-19s%-17s%s$\n","", order, this.fruitName, this.origin, df.format(this.price));
                
    }
    
}
