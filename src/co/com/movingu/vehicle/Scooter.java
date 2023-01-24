package co.com.movingu.vehicle;

//TO DO: Complete/Rewrite the class according to the requirements
public class Scooter extends Vehicle{

    private int batteryPercentage;

    public Scooter(String code, String color, boolean isUsable, boolean isAvailable, int batteryPercentage) {
        super(code, color, isUsable, isAvailable);
        this.batteryPercentage = batteryPercentage;
    }

    @Override
    public String toString() {
        return "Scooter{" +
                "batteryPercentage=" + batteryPercentage +
                ", code='" + code + '\'' +
                ", color='" + color + '\'' +
                ", isUsable=" + isUsable +
                ", isAvailable=" + isAvailable +
                '}';
    }

    public int getBatteryPercentage() {
        return batteryPercentage;
    }

    public void setBatteryPercentage(int batteryPercentage) {
        this.batteryPercentage = batteryPercentage;
    }
}
