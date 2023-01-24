package co.com.movingu.ticket;

import java.time.LocalDateTime;

public class Ticket implements IPayable {

    private String ticketId;
    private Status status;
    private String usrID;
    private String vehicleId;
    private LocalDateTime dateOfBorrow;

    private double debt;

    public Ticket(String ticketId, Status status, String usrID, String vehicleId) {
        this.status = status;
        this.ticketId = generateTicket(ticketId);
        this.dateOfBorrow = LocalDateTime.now();
        this.usrID = usrID;
        this.vehicleId = vehicleId;
        this.debt = 0;
    }

    private String generateTicket(String ticketId) {
        if(Integer.parseInt(ticketId) < 10){
            return "T-0"+ticketId;
        } else {
            return "T-"+ticketId;
        }
    }

    public String getTicketId() {
        return this.ticketId;
    }

    public Status getStatus() {
        return this.status;
    }

    public LocalDateTime getDateOfBorrow() {
        return dateOfBorrow;
    }

    public String getVehicleId() {
        return vehicleId;
    }

    public String getUsrID() {
        return usrID;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public double getDebt() {
        return debt;
    }

    @Override
    public void updateDebt(double value) {
        //TODO
    }

    public enum Status {
        Ok,
        Pending,
        Active
    }
}
