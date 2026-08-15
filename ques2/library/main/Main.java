package library.main;
import library.model.*;
import library.utility.InputValidator;

public class Main{

    public static void main(String[] args){

        LibraryResource[] resources= new LibraryResource[5];

        resources[0] = new Book(1, "Java Programming", "James Gosling");
        resources[1] = new DigitalResource(2, "Machine Learning Basics", "Tom Mitchell");
        resources[2] = new Book(3, "Data Structures", "Mark Allen");
        resources[3] = new DigitalResource(4, "Artificial Intelligence", "Stuart Russell");
        resources[4] = new Book(5, "Operating Systems", "Abraham Silberschatz");

        LibraryResource.displayLibraryName();

        double totalFine = 0;

        for (LibraryResource resource : resources) {

            resource.displayDetails();

            System.out.println("Fine for 3 days: " + resource.calculateFine(3));

            totalFine += resource.calculateFine(3);
        }
        System.out.println("Total Fine: ₹" + totalFine);
    }
}