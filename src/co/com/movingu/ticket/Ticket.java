package co.com.movingu.ticket;

import co.com.movingu.user.User;
import co.com.movingu.vehicle.Vehicle;

import java.sql.Date;
import java.sql.Timestamp;

//TO DO: Complete/Rewrite the class according to the requirements
public class Ticket {

    private String id;
    private Timestamp startTime;
    private Timestamp endTime;
    private boolean helmetSupplied;
    private Status status;
    private boolean isDebt;
    private int debt;
    private User user;
    private Vehicle vehicle;

    public Ticket(User user, Vehicle vehicle) {
        this.id = "T-";
        this.startTime = new Timestamp(System.currentTimeMillis());
        this.helmetSupplied = true;
        this.status = Status.ACTIVE;
        this.isDebt = true;
        this.user = user;
        this.vehicle = vehicle;
    }

    public String getId() {
        return this.id;
    }
    public String toString() {
        return "Ticket " + id + "\n" +
                "startTime: " + startTime + "\n" +
                "endTime: " + endTime + "\n" +
                "helmetSupplied: " + helmetSupplied + "\n" +
                "status: " + status + "\n" +
                "isDebt: " + isDebt + "\n" +
                "debt: " + debt + "\n" +
                "user: " + user.getName() + "\n" +
                "vehicle: " + vehicle.getId() + "\n";
    }

    public enum Status {
        OK,
        PENDING,
        ACTIVE
    }
}
