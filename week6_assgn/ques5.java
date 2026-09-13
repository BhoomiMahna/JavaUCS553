import java.util.Scanner;
class InsufficientBalanceException extends Exception{
    InsufficientBalanceException(String msg){
        super(msg);
    }
}
class InvalidAmountException extends Exception{
    InvalidAmountException(String msg){
        super(msg);
    }
}
class AccountNotFoundException extends Exception{
    AccountNotFoundException(String msg){
        super(msg);
    }
}
public class Main{
    static void validateaccount(int acc) throws AccountNotFoundException{
        if(acc!=1234){
            throw new AccountNotFoundException("incorrect account number");
        }
    }
    static void validateamount(int acc) throws InvalidAmountException{
        if(amount<=0){
            throw new InvalidAmountException("amount must be positive");
        }
    }
    static void withdraw(int balance,int withdrawn) throws InsufficientBalanceException{
        if(withdrawn>balance){
            throw new InsufficientBalanceException("bank balance is low");
        }
    }
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        int balance=1000;
        try{
            System.out.println("enter account number");
            int acc=sc.nextInt();
            validateaccount(acc);    

            System.out.println("enter amount to be withdrawn");
            int withdrawn=sc.nextInt();
            validateamount(withdrawn);
            withdraw(balance,withdrawn);

            System.out.println("enter amount to be deposited");
            int deposit=sc.nextInt();
            validateamount(deposit);

            balance-=withdrawn;
            balance+=deposit;
            System.out.println("current balance is "+balance);
        }
        catch (AccountNotFoundException e){
            System.out.println(e.getMessage());
        }
        catch(InsufficientBalanceException e){
            System.out.println(e.getMessage());
        }
        catch(InvalidAmountException e){
            System.out.println(e.getMessage());
        }
        finally{
            sc.close();
        }
    }
}