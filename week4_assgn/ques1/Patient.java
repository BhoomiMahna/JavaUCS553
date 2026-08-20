class Patient{
    int patientId;
    String name;
    int age;
    String disease;

    Patient(int patientId, String name, int age, String disease) throws InvalidAgeException{
        if(age<=0 || age>120){
            throw new InvalidAgeException(
                "invalid age: "+age
            );
        }
        this.patientId=patientId;
        this.name=name;
        this.age=age;
        this.disease=disease;
    }
    static Patient findPatient(Patient[] patients, int id) throws PatientNotFoundException{
        for(Patient p:patients){
            if(p!=null && p.patientId==id){
                return p;
            }
        }
        throw new PatientNotFoundException("patient with id "+id+" not found");
    }
    void display(){
        System.out.println(
            patientId+" "+name+" "+age+" "+disease
        );
    }
}