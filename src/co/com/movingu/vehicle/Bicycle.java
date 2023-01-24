package co.com.movingu.vehicle;

//TO DO: Complete/Rewrite the class according to the requirements
public class Bicycle extends Vehicle{

    private final BicycleType type;
    public Bicycle(String id, String color, boolean isAvailable, Condition condition, BicycleType type) {
        super(id, color, isAvailable, condition);
        this.type = type;
    }

    public BicycleType getType(){
        return this.type;
    }

    public enum BicycleType {
        MOUNTAIN,
        ROAD
    }
}
