package co.com.movingu.vehicle;

//TO DO: Complete/Rewrite the class according to the requirements
public abstract class Vehicle implements Loanable{
    private final String UID;
    private boolean available;
    public final String color;
    private String state;

    public Vehicle(String UID, boolean available, String color, String state) {
        this.UID = UID;
        this.available = available;
        this.color = color;
        this.state = state;
    }

    @Override
    public void updateAvailability(boolean value) {
        this.available = value;
    }

    public void updateState(boolean isReady) {
        this.state = isReady? "Ready to use" : "On maintenance";
        if (isReady) updateAvailability(true);
        System.out.println("---------> The vehicle is now: "+this.state);
    }


    public String getUID() {
        return UID;
    }

    public boolean isAvailable() {
        return available;
    }

}
