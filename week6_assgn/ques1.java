public class Main{
    public static void main(String[] arg){
        try{
            int a=10;
            int b=0;
            int result=a/b;
            System.out.println(result);
        }
        catch(ArithmeticException e){
            System.out("cannot divide by zero");
        }
        try{
            String name=null;;
            System.out.println(name.length());
        }
        catch(NullPointerException e){
            System.out.println("string is null");
        }
        try{
            int[] numbers={10,20,30};
            System.out.println(numbers[5]);
        }
        catch(ArrayIndexOutOfBoundsException e){
            System.out.println("invalid aray index");
        }
        try{
            String value="ac";
            int number=Integer.parseInt(value);
            System.out.println(number);
        }
        catch(NumberFormatException e){
            System.out.println("cannot convert string to number");
        }
    }
}