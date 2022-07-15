
import java.util.Hashtable;
import java.util.Scanner;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author doant
 */
public class GetValidDataj {
    
    static Scanner sc = new Scanner(System.in);

    static int inputIntLimit(int min, int max, String inputMessage, String errorMessage) {
        while (true){
            System.out.print(inputMessage);
            try{
                int number = Integer.parseInt(sc.nextLine().trim());
                if (number < min || number > max) {
                    System.out.println(errorMessage);
                    continue;
                }
                return number;
            } catch (NumberFormatException e){
                System.out.println("You must enter an integer. Enter again.");
            }
        }
    }

    static String inputString(String inputMessage) {
        while(true){
            System.out.print(inputMessage);
            String ID = sc.nextLine().trim();
            if (!ID.isEmpty()){
                return ID;
            }
            System.out.println("Input cannot be empty. Enter again: ");
        }
    }

    static String inputStringID(Hashtable<String, Fruit> allFruits, String inputMessage, String errorMessage) {
        while(true){
            String ID = inputString(inputMessage);
            if (!allFruits.containsKey(ID)){
                return ID;
            }
            System.out.println(errorMessage);
        }
    }

    static double inputDouble(String inputMessage, String errorMessage) {
        while (true){
            System.out.println(inputMessage);
            try{
                double number = Double.parseDouble(sc.nextLine().trim());
                if (number <= 0) {
                    System.out.println(errorMessage);
                    continue;
                }
                return number;
            } catch (NumberFormatException e){
                System.out.println("You must enter a number. Enter again.");
            }
        }
    }

    static int inputInt(String inputMessage, String errorMessage) {
        while (true){
            System.out.print(inputMessage);
            try{
                int number = Integer.parseInt(sc.nextLine().trim());
                if (number < 0) {
                    System.out.println(errorMessage);
                    continue;
                }
                return number;
            } catch (NumberFormatException e){
                System.out.println("You must enter a number. Enter again.");
            }
        }
    }
    static boolean inputYNChoice(String inputMessage){
        while (true){
            System.out.print(inputMessage);
            String result = sc.nextLine().trim();
            if (result.isEmpty()){
                System.out.println("Input cannot be empty. Enter again: ");
                continue;
            }
            if (result.equalsIgnoreCase("Y")){
                return true;
            }
            else if (result.equalsIgnoreCase("N")){
                return false;
            }
            System.out.println("Your choice must be \"Y\" or \"N\"");
        }
    }

    // hàm này sẽ có đặc biệt vì có thể người dùng không muốn mua sau khi thấy số lượng không đủ.
    static int inputQuantityForBuying(int currentQuantity) {
        while (true){
            System.out.print("Please input quantity: ");
            int quantityWantToBuy = inputInt("", "Quantity must greater than 0.");
            if (quantityWantToBuy > currentQuantity) {
                System.out.println("This item don't have enough quantity you want. The maximum number of this is " 
                        + currentQuantity + "Do you want to enter new quantity you want? (Y/N)" );
                if (inputYNChoice("")) continue;
                else {
                    return -1;
                }
            }
            return quantityWantToBuy;
        }
    }
}
