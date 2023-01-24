package co.com.movingu.vehicle;

//TODO: Complete/Rewrite the class according to the requirements
public abstract class Vehicle implements Loanable {
    private boolean available;
    private boolean goodCondition;
    private final String vId;
    private String color;

    public Vehicle(String vId, String color, boolean available, boolean goodCondition) {
        this.available = available;
        this.vId = vId;
        this.color = color;
        this.goodCondition = goodCondition;
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

    @Override
    public String toString() {
        return "{" + '\n' +
                "available=" + available + '\n' +
                "vehicle id='" + vId + "'\n" +
                "color='" + color + "'\n" +
                '}' + '\n';
    }
}
