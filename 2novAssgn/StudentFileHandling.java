
import java.io.*;

public class StudentFileHandling {
    public static void main(String[] args) {

        try {
            FileInputStream fin = new FileInputStream("input.jpg");
            FileOutputStream fout = new FileOutputStream("copy.jpg");

            int data;

            while ((data = fin.read()) != -1) {
                fout.write(data);
            }

            fin.close();
            fout.close();

            System.out.println("Binary file copied successfully!");

        } catch (IOException e) {
            System.out.println("Error copying file: " + e.getMessage());
        }

        try {
            FileWriter fw = new FileWriter("students.txt");

            fw.write("101, Krishna, CSE, 85\n");
            fw.write("102, Rahul, ECE, 90\n");
            fw.write("103, Aman, CSE, 88\n");

            fw.close();

            System.out.println("Student records written successfully!");

        } catch (IOException e) {
            System.out.println("Error writing file: " + e.getMessage());
        }
        try {
            FileReader fr = new FileReader("students.txt");

            int ch;

            System.out.println("\nStudent Records:");

            while ((ch = fr.read()) != -1) {
                System.out.print((char) ch);
            }

            fr.close();

        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
        }
    }
}
