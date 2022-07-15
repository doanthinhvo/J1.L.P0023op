
import java.util.ArrayList;
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
class ShopManagement {
    int getMenuChoiceOption() {
        System.out.println("FRUIT SHOP SYSTEM");
        System.out.println("    1. Create Fruit");
        System.out.println("    2. View Orders");
        System.out.println("    3. Shopping(for buyer)");
        System.out.println("    4. Exit");
        int choice = GetValidDataj.inputIntLimit(1, 4, "Enter your choice: ", 
                "You must choose a number in range (" + 1 + "," + 4 + ")");
        return choice;
    }

    void createFruit(Hashtable<String, Fruit> listAllFruits) {
        while (true){
            System.out.println("--- Add new fruit. ----");
            String ID = GetValidDataj.inputStringID(listAllFruits, "Enter Fruit ID: ", "ID is existed. Enter again. ");
            String fruitName = GetValidDataj.inputString("Enter Fruit Name: ");
            double price = GetValidDataj.inputDouble("Enter pricce.", "Price must greater than 0.");
            int quantity = GetValidDataj.inputInt("Enter quantity:" , "Quantity must >= 0.");
            String origin = GetValidDataj.inputString("Enter Origin: ");
            
            Fruit newFruit = new Fruit(ID, fruitName, price, quantity, origin);
            listAllFruits.put(ID, newFruit);
                
            System.out.println("Do you want to continue (Y/N)? User chooses Y to continues, "
                    + "if you chooses N, the program returns main screen "
                    + "and display all Fruits what are created.");
            if (!GetValidDataj.inputYNChoice("")){
                break;
            }
        }
        displayAllFruits(listAllFruits);
    }
    
    void displayAllFruits(Hashtable<String, Fruit> listAllFruits){
        System.out.println("List Of Fruits: ");
        System.out.println("| ++ Item ++ | ++ Fruit Name ++ | ++ Origin ++ | ++ Price ++ |");
        int count = 1;
        for (Fruit fruit : listAllFruits.values()) {
            System.out.print(fruit.display(count++));
        }
    }

    void viewOrders(ArrayList<Order> listOrders) {
        for (Order order : listOrders){
            displayOrder(order);
        }
    }
    
    void displayOrder(Order order){
        double total = 0;
        System.out.println("Custormer: " + order.getCustormerName());
        Hashtable<String, Fruit> allFruitsOfThisOrder = order.getListItems();
        System.out.printf("%-8s%11s%10s%8s\n", "Product |" , "Quantity |",  "Price |",  " Amount");
        int count = 1;
        for (Fruit fruit : allFruitsOfThisOrder.values()){
            System.out.printf("%-8s%11s%10s%8s$\n", count+" "+fruit.getFruitName(), 
                    fruit.getQuantity(), fruit.getPrice(), fruit.getPrice() * fruit.getQuantity());
            total += fruit.getPrice() * fruit.getQuantity();
        }
        System.out.println("Total: " + total + "$");
        System.out.println("");
        
    }
    
    void shopping(Hashtable<String, Fruit> listAllFruits, ArrayList<Order> listOrders) {
        Hashtable<String, Fruit> listItems = new Hashtable<>();
        while (true){
            displayAllFruits(listAllFruits);
            int choice = GetValidDataj.inputIntLimit(1, listAllFruits.size(), 
                    "Enter your choice: ", "You must choose a number in range (" + 1 + "," + listAllFruits.size() + ")");
            Fruit choosenFruit = getFruitByIndex(listAllFruits, choice);
            // check Item is out of stock
            if (choosenFruit.getQuantity() == 0){
                System.out.println("This fruit are out of stock.");
                continue;
            }
            System.out.println("You selected: " + choosenFruit.getFruitName());
            // phải có hàm check nếu như user thấy không đủ số lượng họ mong muốn thì không mua nữa.
            int quantityWantToBuy = GetValidDataj.inputQuantityForBuying(choosenFruit.getQuantity());
            
            // if user don't want to buy current item, ask user others items to buy. 
            if (quantityWantToBuy == -1) {
                continue;
            }
            
            // update new Order 
            listItems.put(choosenFruit.getFruitID(), new Fruit(choosenFruit.getFruitID(), 
                    choosenFruit.getFruitName(), choosenFruit.getPrice(), quantityWantToBuy, choosenFruit.getOrigin()));
            
            
            // update quantity for list all Fruits.
            choosenFruit.setQuantity(choosenFruit.getQuantity() - quantityWantToBuy);
            if (!GetValidDataj.inputYNChoice("Do you want to order now (Y/N): ")){
                break;
            }
        }
        displayListItemOfOrders(listItems);
        String custormerName = GetValidDataj.inputString("Input your name: ");
        listOrders.add(new Order(custormerName, listItems));
        System.out.println("---- DONE SHOPPPING ----");
    }
    
    Fruit getFruitByIndex(Hashtable<String, Fruit> listAllFruits, int index){
        int count = 1;
        for (Fruit fruit : listAllFruits.values()){
            if (count == index){
                return fruit;
            }
            count++;
        }
        return null;
    }

    private void displayListItemOfOrders(Hashtable<String, Fruit> listItems) {
        System.out.printf("%8s%15s%15s%8s\n" , "Product |", " Quantity |", " Price |",  "Amount");
        for (Fruit fruit : listItems.values()){
            System.out.printf("%8s%15s%15s%8s\n", fruit.getFruitName(), 
                    fruit.getQuantity(), fruit.getPrice(), fruit.getPrice() * fruit.getQuantity());
        }
    }
}
