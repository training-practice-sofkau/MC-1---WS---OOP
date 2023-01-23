package co.com.movingu.vehicle;

//TO DO: Complete/Rewrite the class according to the requirements
public abstract class Vehicle implements Loanable{

    protected String code;
    protected String color;
    protected boolean isUsable;
    protected boolean isAvailable;


    public Vehicle(String code, String color, boolean isUsable, boolean isAvailable) {
        this.code = code;
        this.color = color;
        this.isUsable = isUsable;
        this.isAvailable = isAvailable;
    }

    @Override
    public void updateAvailability(boolean value) {
        this.isAvailable = value;
    }

}
