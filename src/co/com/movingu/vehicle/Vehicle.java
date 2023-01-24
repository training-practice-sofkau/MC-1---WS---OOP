package co.com.movingu.vehicle;

//TO DO: Complete/Rewrite the class according to the requirements
public abstract class Vehicle implements Loanable{
    private String id;
    private String color;
    private String condition;
    private boolean available;
    private String vtype;


    public Vehicle(String id, String color, boolean available, String condition, String vtype) {
        this.id = id;
        this.color = color;
        this.condition = condition;
        this.available = available;
        this.vtype = vtype;
    }


    public String getVtype() {
        return vtype;
    }

    public boolean isAvailable() {
        return available;
    }

    public String getId() {
        return id;
    }

    public String getCondition() {
        return condition;
    }

    public void setCondition(String condition) {
        this.condition = condition;
    }

    @Override
    public void updateAvailability(boolean value) {
        this.available = value;
    }


}
