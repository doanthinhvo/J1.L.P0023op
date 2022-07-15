
import java.util.Hashtable;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author doant
 */
class Order {
    private String custormerName;
    private Hashtable<String, Fruit> listItems = new Hashtable<>();

    public Order() {
        listItems = new Hashtable<>();
    }

    public Order(String custormerName, Hashtable<String, Fruit> listItems) {
        this.custormerName = custormerName;
        this.listItems = listItems;
    }
    

    public String getCustormerName() {
        return custormerName;
    }

    public Hashtable<String, Fruit> getListItems() {
        return listItems;
    }

    public void setListItems(Hashtable<String, Fruit> listItems) {
        this.listItems = listItems;
    }

    public void setCustormerName(String custormerName) {
        this.custormerName = custormerName;
    }
}
