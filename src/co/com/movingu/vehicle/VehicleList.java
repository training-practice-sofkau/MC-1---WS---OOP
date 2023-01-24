package co.com.movingu.vehicle;

import java.util.ArrayList;
import java.util.List;

public class VehicleList {
    public static List<Vehicle> vehicles= new ArrayList<>(){{
        add(new Bicycle("B-001","red",true, Vehicle.Condition.NEW, Bicycle.BicycleType.MOUNTAIN));
        add(new Bicycle("B-002","blue",false, Vehicle.Condition.GOOD, Bicycle.BicycleType.MOUNTAIN));
        add(new Bicycle("B-003","red",true, Vehicle.Condition.NEAR_MINT, Bicycle.BicycleType.ROAD));
        add(new Bicycle("B-004","green",true, Vehicle.Condition.NEAR_MINT, Bicycle.BicycleType.ROAD));
        add(new Bicycle("B-005","grey",false, Vehicle.Condition.GOOD, Bicycle.BicycleType.MOUNTAIN));
        add(new Scooter("S-001","black",false, Vehicle.Condition.NEW, 20));
        add(new Scooter("S-002","blue",true, Vehicle.Condition.NEAR_MINT, 50));
        add(new Scooter("S-003","grey",true, Vehicle.Condition.NEW, 80));
        add(new Scooter("S-004","grey",true, Vehicle.Condition.GOOD, 50));
        add(new Scooter("S-005","black",false, Vehicle.Condition.GOOD, 50));

    }};
}
