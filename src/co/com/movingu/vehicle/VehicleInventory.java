package co.com.movingu.vehicle;


import java.util.ArrayList;
import java.util.List;

public class VehicleInventory {

    List<Vehicle> vehicles= new ArrayList<>(){{
        add(new Bicycle("B-001","red",true, "Good", "M"));
        add(new Bicycle("B-002","blue",false, "Good", "M"));
        add(new Bicycle("B-003","red",true, "Good", "R"));
        add(new Bicycle("B-004","green",false, "Good", "R"));
        add(new Bicycle("B-005","grey",true, "Good", "M"));
        //add(new Scooter("S-001","black",false, true, 20));
        //add(new Scooter("S-002","blue",true, true, 50));
        //add(new Scooter("S-003","grey",true, true, 80));
        //add(new Scooter("S-004","grey",true, false, 50));
        //add(new Scooter("S-005","black",false, false, 50));

    }};
}
