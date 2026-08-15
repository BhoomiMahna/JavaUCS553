package food.main;
import food.model.*;
import food.utility.OrderUtility;

public class Main {

public static void main(String args[]){

FoodOrder orders[] = new FoodOrder[6];

orders[0] = new RegularOrder(1,"Krishna",1000);
orders[1] = new PremiumOrder(2,"Bhoomi",2000);
orders[2] = new RegularOrder(3,"Aman",1500);
orders[3] = new PremiumOrder(4,"Riya",3000);
orders[4] = new RegularOrder(5,"John",800);
orders[5] = new PremiumOrder(6,"Alex",2500);

FoodOrder.displayRestaurant();

for(FoodOrder order: orders){
    OrderUtility.generateSummary(order);
    double discount=0;
    if(order instanceof RegularOrder){
        discount = order.getAmount()*0.10;
    }
    else if(order instanceof PremiumOrder){
        discount = order.getAmount()*0.15;
    }

    double finalAmount =order.getAmount() - discount + order.calculateDeliveryCharge();

    System.out.println("Discount : "+discount);
    System.out.println("Final Payable Amount : "+finalAmount);

}

}

}