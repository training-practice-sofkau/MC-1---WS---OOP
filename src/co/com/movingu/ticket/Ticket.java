package co.com.movingu.ticket;
import java.time.LocalDateTime;

//TO DO: Complete/Rewrite the class according to the requirements
public class Ticket {

    private int ticketNumber = 000;
    private String code;
    private LocalDateTime startTime;
    private LocalDateTime endTime;
    private boolean helmet;
    private String status;
    private String debt;
    private String vehicleId;
    private String userDNI;

    public Ticket (String vehicleId, String userDNI, boolean helmet) {

        this.code = "T-" + this.ticketNumber;
        this.startTime  = LocalDateTime.now();
        this.vehicleId = vehicleId;
        this.userDNI = userDNI;
        this.helmet = helmet;
        this.status = "Active";
        this.debt = "";

    }

    public void updateTicketStatus (String value) {
        this.status = value;
    }

    public void updateTicketDebt (String value) {
        this.debt = value;
    }

    //TO DO: Add the necessary getters & setters u other extra function
}
