public class Main{
    public static void main(String[] args){
        try{
            Patient p1=new Patient(101,"johnson",30,"fever");
            Patient p2=new Patient(102,"arabiata",150,"stomach ache");

            System.out.println("patients registered");
        }
        catch(InvalidAgeException e){
            System.out.println("error is:"+ e.getMessage());
        }
        try{
            int totalcost=5000;
            int days=0;
            int costperday=totalcost/days;
        }
        catch(ArithmeticException e){
            System.out.println("cant divide by zero");
        }
        try{
            int[] rooms={101,102,103};
            System.out.println(rooms[5]);
        }
        catch(ArrayIndexOutOfBoundsException e){
            System.out.println(
                "invalid room index";
            );
        }
        try{
            Patient patient=null;
            System.out.println(patient.name);
        }
        catch(NullPointerException e){
            System.out.println("patient record is null");
        }
    }
}