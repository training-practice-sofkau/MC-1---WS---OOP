package co.com.movingu.ticket;

import java.time.LocalDateTime;



public class Ticket {
    String str1 = "T-";
    protected String id;
    protected LocalDateTime timeStart;
    protected LocalDateTime timeEnd;
    protected String status ;
    protected boolean helmet;
    protected int debt;
    protected String vehicle;
    protected String user;

    public Ticket(String id, LocalDateTime timeStart, LocalDateTime timeEnd, String status, boolean helmet, int debt, String vehicle, String user) {
        this.id = id;
        this.timeStart = timeStart;
        this.timeEnd = timeEnd;
        this.status = status;
        this.helmet = helmet;
        this.debt = debt;
        this.vehicle = vehicle;
        this.user = user;
    }



    public String getId() {
        return id;
    }
    public String setId(int count) {

        String str = String.valueOf(count);
        this.id = str1 + str;
        return id;
    }
    public LocalDateTime setTimeEnd(LocalDateTime t) {

        timeEnd = t;
        return timeEnd;
    }
    public String setStatus(String status) {
        this.status = status;
        return status;
    }
    public int setDebt(int money) {
        this.debt = money;
        return debt;
    }

    public int getDebt() {
        return debt;
    }

    public void setVehicle(String vehicle) {
        this.vehicle = vehicle;
    }

    public String getVehicle() {
        return vehicle;
    }

    public void setUser(String user) {
        this.user = user;
    }
}

