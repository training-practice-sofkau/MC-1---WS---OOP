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

    public boolean isHelmet() {
        return helmet;
    }

    public void setHelmet(boolean helmet) {
        this.helmet = helmet;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getDebt() {
        return debt;
    }

    public void setDebt(int debt) {
        this.debt = debt;
    }

    public Date getStartedDate() {
        return startedDate;
    }

    public void setStartedDate(Date startedDate) {
        this.startedDate = startedDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    @Override
    public void updateDebt(Date date, boolean helmet, boolean helmetDamage,
                           boolean vehicleDamage, String typeVehicule) {
        if (date.after(this.getEndDate())){
            int timeSave = (date.getMinutes() - this.getEndDate().getMinutes())/30;
            this.setDebt(this.getDebt() + (timeSave * 3));

        }

        if (!helmet) {
            this.setDebt(this.getDebt()+10);
        }

        if (helmetDamage || vehicleDamage) {
            switch (typeVehicule){
                case "bicycle":{
                    this.setDebt(this.getDebt()+20);
                }
                case  "scooter":{
                    this.setDebt(this.getDebt()+20);
            }

            }
        }

    }
    @Override
    public void updateStatus(Date date, boolean vehicleDamage, boolean payedDebt,
                             boolean available) {
        if ((date.before(this.getEndDate()) && !vehicleDamage) &&  payedDebt){
            this.setStatus("OK");
        }

        if (date.after(this.getEndDate()) && vehicleDamage){
            this.setStatus("Pending");
        }

        if (available){
            setStatus("Active");
        }
    }
}
