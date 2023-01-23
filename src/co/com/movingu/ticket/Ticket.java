package co.com.movingu.ticket;

import co.com.movingu.user.User;
import co.com.movingu.vehicle.Bicycle;
import co.com.movingu.vehicle.Scooter;
import co.com.movingu.vehicle.Vehicle;

import java.time.*;


public class Ticket {

    static String code = "T_";
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
        code += counter;
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

}