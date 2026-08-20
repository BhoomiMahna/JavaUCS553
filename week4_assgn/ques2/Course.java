import java.util.ArrayList;

class Course{
    String coursename;
    ArrayList<Student> students=new ArrayList<>();
    int maxstudent=3;

    public Course(String course){
        this.coursename=course;
    }

    public void enroll(Student s){
        if(students.size()>=maxstudent){
            throw new CourseFullException("course limit reached");
        }
        students.add(s);
        System.out.println(s.name+" enrolled in "+coursename);
    }
}