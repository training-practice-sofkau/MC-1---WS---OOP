package co.com.movingu.ticket;

import co.com.movingu.user.User;
import co.com.movingu.vehicle.Vehicle;

import java.util.Date;

//TO DO: Complete/Rewrite the class according to the requirements
public class Ticket implements ITicket {

    private String ticketID;
    private Date ticketCreation;
    private Date ticketExpiration;
    private Boolean helmet;
    private String status;
    private Integer amountToPay;
    private Vehicle vehicle;
    private User user;

    private Date date = new Date();


    public Ticket(
            String ticketID,
            Boolean helmet,
            String status,
            Integer amountToPay,
            Vehicle vehicle,
            User user) {
        this.ticketID = ticketID;
        this.ticketCreation = new Date(System.currentTimeMillis());
        this.ticketExpiration = new Date(System.currentTimeMillis()+3600) ;
        this.helmet = helmet;
        this.status = "Active";
        this.vehicle = vehicle;
        this.user = user;
    }

    //TO DO: Add the necessary getters & setters u other extra function
    @Override
    public Integer payTicket() {
        return null;
    }


}
