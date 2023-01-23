package co.com.movingu.vehicle;

//TO DO: Complete/Rewrite the class according to the requirements
public abstract class Vehicle implements Loanable{
    private String id;
    private String color;
    private String condition;
    private boolean available;


    public Vehicle(String id, String color, boolean available, String condition) {
        this.id = id;
        this.color = color;
        this.condition = condition;
        this.available = available;
    }




    @Override
    public void updateAvailability(boolean value) {
        this.available = value;
    }
    //TO DO: Attributes

}
