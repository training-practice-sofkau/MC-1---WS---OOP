package co.com.movingu.ticket;

import co.com.movingu.user.UserList;
import co.com.movingu.vehicle.VehicleList;

import java.util.ArrayList;
import java.util.List;

public class TiketList {
    public static List<Ticket> tickets = new ArrayList<>(){{
        add(new Ticket("T-001",UserList.users.get(0), VehicleList.vehicles.get(1)));
        add(new Ticket("T-002", UserList.users.get(1), VehicleList.vehicles.get(3)));
    }};
}
