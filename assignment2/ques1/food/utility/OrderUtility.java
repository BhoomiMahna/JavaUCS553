package food.utility;
import food.model.FoodOrder;


public class OrderUtility {

    public static boolean validateAmount(double amount){
        return amount > 0;
    }

    public static boolean validateCustomerName(String name){
        return name != null && name.length() > 0;
    }

    public static void generateSummary(FoodOrder order){
        System.out.println("------------------");
        order.displayDetails();
        System.out.println(
            "Delivery Charge : "
            + order.calculateDeliveryCharge()
        );
        System.out.println("------------------");

    }

}