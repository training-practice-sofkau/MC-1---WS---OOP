package co.com.movingu.vehicle;

//TO DO: Complete/Rewrite the class according to the requirements
public class Bicycle extends Vehicle {

    private String type;
    public Bicycle(String codeVH,String color, boolean condition,String type) {
        super(codeVH,color, condition);
        this.type=type;
    }

    @Override
    public void infoMsg() {

        if (isAvailable()){
            System.out.println("Bicycle "+getCodeVH()+"is available");
        }else{
            System.out.println("Bicycle "+getCodeVH()+" and type "+this.type+" is rented");
        }

    }
}
