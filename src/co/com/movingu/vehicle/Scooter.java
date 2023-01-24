package co.com.movingu.vehicle;

//TODO: Complete/Rewrite the class according to the requirements
public class Scooter extends Vehicle{

    private int battery;

    public Scooter(String vId, String color, boolean available, boolean goodCondition, int battery) {
        super(vId, color, available, goodCondition);
        this.battery = battery;
    }

    public int getBattery() {
        return battery;
    }

    public void setBattery(int battery) {
        this.battery = battery;
    }
}
