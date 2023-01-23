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
        String vehicleType= util.captureString();

        System.out.println();
        if (vehicles.checkAvailable("B")){
            System.out.println("whaaat");
            Integer ticketsSize = tickets.size();
            String ticketID = ticketsSize.toString();
            String vehicleId =
                    vehicles.getVehicles()
                    .stream()
                    .filter(x -> x.getVtype() == vehicleType && x.isAvailable())
                    .findFirst()
                    .get()
                    .getId();


            Ticket t= new Ticket(ticketID,helmet,userId, vehicleId);
            System.out.println(t);
            tickets.add(new Ticket(ticketID,helmet,userId, vehicleId));

        }
        System.out.println(tickets);


    }

}
