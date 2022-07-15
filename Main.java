
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
public class Main {
    public static void main(String[] args) {
        Hashtable<String, Fruit> listAllFruits = new Hashtable<>();
        ArrayList<Order> listOrders = new ArrayList<>();
        listAllFruits.put("11", new Fruit("11","banana",2,10,"VN"));
        listAllFruits.put("12", new Fruit("12","coconut",4,11,"ThaiLan"));
        listAllFruits.put("13", new Fruit("13","quyda",5,23,"Indo"));
        Hashtable<String, Fruit> ht = new Hashtable<>();
        ht.put("11", new Fruit("11","banana",2,10,"VN"));
        ht.put("12", new Fruit("12","coconut",3,11,"ThaiLan"));

        listOrders.add(new Order("Thinh Vo", ht));
        listOrders.add(new Order("Duc anh", ht));
        
        ShopManagement manager = new ShopManagement();
        while (true){
            int choice = manager.getMenuChoiceOption();
            switch (choice){
                case 1: 
//                    manager.createFruit(listAllFruits);
                    manager.displayAllFruits(listAllFruits);
//                    return;
                    break;
                case 2:
                    manager.viewOrders(listOrders);
                    break;
                case 3: 
                    manager.shopping(listAllFruits, listOrders);
                    break;
                case 4:
                    System.exit(0);
            }
        }
    }
}
/*
- Fruit được lưu trong Hashtable với key của Hashtable này trùng với ID của Fruit đó.
- Các Order được lưu trong 1 ArrayList, Mỗi Order chứa thông tin custormerName và 
ListFruit (ListFruit là một Hashtable, số lượng Quantity của order đó được lưu vào chính Fruit của Hashtable đó.. 
*/

// BUG: Nhập số lượng lớn hơn cái đang có thì chưa làm gì cả 
