public class NestedTryCatch{
    public static void main(String[] args){
        try{
            System.out.println("outer try block");
            try{
                System.out.println("inner try block");
                int[] arr={10,20,30};
                System.out.println(arr[5]);
            }
            catch(ArrayIndexOutOfBoundsException e){
                System.out.println("inner catch, index out of bounds");
            }
            int ans=46/0;
            System.out.println(ans);
        }
        catch(ArithmeticException e){
            System.out.println("outer catch, division by zero error");
        }
        System.out.println("rest of the code");
    }
}