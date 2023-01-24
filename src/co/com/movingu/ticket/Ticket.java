package co.com.movingu.ticket;

import java.time.LocalDate;

//TODO: Complete/Rewrite the class according to the requirements
public class Ticket implements IPayable {

    private String ticketId;
    private Status status;
    private String usrID;
    private String vehicleId;
    private LocalDate dateOfBorrow;

    public Ticket(String ticketId, Status status, String usrID, String vehicleId) {
        this.status = status;
        this.ticketId = "T-0" + ticketId;
        this.dateOfBorrow = LocalDate.now();
        this.usrID = usrID;
        this.vehicleId = vehicleId;
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

    @Override
    public void updateDebt() {
        //TODO
    }

    public enum Status {
        Ok,
        Pending,
        Active
    }
}
