import java.util.ArrayList;

class Student{
    int id;
    String name;
    int marks;

    public Student(int id, String name){
        this.id=id;
        this.name=name;
    }

    public void addmarks(int mark){
        throws InvalidMarksException{
            if(mark<0 || mark>100){
                throw new InvalidMarksException(
                    "marks out of range";
                );
            }
        }
        this.marks=mark;
    }
    
    public static Student findstudent(ArrayList<Student>students,int searchid) throws StudentNotFoundException{
        for(Student s : students){
            if(s.id==searchid)return s;
        }
        throw new StudentNotFoundException("student not found");
    }

    public void display(){
        System.out.println("id: "+id+" name: "+name+"marks: "+marks);
    }
}