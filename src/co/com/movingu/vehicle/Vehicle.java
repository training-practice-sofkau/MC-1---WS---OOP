package co.com.movingu.vehicle;

//TO DO: Complete/Rewrite the class according to the requirements
public abstract class Vehicle implements Loanable{
    private boolean available;
    private String color;
    private String state;

    public Vehicle(boolean available, String color, String state) {
        this.available = available;
        this.color = color;
        this.state = state;
    }

    @Override
    public void updateAvailability(boolean value) {
        this.available = value;
    }
    //TO DO: Attributes

}
