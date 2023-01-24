package co.com.movingu.vehicle;

//TO DO: Complete/Rewrite the class according to the requirements
public abstract class Vehicle implements Loanable{

    protected String code;
    protected String color;
    protected boolean isUsable;
    protected boolean isAvailable;


    public Vehicle(String code, String color, boolean isUsable, boolean isAvailable) {
        this.code = code;
        this.color = color;
        this.isUsable = isUsable;
        this.isAvailable = isAvailable;
    }

    @Override
    public void updateAvailability(boolean value) {
        this.isAvailable = value;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public boolean isUsable() {
        return this.isUsable;
    }

    public void setUsable(int isUsable) {
        if (isUsable == 1){
            this.isUsable = true;
        }
        if (isUsable == 2){
            this.isUsable = false;
        }
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public void setAvailable(boolean available) {
        isAvailable = available;
    }
}
