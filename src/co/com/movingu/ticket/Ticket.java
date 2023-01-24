package co.com.movingu.ticket;

import java.time.LocalDate;

//TODO: Complete/Rewrite the class according to the requirements
public class Ticket {

    private String ticketId;
    private Status status;
    private LocalDate dateOfBorrow;

    public Ticket(String ticketId, Status status){
        this.status = status;
        this.ticketId = "T-0"+ticketId;
        this.dateOfBorrow = LocalDate.now();
    }

    public String getTicketId() {
        return this.ticketId;
    }

    public Status getStatus() {
        return this.status;
    }

    public LocalDate getDateOfBorrow() {
        return dateOfBorrow;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    //TODO: Add the necessary getters & setters u other extra function

    public enum Status{
        Ok,
        Pending,
        Active
    }
}
