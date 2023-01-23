package co.com.movingu.vehicle;

//TO DO: Complete/Rewrite the class according to the requirements
public class Bicycle extends Vehicle{
    private String type;

    public Bicycle(String id, String color, boolean available, String condition, String type, String vType) {
        super(id,color,available, condition, vType);
        this.type = type;
    }

}
