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

        System.out.println("Type 1 to borrow a bicycle, 2 to borrow a scooter");
        Integer vehicleTypesOption= util.captureInt();
        String vehicleTypes="";
        if (vehicleTypesOption == 1){
            vehicleTypes="B";
        }
        if (vehicleTypesOption == 2){
            vehicleTypes="S";
        }

        System.out.println("Type your DNI");
        String userId = util.captureString();
        System.out.println("option is:" +vehicleTypes);



        if (vehicles.checkAvailable(vehicleTypes)){

            String vehicleId =
                    vehicles.getVehicles()
                            .stream()
                            .filter(x -> x.getVtype() == "B" && x.isAvailable())
                            .findFirst()
                            .get()
                            .getId();
            Integer ticketsSize = tickets.size();
            String ticketID = ticketsSize.toString();
            Ticket t= new Ticket(ticketID,userId, vehicleId);
            System.out.println(t);
            tickets.add(new Ticket(ticketID,userId, vehicleId));
        }
        System.out.println(tickets);


    }

}
