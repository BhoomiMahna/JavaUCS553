import java.util.ArrayList;

class Main{
    public static void Main(String args[]){
        ArrayList<Student>students=new ArrayList<>();

        Student s1 = new Student(1, "Bhoomi");
        Student s2 = new Student(2, "Krishna");
        Student s3 = new Student(3, "Kiran");
        Student s4 = new Student(4, "Navya");

        students.add(s1);
        students.add(s2);
        students.add(s3);

        Course java=new Course("java programming");
        try{
            s1.addmarks(500);
            Student result=Student.findresult(students,5);
            result.display();

            java.enroll(s1);
            java.enroll(s2);
            java.enroll(s3);
            java.enroll(s4);
        }
        catch(InvalidMarksException e){
            System.out.println("marks error: "+e.getMessage());
        }
        catch(StudentNotFoundException e){
            System.out.println("no studetn errror: "+e.getMessage());
        }
        catch(CourseFullException e){
            System.out.println("course full errror: "+e.getMessage());
        }
        finally{
            System.out.println("all updated");
        }
    }
}