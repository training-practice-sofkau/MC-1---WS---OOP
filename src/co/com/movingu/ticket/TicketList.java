package co.com.movingu.ticket;

import co.com.movingu.utilities.Utilities;
import co.com.movingu.vehicle.Vehicle;
import co.com.movingu.vehicle.VehicleInventory;

import java.util.ArrayList;
import java.util.List;

public class TicketList {
    private  List<Ticket> tickets = new ArrayList<>();
    private VehicleInventory vehicles;
    Utilities util = new Utilities();

    // constructor with "injection" of the vehicles inventory
    public TicketList(VehicleInventory vehicles) {
        this.vehicles = vehicles;
    }

    public void addTicket (){

        System.out.println();
        System.out.println("Type your DNI");
        String userId = util.captureString();
        System.out.println("In case you need a helmet, please type y, type n in case you don't");
        String helmet = util.captureString();
        System.out.println("Type B to borrow a bicycle, S to borrow a scooter");
        String vehicleTypes= util.captureString();
        System.out.println("option is:" +vehicleTypes);



        //Error here!!! solving the conditional to take the string from input
        if (vehicles.checkAvailable(vehicleTypes.toString())){

            String vehicleId =
                    vehicles.getVehicles()
                            .stream()
                            .filter(x -> x.getVtype() == "B" && x.isAvailable())
                            .findFirst()
                            .get()
                            .getId();
            Integer ticketsSize = tickets.size();
            String ticketID = ticketsSize.toString();
            Ticket t= new Ticket(ticketID,helmet,userId, vehicleId);
            System.out.println(t);
            tickets.add(new Ticket(ticketID,helmet,userId, vehicleId));
        }
        System.out.println(tickets);


    }

}
