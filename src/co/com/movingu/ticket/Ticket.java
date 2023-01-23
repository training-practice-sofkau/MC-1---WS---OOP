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
        this.startTime=LocalDateTime.now();
    }

    public Ticket() {
    }

    //TO DO: Add the necessary getters & setters u other extra function


    public int getIdSecuence() {
        return idSecuence;
    }

    public void setIdSecuence(int idSecuence) {
        this.idSecuence = idSecuence;
    }

    public String getCode() {
        return code;
    }

    public void setCode() {
        this.code = "T-"+(idSecuence);
        this.idSecuence++;
    }

    public LocalDateTime getStartTime() {
        return startTime;
    }

    public void setStartTime(LocalDateTime startTime) {
        this.startTime = startTime;
    }

    public LocalDateTime getEndTime() {
        return endTime;
    }

    public void setEndTime(LocalDateTime endTime) {
        this.endTime = endTime;
    }

    public boolean isHelmetSupplied() {
        return helmetSupplied;
    }

    public void setHelmetSupplied(boolean helmetSupplied) {
        this.helmetSupplied = helmetSupplied;
    }

    public String getTicketStatus() {
        return ticketStatus;
    }

    public void setTicketStatus(String ticketStatus) {
        this.ticketStatus = ticketStatus;
    }

    public double getAmountToPay() {
        return amountToPay;
    }

    public void setAmountToPay(double amountToPay) {
        this.amountToPay = amountToPay;
    }

    public User getuTicket() {
        return uTicket;
    }

    public void setuTicket(User uTicket) {
        this.uTicket = uTicket;
    }

    public Vehicle getvTicket() {
        return vTicket;
    }

    public void setvTicket(Vehicle vTicket) {
        this.vTicket = vTicket;
    }
}
