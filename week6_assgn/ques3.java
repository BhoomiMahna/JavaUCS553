import java.util.Scanner;
import java.util.InputMismatchException;

public class Calculator{
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        try{
            System.out.println("enter number one");
            double n1=sc.nextDouble();
            System.out.println("enter number two");
            double n2=sc.nextDouble();
            System.out.println("enter operation to be performed");
            char op=sc.next().charAt(0);

            double ans;
            switch(op){
                case '+':
                    ans=n1+n2;
                    break;
                case '-':
                    ans=n1-n2;
                    break;
                case '*':
                    ans=n1*n2;
                    break;
                case '/':
                    if(n2==0){
                        throw new ArithmeticException("divided by zero");
                    }
                    ans=n1/n2;
                    break;
                default:
                    throw new IllegalArgumentException("invalid operator");
            }
            System.out.println("ans is: "+ ans);
        }
        catch(InputMismatchException e){
            System.out.println("invalid numeric input");
        }
        catch (ArithmeticException e) {
            System.out.println("division by zero is not allowed.");

        } 
        catch (IllegalArgumentException e) {
            System.out.println("invalid operator. Use +, -, * or /.");
        }
        finally{
            sc.close();
        }
    }
}