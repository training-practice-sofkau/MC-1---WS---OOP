package co.com.movingu.vehicle;

//TO DO: Complete/Rewrite the class according to the requirements
public class Bicycle extends Vehicle{
    private String type;

    public Bicycle(int id, String color, boolean available, String condition, String type) {
        super(id, color, available, condition);
        this.type = type;
    }
}
