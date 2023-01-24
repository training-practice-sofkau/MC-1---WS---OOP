package co.com.movingu.vehicle;

//TO DO: Complete/Rewrite the class according to the requirements
public class Scooter extends Vehicle{

    private int batterySatus;
    public Scooter(String id, String color, boolean isAvailable, Condition condition, int batterySatus) {
        super(id, color, isAvailable, condition);
        this.batterySatus = batterySatus;
    }

    public void setBatteryStatus(int batteryStatus) {
        this.batterySatus = batteryStatus;
    }
}
