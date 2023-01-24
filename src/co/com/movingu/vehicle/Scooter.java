package co.com.movingu.vehicle;

//TO DO: Complete/Rewrite the class according to the requirements
public class Scooter extends Vehicle{
    private int battery;
    public static int availableScooter;

    public Scooter(String code, String color, boolean availalable, boolean condition, int battery) {
        super(code, color, availalable, condition);
        this.battery = battery;
    }

    public static void incrementNum(){
        availableScooter ++;
    }

    public static void  decrementNum(){
        availableScooter --;
    }

    public static int getAvailableScooter() {
        return availableScooter;
    }

}
