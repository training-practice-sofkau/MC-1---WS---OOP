package co.com.movingu.ticket;

import co.com.movingu.vehicle.Vehicle;
import co.com.movingu.vehicle.VehicleInventory;

import java.util.ArrayList;
import java.util.List;

public class TicketList {
    private  List<Ticket> tickets = new ArrayList<>();
    private VehicleInventory vehicles;

    // constructor with "injection" of the vehicles inventory
    public TicketList(VehicleInventory vehicles) {
        this.vehicles = vehicles;
    }

    public void addTicket (Boolean helmet, String userId, String vehicleType){

        if (vehicles.checkAvailable(vehicleType)){
            Integer ticketsSize = tickets.size();
            String ticketID = ticketsSize.toString();
            String vehicleId =
                    vehicles.getVehicles()
                    .stream()
                    .filter(x -> x.getVtype() == vehicleType && x.isAvailable())
                    .findFirst()
                    .get()
                    .getId();

            tickets.add(new Ticket(ticketID,helmet,userId, vehicleId));
            System.out.println("Ticket successfully added");
        } else {
            System.out.println("Could not place the ticket");
        }

    }

}
