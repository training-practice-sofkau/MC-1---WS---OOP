package co.com.movingu.vehicle;

//TO DO: Complete/Rewrite the class according to the requirements
public abstract class Vehicle implements Loanable{
    private String UID;
    private boolean available;
    private String color;
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

    public String getUID() {
        return UID;
    }

}
