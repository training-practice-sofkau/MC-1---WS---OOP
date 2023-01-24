package co.com.movingu.user;

import co.com.movingu.ticket.Ticket;

//TO DO: Complete/Rewrite the class according to the requirements
public class Student extends User implements financiable{
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
    public void financeDebt(Ticket ticket){
        ticket.cancelFee();
        System.out.println("The student has been financed by University");
    }
}
