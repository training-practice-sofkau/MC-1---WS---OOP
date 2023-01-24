package co.com.movingu.vehicle;

//TO DO: Complete/Rewrite the class according to the requirements
public class Scooter extends Vehicle{
    private int battery;
    public Scooter(boolean available, String code, String color, boolean condition, int battery) {
        super(available, code, color, condition);
        this.battery = battery;
    }
}
