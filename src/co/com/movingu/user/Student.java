package co.com.movingu.user;

//TO DO: Complete/Rewrite the class according to the requirements
public class Student extends User{
    private String collegeDNI;
    private String faculty;


    public Student(String dni, String name, int age, String collegeDNI, String faculty) {
        super(dni, name, age);
        this.collegeDNI = collegeDNI;
        this.faculty = faculty;
    }

    @Override
    public void statusMsg() {
        if(blocked && !ticketOn){
            System.out.println("The student "+name+"is blocked bc of debt");
        }else{
            System.out.println("The student "+name+"is blocked bc he/she already borrow a vehicle");
        }
    }

    @Override
    public String toString() {
        return "Student{" +
                "collegeDNI='" + collegeDNI + '\'' +
                ", faculty='" + faculty + '\'' +
                ", dni='" + dni + '\'' +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", blocked=" + blocked +
                ", ticketOn=" + ticketOn +
                '}';
    }
}
