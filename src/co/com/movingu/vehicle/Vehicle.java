package co.com.movingu.vehicle;

//TO DO: Complete/Rewrite the class according to the requirements
public abstract class Vehicle implements Loanable{

    private String codeVH;

    private String color;

    private boolean condition;
    private boolean available;

    public Vehicle(String codeVH, String color, boolean available) {
        this.codeVH=codeVH;
        this.color=color;
        this.condition=available;
        this.available = true;
    }

    @Override
    public void updateAvailability(boolean value) {
        this.available = value;
    }
    //TO DO: Attributes

    public abstract void infoMsg();

    public String getCodeVH() {
        return codeVH;
    }

    public void setCodeVH(String codeVH) {
        this.codeVH = codeVH;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public boolean isCondition() {
        return condition;
    }

    public void setCondition(boolean condition) {
        this.condition = condition;
    }

    public boolean isAvailable() {
        return available;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }
}
