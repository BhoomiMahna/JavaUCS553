package food.model;

public abstract class FoodOrder{
    private int orderId;
    private string customerName;
    private double amount;

    static String restaurantName="Food Palace";

    public FoodOrder(int orderId, String customerName, double amount){
        this.orderId=orderId;
        this.customerName=customerName;
        this.amount=amount;
    }

    public int getOrderId(){
        return orderId;
    }

    public double getAmount(){
        return amount;
    }

    public String getCustomerName(){
        return customerName;
    }

    public void setAmount(double amount){
        this.amount=amount;
    }

    public abstract double calculateDeliveryCharge();

    public static void displayRestaurant(){
        System.out.println("Restaurant: "+ restaurantName);
    }

    public void displayDetails(){
        System.out.println("Order ID : " + orderId);
        System.out.println("Customer : " + customerName);
        System.out.println("Amount : " + amount);
    }
}