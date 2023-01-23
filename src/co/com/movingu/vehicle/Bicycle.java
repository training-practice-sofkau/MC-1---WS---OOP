package co.com.movingu.vehicle;

//TO DO: Complete/Rewrite the class according to the requirements
public class Bicycle extends Vehicle{

    private String type;

    public Bicycle(String code, String color, boolean isUsable, boolean isAvailable, String type) {
        super(code, color, isUsable, isAvailable);
        this.type = type;
    }

    @Override
    public String toString() {
        return "Bicycle{" +
                "type='" + type + '\'' +
                ", code='" + code + '\'' +
                ", color='" + color + '\'' +
                ", isUsable=" + isUsable +
                ", isAvailable=" + isAvailable +
                '}';
    }
}
