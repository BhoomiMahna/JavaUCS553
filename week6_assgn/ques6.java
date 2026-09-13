import java.util.Scanner;
class InvalidUsernameException extends Exception{
    InvalidUsernameException(String msg){
        super(msg);
    }
}
class InvalidPasswordException extends Exception{
    InvalidPasswordException(String msg){
        super(msg);
    }
}
class AccountLockedException extends Exception{
    AccountLockedException(String msg){
        super(msg);
    }
}
public class Main{

    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        int attempts=3;
        boolean loggedin=false;
        try{
            while(attempts>0){
                try{
                    String username=sc.next();
                    if(!username.equals("bhoomi")){
                        throw new InvalidUsernameException("username doesnot exists");
                    }
                    String password=sc.next();
                    if(!password.equals("1234")){
                        throw new InvalidPasswordException("incorrect password");
                    }
                    System.out.println("login successful");
                    loggedin=true;
                    break;
                }
                catch(InvalidUsernameException e){
                    System.out.println(e.getMessage());
                    attempts--;
                }
                catch(InvalidPasswordException e){
                    System.out.println(e.getMessage());
                    attempts--;
                }
            }
            if(!loggedin && attempts==0){
                throw new AccountLockedException("account locked!");
            }
        }
        catch(AccountLockedException e){
            System.out.println(e.getMessage());
        }
        finally{
            sc.close();
        }
        
    }
}