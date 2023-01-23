package co.com.movingu.ticket;

import co.com.movingu.user.User;
import co.com.movingu.vehicle.Vehicle;

import java.time.LocalDateTime;

//TO DO: Complete/Rewrite the class according to the requirements
public class Ticket {

    private int idSecuence=1;

    private String code;

    private LocalDateTime startTime;

    private LocalDateTime endTime;

    private boolean helmetSupplied;

    private String ticketStatus;

    private double amountToPay;

    private User uTicket;

    private Vehicle vTicket;

    public Ticket(boolean helmetSupplied, User uTicket, Vehicle vTicket) {
        this.helmetSupplied = helmetSupplied;
        this.uTicket = uTicket;
        this.vTicket = vTicket;
    }

    //TO DO: Add the necessary getters & setters u other extra function
}
