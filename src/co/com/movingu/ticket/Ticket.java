package co.com.movingu.ticket;

import co.com.movingu.user.User;
import co.com.movingu.vehicle.Vehicle;

import java.util.Date;

//TO DO: Complete/Rewrite the class according to the requirements
public class Ticket implements DebtInterface, StatusInterface{
    //TO DO: Add the necessary getters & setters u other extra function
    private String id;
    private Date startedDate;
    private Date endDate;
    private boolean helmet;
    private String status; // ticket Status
    private int debt;
    private Vehicle borrowedVehi;
    private User user;

    public Ticket(String id, Date startedDate,
                  Date endDate,
                  boolean helmet, String status,
                  int debt,
                  Vehicle borrowedVehi,
                  User user) {
        this.id = id;
        this.startedDate = startedDate;
        this.endDate = endDate;
        this.helmet = helmet;
        this.status = status;
        this.debt = debt;
        this.borrowedVehi = borrowedVehi;
        this.user = user;
    }

    @Override
    public void updateDebt(Date date, boolean helmet, String helmetCondition,
                           String vehicleCondition) {
        if (date.after(endDate)){
            
        }

    }

    @Override
    public void updateStatus() {

    }
}
