package co.com.movingu.vehicle;

//TO DO: Complete/Rewrite the class according to the requirements
public class Scooter extends Vehicle{

    private int batteryStatus;

    public Scooter(String codeVH,String color, boolean condition, int batteryStatus) {
        super(codeVH,color, condition);
        this.batteryStatus = batteryStatus;
    }

    @Override
    public void infoMsg() {
        if (isAvailable()){
            System.out.println("Scooter "+getCodeVH()+"is available");
        }else{
            System.out.println("Scooter "+getCodeVH()+"is rented");
        }
    }
}
