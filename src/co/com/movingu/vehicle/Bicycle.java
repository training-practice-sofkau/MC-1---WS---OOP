package co.com.movingu.vehicle;

//TODO: Complete/Rewrite the class according to the requirements
public class Bicycle extends Vehicle{
    private String type;

    public Bicycle(String vId, String color, boolean available, boolean goodCondition, String type) {
        super(vId, color, available, goodCondition);
        this.type = type;
    }

}
