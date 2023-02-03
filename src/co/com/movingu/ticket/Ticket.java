package co.com.movingu.ticket;

import co.com.movingu.user.User;
import co.com.movingu.vehicle.Vehicle;

import java.time.LocalDateTime;

//TO DO: Complete/Rewrite the class according to the requirements
public class Ticket implements Upgradeable {

    private int idSecuence=1;

    private String code;

    private LocalDateTime startTime;

    private LocalDateTime endTime;

    private boolean helmetSupplied;

    private String ticketStatus;

    private int rentHours;

    private char vehicleType;

    private double amountToPay;

    private User uTicket;

    private Vehicle vTicket;

    public Ticket(String code,char vehicleType, LocalDateTime startTime, User uTicket, Vehicle vTicket,int hours) {
        this.code = code;
        this.vehicleType=vehicleType;
        this.startTime = startTime;
        this.ticketStatus = "Active";
        this.uTicket = uTicket;
        this.vTicket = vTicket;
        this.rentHours=hours;
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

    public char getVehicleType() {
        return vehicleType;
    }

    public void setVehicleType(char vehicleType) {
        this.vehicleType = vehicleType;
    }

    public int getRentHours() {
        return rentHours;
    }

    public void setRentHours(int rentHours) {
        this.rentHours = rentHours;
    }

    @Override
    public void updateState(String state) {
        this.ticketStatus = state;
    }
}
