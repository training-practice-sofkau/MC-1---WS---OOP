package co.com.movingu;

import co.com.movingu.ticket.Ticket;
import co.com.movingu.user.Student;
import co.com.movingu.user.Trainer;
import co.com.movingu.user.User;
import co.com.movingu.vehicle.Bicycle;
import co.com.movingu.vehicle.Scooter;
import co.com.movingu.vehicle.Vehicle;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class MovingUApp {

    //Lists that contains data related to the WS
    public static List<User> users = new ArrayList<>(){{
        add(new Student("0976152443", "Carolina Montoya", 24, "201547896", "FIEC"));
        add(new Trainer("0976152443", "Washington Pesantez", 36, "lecturer"));
    }};

    public static List<Vehicle> vehicles= new ArrayList<>(){{
        add(new Bicycle("B-001","red",true, Vehicle.Condition.NEW, Bicycle.BicycleType.MOUNTAIN));
        add(new Bicycle("B-002","blue",false, Vehicle.Condition.GOOD, Bicycle.BicycleType.MOUNTAIN));
        add(new Bicycle("B-003","red",true, Vehicle.Condition.NEAR_MINT, Bicycle.BicycleType.ROAD));
        add(new Bicycle("B-004","green",false, Vehicle.Condition.NEAR_MINT, Bicycle.BicycleType.ROAD));
        add(new Bicycle("B-005","grey",true, Vehicle.Condition.GOOD, Bicycle.BicycleType.MOUNTAIN));
        //add(new Scooter("S-001","black",false, true, 20));
        //add(new Scooter("S-002","blue",true, true, 50));
        //add(new Scooter("S-003","grey",true, true, 80));
        //add(new Scooter("S-004","grey",true, false, 50));
        //add(new Scooter("S-005","black",false, false, 50));

    }};

    public static List<Ticket> tickets = new ArrayList<>(){{
        //add(new Ticket());
        //add(new Ticket());
        //add(new Ticket());

    }};

    public static void main(String[] args) {

        int menuOption = 0;

        Scanner in = new Scanner(System.in);



        try {
            do {
                menu();
                menuOption = in.nextInt();

                switch (menuOption) {
                    case 1 :
                        registerUser(in);
                        break;
                    case 2 :
                        borrowReturn(in);
                        break;

                    case 5 :
                        System.out.println("Bye!");
                        break;
                    default :
                        System.out.println("Invalid menu option");
                        break;
                }
            } while (menuOption != 5);
        } catch (InputMismatchException e) {
            System.out.println("Invalid input type option");
        }catch (Exception e) {
            System.out.println(e);
        }





    }

    public static void menu(){
        System.out.println("Moving - U");
        System.out.println("1. Register user");
        System.out.println("2. Borrow/Return");
        System.out.println("3. Pay a ticket");
        System.out.println("4. Check availability");
        System.out.println("5. Exit");
    }

    public static void borrowReturn(Scanner in){
        System.out.print("Action to do: Borrow (B) / Return (R)");
        String action = in.next().toUpperCase();

        switch (action){
            case "B":
                System.out.println("Available vehicles:");
                for (Vehicle vehicle: vehicles) {
                    if (vehicle.isAvailable()) {
                        if (vehicle.getId().startsWith("B")){
                            System.out.println("Bicycle: " + vehicle.getColor());
                        }
                        if (vehicle.getId().startsWith("S")){
                            System.out.println("Scooter: " + vehicle.getColor());
                        }
                    }
                }
        }
    }

    public static void registerUser(Scanner in){
        System.out.println("DNI number:");
        String userDni = in.next();

        System.out.println("User name:");
        String userName = in.next();

        System.out.println("User age:");
        int userAge = in.nextInt();

        System.out.print("User is: Student (S) / Trainer (T)");
        String userType = in.next().toUpperCase();

        switch (userType) {
            case "S" :
                System.out.println("Student college DNI");
                String userCollegeDni = in.next();
                System.out.println("Student faculty");
                String userFaculty = in.next();
                User s = new Student(userDni, userName, userAge, userCollegeDni, userFaculty);
                users.add(s);
                System.out.println("Student " + userName + " created successfully");
                break;
            case "T":
                System.out.println("Trainer category: ");
                String userCategory = in.next();
                User t = new Trainer(userDni, userName, userAge, userCategory);
                users.add(t);
                System.out.println("Trainer " + userName + " created successfully");
                break;
            default:
                System.out.println("Invalid option");
                break;
        }
    }

}