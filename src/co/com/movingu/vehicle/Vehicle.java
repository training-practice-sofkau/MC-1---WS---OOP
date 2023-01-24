package co.com.movingu.vehicle;

//TO DO: Complete/Rewrite the class according to the requirements
public abstract class Vehicle {
    private String id;
    private String color;
    private boolean available;
    private boolean condition;

    public Vehicle(String id, String color, boolean available, boolean condition) {
        this.id = id;
        this.color = color;
        this.available = available;
        this.condition = condition;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public boolean isAvailable() {
        return available;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }

    public boolean getCondition() {
        return condition;
    }

    public void setCondition(boolean condition) {
        this.condition = condition;
    }

    @Override
    public String toString() {
        return "Vehicle{" +
                "id='" + id + '\'' +
                ", color='" + color + '\'' +
                ", available=" + available +
                ", condition=" + condition +
                '}';
    }
}
