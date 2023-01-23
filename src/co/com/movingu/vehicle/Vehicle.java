package co.com.movingu.vehicle;

//TODO: Complete/Rewrite the class according to the requirements
public abstract class Vehicle implements Loanable{
    private boolean available;
    private final String vId;
    private String color;

    public Vehicle(String vId, String color) {
        this.available = true;
        this.vId = vId;
    }

    @Override
    public void updateAvailability(boolean value) {
        this.available = value;
    }

    public boolean isAvailable() {
        return available;
    }

    public String getVId() {
        return vId;
    }
    //TO DO: Attributes

}
