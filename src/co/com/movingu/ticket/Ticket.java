package co.com.movingu.ticket;

import co.com.movingu.user.User;
import co.com.movingu.vehicle.Vehicle;

import java.util.Date;

//TO DO: Complete/Rewrite the class according to the requirements
public class Ticket implements ITicket {

    private String ticketID;
    private Date ticketCreation;
    private Date ticketExpiration;
    private Date returnDate;
    private String helmet;
    private String status;
    private Integer amountToPay;
    private String vehicleId;
    private String userId;

    private Date date = new Date();


    public Ticket(
            String ticketID,
            String userId,
            String vehicleId) {
        this.ticketID = ticketID;
        this.ticketCreation = new Date(System.currentTimeMillis());
        this.ticketExpiration = new Date(System.currentTimeMillis()+3600000) ;
        this.status = "Active";
        this.userId = userId;
        this.vehicleId=vehicleId;
        this.amountToPay=0;
    }

    public String getTicketID() {
        return ticketID;
    }

    //TO DO: Add the necessary getters & setters u other extra function
    public Long calculateDebt(){
        Long delayDebt;
        this.returnDate=new Date(System.currentTimeMillis());
        //Miliseconds/1000 = seconds. Seconds/60=minutes. Minutes/30=fee
        delayDebt = Math.abs(returnDate.getTime()-ticketExpiration.getTime())/1000/60/30;
        if (returnDate.compareTo(ticketExpiration)<=0){
            delayDebt=0L;
        }
        return delayDebt;
    }

    @Override
    public Integer payTicket() {
        return null;
    }



    @Override
    public String toString() {
        return "Ticket{" +
                "ticketID='" + ticketID + '\'' +
                ", ticketCreation=" + ticketCreation +
                ", ticketExpiration=" + ticketExpiration +
                ", helmet='" + helmet + '\'' +
                ", status='" + status + '\'' +
                ", amountToPay=" + amountToPay +
                ", vehicleId='" + vehicleId + '\'' +
                ", userId='" + userId + '\'' +
                ", date=" + date +
                '}';
    }
}
