package co.com.movingu.ticket;

import co.com.movingu.user.User;
import co.com.movingu.vehicle.Bicycle;
import co.com.movingu.vehicle.Scooter;
import co.com.movingu.vehicle.Vehicle;


import java.time.*;


public class Ticket implements payable {

    private String id;
    static int counter = 0;
    private LocalDateTime pickDate;
    private LocalDateTime returnDate;
    private boolean isThereAHelmet;
    private boolean isDamaged;
    private double overTime;
    private String status;
    private int amountToPay;
    private User user;
    private Vehicle vehicle;

    public Ticket (User user, Vehicle vehicle){
        setId();
        pickDate = LocalDateTime.now();
        returnDate = null;
        isThereAHelmet = true;
        isDamaged = false;
        overTime = 0;
        status = "Active";
        amountToPay = 0;
        this.user = user;
        this.vehicle = vehicle;
    }

    @Override
    public String toString() {
        return "Ticket{" +
                "id=" + id +
                ", pickDate=" + pickDate +
                ", returnDate=" + returnDate +
                ", isThereAHelmet=" + isThereAHelmet +
                ", isDamaged=" + isDamaged +
                ", overTime=" + overTime +
                ", status='" + status + '\'' +
                ", amountToPay=" + amountToPay +
                ", user=" + user +
                ", vehicle=" + vehicle +
                '}';
    }

    public  String getId() {
        return this.id;
    }
    public void setId(){
        counter++;

        if(counter < 10){
            this.id = "T_00" + counter;
        }
        if(counter >= 10 ){
            this.id = "T_0" + counter;
        }
    }

    public void setReturnDate(){
        this.returnDate = LocalDateTime.now();
    }
    public static int getCounter() {
        return counter;
    }

    public static void setCounter(int counter) {
        Ticket.counter = counter;
    }

    public LocalDateTime getPickDate() {
        return pickDate;
    }

    public void setPickDate(LocalDateTime pickDate) {
        this.pickDate = pickDate;
    }

    public LocalDateTime getReturnDate() {
        return returnDate;
    }

    public void setReturnDate(LocalDateTime returnDate) {
        this.returnDate = returnDate;
    }

    public boolean getIsThereAHelmet() {
        return this.isThereAHelmet;
    }

    public void setIsThereAHelmet(int isThereAHelmet) {
        if (isThereAHelmet == 1){
            this.isThereAHelmet = true;
        }
        if (isThereAHelmet == 2){
            this.isThereAHelmet = false;
        }
    }

    public boolean isDamaged() {
        return isDamaged;
    }

    public void setDamaged(int isDamaged) {
        if (isDamaged == 1){
            this.isDamaged = false;
        }
        if (isDamaged == 2){
            this.isDamaged = true;
        }
    }

    public double getOverTime() {
        return overTime;
    }

    public void setOverTime(double overTime) {
        this.overTime = overTime;
    }

    public String getStatus() {
        return status;
    }

    public int getAmountToPay() {
        return amountToPay;
    }

    public void setAmountToPay() {

        if(!isThereAHelmet && vehicle.getClass() == Scooter.class){
            this.amountToPay += 5;
        }
        if(isDamaged && vehicle.getClass() == Scooter.class){
            this.amountToPay += 30;
        }
        if(!isThereAHelmet && vehicle.getClass() == Bicycle.class){
            this.amountToPay += 5;
        }
        if(isDamaged && vehicle.getClass() == Bicycle.class){
            this.amountToPay += 20;
        }

    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }

    @Override
    public void updateTicketStatus(String status) {
        this.status = status;
    }
}