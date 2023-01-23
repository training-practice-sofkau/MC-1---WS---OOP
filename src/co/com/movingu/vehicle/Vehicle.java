package co.com.movingu.vehicle;

//TO DO: Complete/Rewrite the class according to the requirements
public abstract class Vehicle implements Loanable{

    protected String id;
    protected String color;
    protected boolean isAvailable;
    protected Condition condition;

    public Vehicle(String id, String color, boolean isAvailable, Condition condition) {
        this.id = id;
        this.color = color;
        this.isAvailable = isAvailable;
        this.condition = condition;
    }

    @Override
    public void updateAvailability(boolean value) {
        this.isAvailable = value;
    }

    public String getId() {
        return this.id;
    }
    public String getColor() {
        return this.color;
    }
    public boolean isAvailable() {
        return this.isAvailable;
    }

    public enum Condition {
        NEW,
        NEAR_MINT,
        GOOD
    }
}
