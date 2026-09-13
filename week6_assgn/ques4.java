import java.util.Scanner;

class InvalidMarksException extends Exception{
    InvalidMarksException(String msg){
        super(msg);
    }
}
public class Main{
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);

        try{
            System.out.println("enter marks");
            double marks1=sc.nextDouble();
            double marks2=sc.nextDouble();
            double marks3=sc.nextDouble();
            if(marks1>100 || marks1<0 || marks2>100 || marks2<0 ||marks3>100 || marks3<0){
                throw new InvalidMarksException("invalid marks are entered");
            }
        }
        double total=marks1+marks2+marks3;
        double percentage=(total/300)*100;
        System.out.println("total marks are "+total+" and percentage is "+percentage);
        if (percentage >= 90) {
            System.out.println("Grade: A");
        }
        else if (percentage >= 80) {
            System.out.println("Grade: B");
        }
        else if (percentage >= 70) {
            System.out.println("Grade: C");
        }
        else if (percentage >= 60) {
            System.out.println("Grade: D");
        }
        else {
            System.out.println("Grade: F");
        }
        catch(InvalidMarksException e){
            System.out.println(e.getMessage());
        }
        finally{
            sc.close();
        }
    }
}
