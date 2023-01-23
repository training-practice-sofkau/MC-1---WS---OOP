package co.com.movingu.ticket;

//TO DO: Complete/Rewrite the class according to the requirements
public class Ticket {

    private String ticketId;
    private Status status;
    //TO DO: Add the necessary getters & setters u other extra function

    public enum Status{
        Ok,
        Pending,
        Active
    }
}
