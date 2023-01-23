package co.com.movingu.ticket;

import co.com.movingu.user.User;
import co.com.movingu.vehicle.Bicycle;
import co.com.movingu.vehicle.Scooter;
import co.com.movingu.vehicle.Vehicle;

import java.time.*;


public class Ticket {

    static String id = "T_";
    static int counter = 0;
    private LocalDate pickDate;
    private LocalDate returnDate;
    private boolean isThereAHelmet = true;

    private boolean isDamaged = false;

    private boolean isNoTime = false;
    private double overTime = 0;
    private String status = "Active";
    private int amountToPay = 0;
    private User user;
    private Vehicle vehicle;

    public Ticket (){
        counter++;
        id += counter;
        pickDate = LocalDate.now();

    }

    public int getDebt(){
        if(!isThereAHelmet && vehicle.getClass() == Scooter.class){
            amountToPay += 35;
        }
        if(!isThereAHelmet && vehicle.getClass() == Bicycle.class){
            amountToPay += 25;
        }
        return amountToPay;
    }

    public void setReturnDate(){
        this.returnDate = LocalDate.now();
    }

    public static String getId() {
        return id;
    }


    public static int getCounter() {
        return counter;
    }

    public static void setCounter(int counter) {
        Ticket.counter = counter;
    }

    public LocalDate getPickDate() {
        return pickDate;
    }

    public void setPickDate(LocalDate pickDate) {
        this.pickDate = pickDate;
    }

    public LocalDate getReturnDate() {
        return returnDate;
    }

    public void setReturnDate(LocalDate returnDate) {
        this.returnDate = returnDate;
    }

    public boolean isThereAHelmet() {
        return isThereAHelmet;
    }

    public void setThereAHelmet(boolean thereAHelmet) {
        isThereAHelmet = thereAHelmet;
    }

    public boolean isDamaged() {
        return isDamaged;
    }

    public void setDamaged(boolean damaged) {
        isDamaged = damaged;
    }

    public boolean isNoTime() {
        return isNoTime;
    }

    public void setNoTime(boolean noTime) {
        isNoTime = noTime;
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

    public void setStatus(String status) {
        this.status = status;
    }

    public int getAmountToPay() {
        return amountToPay;
    }

    public void setAmountToPay(int amountToPay) {
        this.amountToPay = amountToPay;
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
}