package co.com.movingu.ticket;

import java.time.LocalDateTime;
import java.util.Date;

//TO DO: Complete/Rewrite the class according to the requirements
public class Ticket implements Payable{
    protected static int code;
    protected LocalDateTime startTime;
    protected LocalDateTime endTime;
    protected boolean payed;
    protected boolean helmet = true;
    protected int totalPayment;

    public Ticket() {
        this.startTime = LocalDateTime.now();
        this.payed = false;
        code ++;
    }

    public void  displayTicket(){
        System.out.println("Ticket code: T-" + code);
        System.out.println("Creationt Date: " + startTime);
        System.out.println("Paymet status: " + payed);
        System.out.println("Helmet status: " + helmet);
    }

    public int getCode() {
        return code;
    }

    public int getTotalPayment() {
        return totalPayment;
    }

    public void setTotalPayment(int totalPayment) {
        this.totalPayment += totalPayment;
    }

    public void setEndTime(LocalDateTime endTime) {
        this.endTime = endTime;
    }

    @Override
    public void updateStatusPayment(boolean value) {
        this.payed = value;
    }

    //TO DO: Add the necessary getters & setters u other extra function
}
