package co.com.movingu.vehicle;

//TO DO: Complete/Rewrite the class according to the requirements
public class Scooter extends Vehicle{
    private int batteryLevel;
    public Scooter(String id, String color, boolean available, boolean condition, int batteryLevel) {

        super(id, color, available, condition);
        this.batteryLevel = batteryLevel;

    }
}
