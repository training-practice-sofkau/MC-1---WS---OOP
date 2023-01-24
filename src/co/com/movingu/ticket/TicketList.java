package co.com.movingu.ticket;

import co.com.movingu.user.User;
import co.com.movingu.user.UserList;
import co.com.movingu.utilities.Utilities;
import co.com.movingu.vehicle.Vehicle;
import co.com.movingu.vehicle.VehicleInventory;

import java.util.ArrayList;
import java.util.List;

public class TicketList implements ITicket{
    private  List<Ticket> tickets = new ArrayList<>();
    private VehicleInventory vehicles;
    private UserList userList;
    Utilities util = new Utilities();

    // constructor with "injection" of the vehicles inventory and userlist
    public TicketList(VehicleInventory vehicles, UserList userList) {
        this.vehicles = vehicles;
        this.userList = userList;
    }

    public void addTicket () throws Exception {

        System.out.println("Type your DNI");
        String userId = util.captureString();
        System.out.println("Type 1 to borrow a bicycle, 2 to borrow a scooter");
        Integer vehicleTypesOption= util.captureInt();
        String vehicleTypes="";
        if (vehicleTypesOption == 1){
            vehicleTypes="B";
        }
        if (vehicleTypesOption == 2){
            vehicleTypes="S";
        }

        /*if (userList.getUser(userId) == null){
            throw new Exception("User not registered");
        }*/

        if (!vehicles.checkAvailable(vehicleTypes)){
            System.out.println("There are not available vehicles at the moment, please try later");
        }
        if (vehicles.checkAvailable(vehicleTypes)){


            Vehicle vehicle = vehicles.getAvailableVehicle(vehicleTypes);
            User currentUser = userList.getUser(userId);
            String vehicleId = vehicle.getId();
            Integer ticketsSize = tickets.size();
            String ticketID = ticketsSize.toString();
            tickets.add(new Ticket(ticketID,userId, vehicleId));
            System.out.println("A vehicle with ID: '" +vehicleId+
                            "' has been assigned to you with the ticket #"+
                            ticketID
                        );
            vehicle.updateAvailability(false);
            currentUser.setTicketOn(true);
            currentUser.setBlocked(true);
        }
        System.out.println(tickets);


    }

    public Ticket getTicket (String ticketId){
        return tickets.stream().filter(x -> x.getTicketID().equals(ticketId))
                .findFirst()
                .get();
    }

    public void returnVehicle(Ticket ticket){
        Vehicle returnedVehicle= vehicles.getVehicleById(ticket.getVehicleId());
        System.out.println("Are you returning the helmet? type: yes(y)/no (n)");
        Boolean returnedHelmet=((util.captureString().equals("n")?false:true));
        System.out.println("Type the helmet condition: Good/Bad");
        Boolean helmetStatus=((util.captureString().equals("Bad")?false:true));
        System.out.println("Type the vehicle condition: Good/Bad");
        String vehicleCondition=util.captureString();

        ticket.setHelmetStatus(helmetStatus);
        ticket.setHelmet(returnedHelmet);
        returnedVehicle.setCondition(vehicleCondition);
        returnedVehicle.updateAvailability(true);
        ticket.setReturnDate();
        System.out.println("You have to pay:");
        System.out.println(ticket.calculateDebt(returnedVehicle.getVtype(), returnedVehicle)+"$");
    }
    @Override
    public void payTicket(Ticket ticket) {
        Vehicle ticketVehicle = vehicles.getVehicleById(ticket.getVehicleId());
        System.out.println("Your have paid: "+ ticketVehicle+ "$");
        System.out.println(ticket.calculateDebt(ticketVehicle.getVtype(), ticketVehicle));
        ticket.setAmountPaid();
    }

    @Override
    public String toString() {
        return "TicketList{" +
                "tickets=" + tickets +
                '}';
    }


}
