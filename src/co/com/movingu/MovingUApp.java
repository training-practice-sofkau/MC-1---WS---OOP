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
        add(new Scooter("S-001","black",false, Vehicle.Condition.NEW, 20));
        add(new Scooter("S-002","blue",true, Vehicle.Condition.NEAR_MINT, 50));
        add(new Scooter("S-003","grey",true, Vehicle.Condition.NEW, 80));
        add(new Scooter("S-004","grey",true, Vehicle.Condition.GOOD, 50));
        add(new Scooter("S-005","black",false, Vehicle.Condition.GOOD, 50));

    }};

    public static List<Ticket> tickets = new ArrayList<>(){{
        add(new Ticket(users.get(0), vehicles.get(1)));
        add(new Ticket(users.get(1), vehicles.get(3)));
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
                    case 4:
                        System.out.println("Vehicles - is available?");
                        for (int i = 0; i < vehicles.size(); i++) {
                            System.out.println(vehicles.get(i).getId() + " - " + vehicles.get(i).isAvailable());
                        }
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
                borrowVehicle(in);
                break;
            case "R":
                returnVehicle(in);
                break;
            default:
                System.out.println("Invalid option");
                break;
        }
    }

    public static void returnVehicle(Scanner in){
        System.out.println("Ticket number");
        String ticketId = in.next();

        Ticket ticket = findTicket(ticketId);


    }

    public static Ticket findTicket(String id){
        Ticket ticketFound = null;

        for (Ticket ticket : tickets) {
            if(ticket.getId().equals(id)){
                ticketFound = ticket;
            }
        }
        return ticketFound;
    }

    public static void borrowVehicle(Scanner in) {
        System.out.println("Available vehicles:");
        for (int i = 0; i < vehicles.size(); i++) {
            if (vehicles.get(i).isAvailable()) {
                if (vehicles.get(i).getId().startsWith("B")){
                    System.out.println(i + " Bicycle " + vehicles.get(i).getColor());
                }
                if (vehicles.get(i).getId().startsWith("S")){
                    System.out.println(i + " Scooter " + vehicles.get(i).getColor());
                }
            }
        }
        System.out.println("Write the number of the vehicle that you want to borrow");
        Vehicle vehicle = vehicles.get(in.nextInt());


        System.out.println("Select the user:");
        for (int i = 0; i < users.size(); i++){
            System.out.println(i + users.get(i).getName());
        }
        User user = users.get(in.nextInt());
        genTicket(user, vehicle);
    }

    public static void genTicket(User user, Vehicle vehicle){
        Ticket ticket = new Ticket(user, vehicle);
        tickets.add(ticket);
        System.out.println(ticket.toString());
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