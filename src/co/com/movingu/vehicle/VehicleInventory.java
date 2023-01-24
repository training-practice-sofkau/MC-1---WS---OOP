package co.com.movingu.vehicle;


import java.util.ArrayList;
import java.util.List;

public class VehicleInventory {

    List<Vehicle> vehicles= new ArrayList<>(){{
        add(new Bicycle("B-001","red",true, "Good", "M", "B"));
        add(new Bicycle("B-002","blue",false, "Good", "M","B"));
        add(new Bicycle("B-003","red",true, "Good", "R","B"));
        add(new Bicycle("B-004","green",false, "Good", "R","B"));
        add(new Bicycle("B-005","grey",true, "Good", "M","B"));
        add(new Scooter("S-001","black",false, "Good", 20,"S"));
        add(new Scooter("S-002","blue",true, "Good", 50,"S"));
        add(new Scooter("S-003","grey",true, "Good", 80, "S"));
        add(new Scooter("S-005","black",false, "Good", 50, "S"));

    }};

    public List<Vehicle> getVehicles() {
        return vehicles;
    }

    public Boolean checkAvailable (String vehicleType){
        boolean available = false;
        try{
        if ((vehicles.stream().filter(x -> x.getVtype() == vehicleType && x.isAvailable()).count()) != 0){
            available = true;
        }}catch (Exception e){
            System.out.println("No available vehicles at the moment, please try again later");
        }
        return available;
    }

    public Vehicle getAvailableVehicle (String vehicleTypes){
        Vehicle availableVehicle = vehicles
                .stream()
                .filter(x -> x.getVtype() == vehicleTypes && x.isAvailable())
                .findFirst()
                .get();
        return availableVehicle;
    }

    public Vehicle getVehicleById (String vehicleId){
        Vehicle searchedVehicle = vehicles
                .stream()
                .filter(x -> x.getId().equals(vehicleId))
                .findFirst()
                .get();
        return searchedVehicle;
    }

    @Override
    public String toString() {
        return "Bicycles: " + vehicles.stream().filter(x -> x.getVtype() == "B" && x.isAvailable()).count()+ "\n"+
                "Scooters: " + vehicles.stream().filter(x -> x.getVtype() == "S" && x.isAvailable()).count() + "\n";
    }
}
