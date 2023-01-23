package co.com.movingu.vehicle;

//TODO: Complete/Rewrite the class according to the requirements
public abstract class Vehicle implements Loanable{
    private boolean available;
    private final int vId;

    public Vehicle(int vId) {
        this.available = true;
        this.vId = vId;
    }

    @Override
    public void updateAvailability(boolean value) {
        this.available = value;
    }

    public int getVId() {
        return vId;
    }
    //TO DO: Attributes

}
