package co.com.movingu.vehicle;

//TO DO: Complete/Rewrite the class according to the requirements
public class Bicycle extends  Vehicle{
    private String type;
    public static int availableBicyle;

    public Bicycle(String code, String color, boolean availalable, boolean condition, String type) {
        super(code, color, availalable, condition);
        this.type = type;
    }

    public void incrementNum(){
        availableBicyle ++;
    }

    public  void  decrementNum(){
        availableBicyle --;
    }
}
