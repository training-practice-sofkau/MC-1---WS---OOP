package co.com.movingu.ticket;

import co.com.movingu.Context;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

//TO DO: Complete/Rewrite the class according to the requirements
public class Ticket {

    private final Context context = new Context();
    public final String[] PENALTIES = context.PENALTIES;
    private final String ticketId;

    private final String userDni;

    private final Date borrowingDate;

    private String status;

    private Boolean isSolved;

    private double totalDebt;

    private final int typeOfVehicle;

    private final String vehicleID;

    private final String[] STATUS_CASES = new String[]{"OK", "Pending", "Active"};

    public Ticket(List<Ticket> listOfTickets, String userDni, int typeOfVehicle, String vehicleID) {
        this.ticketId = generateTicket(listOfTickets);
        this.userDni = userDni;
        this.borrowingDate = new Date();
        this.isSolved = false;
        this.status = this.STATUS_CASES[2];
        this.totalDebt = 0;
        this.typeOfVehicle = typeOfVehicle;
        this.vehicleID = vehicleID;
    }

    private String generateTicket(List<Ticket> listOfTickets) {
        try {
            int numberOfTickets = listOfTickets.size();
            String ticketId;
            if (numberOfTickets < 10) {
                ticketId = "T-00" + (numberOfTickets + 1);
            } else if (numberOfTickets < 100) {
                ticketId = "T-0" + (numberOfTickets + 1);
            } else {
                ticketId = "T-" + (numberOfTickets + 1);
            }
            System.out.println("The ticket has been generated");
            return ticketId;
        } catch (Exception e) {
            System.out.println("The ticket couldn't generate");
            throw e;
        }
    }

    public String getUserDni() {
        return this.userDni;
    }

    public String getTicketId() {
        return this.ticketId;
    }

    public Date getBorrowingDate() {
        return this.borrowingDate;
    }

    public Boolean verifySolved() {
        return this.isSolved;
    }

    public Boolean increseDebt(int penalty) {
        if (penalty >= 0 && penalty < 4) {
            switch (penalty) {
                case (0):
                    this.totalDebt = this.totalDebt + 3;
                    break;
                case (1):
                    this.totalDebt = this.totalDebt + 10;
                    break;
                case (2):
                    this.totalDebt = this.totalDebt + 5;
                    break;
                case (3):
                    if (this.typeOfVehicle == 1) {
                        this.totalDebt = this.totalDebt + 20;
                    } else if (this.typeOfVehicle == 0) {
                        this.totalDebt = this.totalDebt + 30;
                    }
                    break;
            }
            return true;
        } else {
            return false;
        }
    }

    public boolean solveTiket() {
        if (this.totalDebt>0) {
            this.isSolved = true;
            this.status = this.STATUS_CASES[0];
            System.out.println("The vehicle has been returned successfully \n the ticket is solved");
            return true;
        }else{
            this.status = this.STATUS_CASES[1];
            System.out.println("The vehicle has been returned successfully \n the ticket remains pending");
            return false;
        }
    }
}
