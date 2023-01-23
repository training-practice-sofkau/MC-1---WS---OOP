package co.com.movingu.vehicle;

//TO DO: Complete/Rewrite the class according to the requirements
public class Scooter extends Vehicle{
    private int battery;

    public Scooter(String id, String color, boolean available, String condition, int battery, String vType) {
        super(id, color, available, condition, vType);
        this.battery = battery;
    }
}
