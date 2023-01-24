package co.com.movingu.ticket;

import co.com.movingu.user.User;
import co.com.movingu.vehicle.Vehicle;
import co.com.movingu.vehicle.VehicleList;

import java.sql.Timestamp;

//TO DO: Complete/Rewrite the class according to the requirements
public class Ticket {

    private String id;
    private Timestamp startTime;
    private Timestamp endTime;
    private boolean helmetSupplied;
    private Status status;
    private boolean debt;
    private User user;
    private Vehicle vehicle;
    private int payment;

    public Ticket(User user, Vehicle vehicle) {
        this.id = "T-" + idGenerator();
        this.startTime = new Timestamp(System.currentTimeMillis());
        this.helmetSupplied = true;
        this.status = Status.ACTIVE;
        this.debt = false;
        this.user = user;
        this.vehicle = vehicle;
        this.payment = 0;
    }

    public Ticket(String id, User user, Vehicle vehicle) {
        this.id = id;
        this.startTime = new Timestamp(System.currentTimeMillis());
        this.helmetSupplied = true;
        this.status = Status.ACTIVE;
        this.debt = false;
        this.user = user;
        this.vehicle = vehicle;
        this.payment = 0;
    }

    public String idGenerator() {
        String num = "";
        int temp = TiketList.tickets.size() + 1;

        if(temp < 10) {
            num = "00" + temp;
        }
        if(temp > 10 && temp < 100) {
            num = "0" + temp;
        } if (temp > 100) {
            num = num + temp;
        }

        return num;
    }
    public String getId() {
        return this.id;
    }

    public User getUser() {
        return user;
    }

    public Timestamp getStartTime() {
        return this.startTime;
    }
    public Timestamp getEndTime() {
        return this.endTime;
    }
    public void setEndTime(Timestamp endTime) {
        this.endTime = endTime;
    }
    public Vehicle getVehicle() {
        return this.vehicle;
    }

    public void setDebt(boolean debt) {
        this.debt = debt;
    }

    public int getPayment() {
        return this.payment;
    }

    public void setPayment(int payment) {
        this.payment = payment;
    }

    public String toString() {
        return "Ticket " + id + "\n" +
                "Start time: " + startTime + "\n" +
                "End time: " + endTime + "\n" +
                "Helmet supplied: " + helmetSupplied + "\n" +
                "Status: " + status + "\n" +
                "Debt: " + debt + "\n" +
                "user: " + user.getName() + "\n" +
                "vehicle: " + vehicle.getId() + "\n" +
                "amount to pay: " + payment + "\n" ;

    }

    public enum Status {
        OK,
        PENDING,
        ACTIVE
    }

}
