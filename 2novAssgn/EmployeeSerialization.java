
import java.io.*;

class Employee implements Serializable {

    private static final long serialVersionUID = 1L;

    int empId;
    String name;
    String department;
    double salary;

    Employee(int empId, String name, String department, double salary) {
        this.empId = empId;
        this.name = name;
        this.department = department;
        this.salary = salary;
    }

    void display() {
        System.out.println("Employee ID: " + empId);
        System.out.println("Name: " + name);
        System.out.println("Department: " + department);
        System.out.println("Salary: " + salary);
    }
}

public class EmployeeSerialization {

    public static void main(String[] args) {

        try {
            Employee e1 = new Employee(101, "Krishna", "CSE", 50000);
            Employee e2 = new Employee(102, "Rahul", "IT", 60000);
            Employee e3 = new Employee(103, "Aman", "ECE", 55000);

            ObjectOutputStream oos = new ObjectOutputStream(
                new FileOutputStream("employees.dat")
            );

            oos.writeObject(e1);
            oos.writeObject(e2);
            oos.writeObject(e3);

            oos.close();

            System.out.println("Employees serialized successfully!");

        } catch (IOException e) {
            System.out.println("Serialization error: " + e.getMessage());
        }

        try {
            ObjectInputStream ois = new ObjectInputStream(
                new FileInputStream("employees.dat")
            );

            System.out.println("\nEmployee Records:");

            Employee e;

            for (int i = 0; i < 3; i++) {
                e = (Employee) ois.readObject();
                e.display();
            }

            ois.close();

        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Deserialization error: " + e.getMessage());
        }
    }
}
