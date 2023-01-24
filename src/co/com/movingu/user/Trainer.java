package co.com.movingu.user;

//TO DO: Complete/Rewrite the class according to the requirements
public class Trainer extends User{
    private final String  category;

    public Trainer(String dni, String name, int age, String category) {
        super(dni, name, age);
        this.category = category;
    }

    @Override
    public void statusMsg() {
        if(blocked && !ticketOn){
            System.out.println("The trainer " + name + " is blocked due to a debt");
        }else{
            System.out.println("The trainer " + name + " is blocked because he/she has already borrowed a vehicle.");
        }
    }

    @Override
    public String toString() {
        return "Trainer{" +
                "category='" + category + '\'' +
                ", dni='" + dni + '\'' +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", blocked=" + blocked +
                ", ticketOn=" + ticketOn +
                '}';
    }
}
