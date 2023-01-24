package co.com.movingu.vehicle;

//TO DO: Complete/Rewrite the class according to the requirements
public class Scooter extends Vehicle{
    private int battery;
    public static int numAvailable;

    public Scooter(String code, String color, boolean availalable, boolean condition, int battery) {
        super(code, color, availalable, condition);
        this.battery = battery;
    }

    public void incrementNum(){
        numAvailable ++;
    }

    public  void  decrementNum(){
        numAvailable --;
    }
}
