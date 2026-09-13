import java.util.Scanner;

class ApplicationException extends Exception{
    ApplicationException(String msg){
        super(msg);
    }
}
class ProductException extends ApplicationException{
    ProductException(String msg){
        super(msg);
    }
}
class ProductNotFoundException extends ProductException{
    ProductNotFoundException(String msg){
        super(msg);
    }
}
class OutOfStockException extends ProductException{
    OutOfStockException(String msg){
        super(msg);
    }
}
class PaymentException extends ApplicationException{
    PaymentException(String msg){
        super(msg);
    }
}
class InvalidPaymentException extends PaymentException{
    InvalidPaymentException(String msg){
        super(msg);
    }
}
class InsufficientFundsException extends PaymentException{
    InsufficientFundsException(String msg){
        super(msg);
    }
}
class OrderException extends ApplicationException{
    OrderException(String msg){
        super(msg);
    }
}
class EmptyCartException extends OrderException{
    EmptyCartException(String msg){
        super(msg);
    }
}

public class Main{
    static String[] products={"lipstick","foundation","blush","mascara"};
    static int[] stock={5,3,4,6};
    static double[] prices={799,1299,699,899};
    static int[] cart={0,0,0,0};

    static void add(String name, int quantity) throws ProductNotFoundException, OutOfStockException{
        int idx=-1;
        for(int i=0;i<products.length;i++){
            if(products[i].equals(name)){
                idx=i;
                break;
            }
        }
        if(idx==-1){
            throw new ProductNotFoundException("product not found");
        }
        if(quantity>stock[idx]){
            throw new OutOfStockException("not enough stock");
        }
        cart[idx]+=quantity;
        stock[idx]-=quantity;
    }
    static void remove(String name,int quantity) throws ProductNotFoundException,EmptyCartException{
        int index = -1;

        for (int i = 0; i < products.length; i++) {
            if (products[i].equalsIgnoreCase(name)) {
                index = i;
                break;
            }
        }
        if (index == -1) {
            throw new ProductNotFoundException("Makeup product not found!");
        }
        if (cart[index] == 0) {
            throw new EmptyCartException("This product is not in the cart!");
        }
        if (quantity > cart[index]) {
            throw new EmptyCartException("Not enough quantity in cart");
        }
        cart[index] -= quantity;
        stock[index] += quantity;

    }
    static void payment(String methods,double funds) throws EmptyCartException, InvalidPaymentException, InsufficientFundsException{
        double total = 0;
        for (int i = 0; i < products.length; i++) {
            total += cart[i] * price[i];
        }
        if (total == 0) {
            throw new EmptyCartException("Cannot make payment. Cart is empty!");
        }
        if (!method.equals("card")) {
            throw new InvalidPaymentException("Invalid payment method. Please use card.");
        }
        if (funds < total) {
            throw new InsufficientFundsException("Insufficient funds!");
        }

        System.out.println("Total amount paid: Rs. " + total);
        for (int i = 0; i < products.length; i++) {
            cart[i] = 0;
        }
    }
    static void search(String name) throws ProductException{
        for(int i=0;i<products.length;i++){
            if(products[i].equals(name)){
                System.out.println("Product found!");
                System.out.println("Product: " + products[i]);
                System.out.println("Price: Rs. " + price[i]);
                System.out.println("Stock: " + stock[i]);

                return;
            }
        }
        throw new ProductNotFoundException("product not found");
    }
    static void displayCart()
            throws EmptyCartException {

        boolean empty = true;

        System.out.println("\n----- YOUR MAKEUP CART -----");

        for (int i = 0; i < products.length; i++) {

            if (cart[i] > 0) {

                empty = false;

                double itemTotal =
                    cart[i] * price[i];

                System.out.println(
                    products[i] +
                    " x " +
                    cart[i] +
                    " = Rs. " +
                    itemTotal
                );
            }
        }

        if (empty) {
            throw new EmptyCartException(
                "Your makeup cart is empty!"
            );
        }
    }
    public static void main(String arg){
        Scanner sc=new Scanner(System.in);
        while(true){
            System.out.println("1. Search Product");
            System.out.println("2. Add Product");
            System.out.println("3. Remove Product");
            System.out.println("4. Display Cart");
            System.out.println("5. Payment");
            System.out.println("6. Exit");

            System.out.print("Enter your choice: ");

            int choice = sc.nextInt();
            try{
                if(choice==1){
                    System.out.println("enter product name");
                    String name=sc.next();
                    search(name);
                }
                else if(choice==2){
                    System.out.print("Enter makeup product name: ");
                    String name = sc.next();

                    System.out.print("Enter quantity: ");
                    int quantity = sc.nextInt();
                    add(name, quantity);
                }
                else if(choice==3){
                    System.out.println("enter product name");
                    String name=sc.next();
                    System.out.println("enter quantity");
                    int quantity=sc.nextInt();
                    remove(name,quantity);
                }
                else if(choice==4){
                    DisplayCart();
                }
                else if(choice==5){
                    System.out.println("enter payment method");
                    String method=sc.next();
                    System.out.println("enter available funds");
                    double funds=sc.nextDouble();
                    payment(method,funds);
                }
                else if(choice==6){
                    System.out.println("thanks fro shopping");
                    break;
                }
                else{
                    System.out.println("invalid choice");
                }
            }
        
            catch (ProductException e){
                System.out.println(e.getMessage());
            }
            catch (PaymentException e){
                System.out.println(e.getMessage());
            }
            catch (OrderException e){
                System.out.println(e.getMessage());
            }
        }
        sc.close();
    }
}