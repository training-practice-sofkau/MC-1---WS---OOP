package co.com.movingu.vehicle;

//TO DO: Complete/Rewrite the class according to the requirements
public abstract class Vehicle implements Loanable{
    protected String code;
    protected String color;
    private boolean available;
    private boolean condition;

    public Vehicle(String code, String color, boolean available, boolean condition) {
        this.code = code;
        this.color = color;
        this.available = available;
        this.condition = condition;
    }

    public boolean isAvailable() {
        return available;
    }

    @Override
    public void updateAvailability(boolean value) {
        this.available = value;
    }
    public abstract void incrementNum();

    public abstract void  decrementNum();
}
