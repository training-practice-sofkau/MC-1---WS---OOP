package co.com.movingu.vehicle;

//TO DO: Complete/Rewrite the class according to the requirements
public class Bicycle extends  Vehicle{
    private String type;
    public static int availableBicyle;

    public Bicycle(String code, String color, boolean available, boolean condition, String type) {
        super(code, color, available, condition);
        this.type = type;

        if (available) {
            incrementNum();
        }
    }

    public static void incrementNum(){
        availableBicyle ++;
    }

    public static void  decrementNum(){
        availableBicyle --;
    }

    public static int getAvailableBicyle() {
        return availableBicyle;
    }
}
