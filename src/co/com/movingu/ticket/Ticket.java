package co.com.movingu.ticket;

import co.com.movingu.user.User;
import co.com.movingu.vehicle.Scooter;
import co.com.movingu.vehicle.Vehicle;

import java.time.LocalDateTime;
import java.util.Date;

//TO DO: Complete/Rewrite the class according to the requirements
//public class Ticket {
//public class Ticket implements DebtInterface, StatusInterface{
public class Ticket implements DebtInterface, StatusInterface{
    //TO DO: Add the necessary getters & setters u other extra function
    private String id;
    private LocalDateTime  startedDate;
    private LocalDateTime endDate;
    private boolean helmet;
    private String status; // ticket Status
    private int debt;
    private Vehicle borrowedVehi;
    private User user;

    public Ticket(String id,
                  LocalDateTime  startedDate,
                  LocalDateTime  endDate,
                  boolean helmet,
                  String status,
                  int debt,
                  Vehicle borrowedVehi,
                  User user) {
        this.id = id;
        this.startedDate = startedDate;
        this.endDate = endDate;
        this.helmet = helmet;
        this.status = "Active";
        this.debt = debt;
        this.borrowedVehi = borrowedVehi;
        this.user = user;
    }

    public String getId() {
        return id;
    }

    public Vehicle getBorrowedVehi() {
        return borrowedVehi;
    }

    public User getUser() {
        return user;
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

    public LocalDateTime  getStartedDate() {
        return startedDate;
    }

    public void setStartedDate(LocalDateTime  startedDate) {
        this.startedDate = startedDate;
    }

    public LocalDateTime  getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDateTime  endDate) {
        this.endDate = endDate;
    }

    @Override
    public String toString() {
        return "Ticket{" +
                "id='" + id + '\'' +
                ", startedDate=" + startedDate +
                ", endDate=" + endDate +
                ", helmet=" + helmet +
                ", status='" + status + '\'' +
                ", debt=" + debt +
                ", borrowedVehi=" + borrowedVehi +
                ", user=" + user +
                '}';
    }

    @Override
    public void updateDebt(LocalDateTime  date,
                           boolean helmet,
                           boolean helmetDamage,
                           boolean vehicleDamage,
                           String typeVehicule) {
        if (date.isAfter(this.getEndDate())){
            int timeSave = (date.getMinute() - this.getEndDate().getMinute())/30;
            this.setDebt(this.getDebt() + (timeSave * 3));

        }

        if(helmetDamage){
            this.setDebt(this.getDebt()+5);
            //System.out.println("Your debt is: " + this.getDebt());
        }

        if (helmet==false){
            this.setDebt(this.getDebt()+10);
            //System.out.println("Your debt is3: " + this.getDebt());
        }

        if (vehicleDamage) {
            switch (typeVehicule){
                case "Bicycle":{
                    this.setDebt(this.getDebt()+20);
                    //System.out.println("Your debt is Bicy: " + this.getDebt());
                    break;
                }
                case  "Scooter":{
                    this.setDebt(this.getDebt()+30);
                    //System.out.println("Your debt is Scooter: " + this.getDebt());
                    break;
                }
            }
        }

        this.setEndDate(date);
        this.getBorrowedVehi().setAvailable(true);
        this.setHelmet(helmet);
        this.getBorrowedVehi().setCondition(vehicleDamage);
        if (typeVehicule.equals("Scooter")){
            Scooter borVehi = (Scooter) this.getBorrowedVehi();
            borVehi.setBatteryStatus(borVehi.getBatteryStatus()-30);
        }

        if (this.getDebt() != 0){
            this.getUser().setBlocked(true);
            this.updateStatus(vehicleDamage,helmetDamage, false);
        }else {
            this.getUser().setTicketOn(false);
            this.setStatus("OK");
        }


        }


    @Override
    public void updateStatus(
                             boolean vehicleDamage,
                             boolean helmetDamage,
                             boolean payedDebt) {
        if ( (!vehicleDamage || !helmetDamage)
                && payedDebt) {
            this.setStatus("OK");
            this.setDebt(0);
            this.getUser().setTicketOn(false);
            this.getUser().setBlocked(false);
            this.setHelmet(true);
            if (this.getBorrowedVehi().getId().startsWith("S")){
                Scooter borVehi = (Scooter) this.getBorrowedVehi();
                borVehi.setBatteryStatus(100);
            }
        }
        if ((vehicleDamage||helmetDamage)
        || payedDebt==false) {
            this.setStatus("Pending");
        }

    }
}



