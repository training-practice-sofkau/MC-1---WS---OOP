package co.com.movingu.vehicle;

//TO DO: Complete/Rewrite the class according to the requirements
public class Bicycle extends Vehicle {
    private String bikeType;

    public Bicycle(boolean available, String code, String color, boolean condition, String bikeType) {
        super(available, code, color, condition);
        this.bikeType = bikeType;
    }
}
