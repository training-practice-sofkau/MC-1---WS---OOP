package co.com.movingu;

import co.com.movingu.ticket.Ticket;
import co.com.movingu.user.Student;
import co.com.movingu.user.Trainer;
import co.com.movingu.user.User;
import co.com.movingu.vehicle.Bicycle;
import co.com.movingu.vehicle.Scooter;
import co.com.movingu.vehicle.Vehicle;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;

public class MovingUApp {
    static Scanner input = new Scanner(System.in);
    static Scanner inputNumber = new Scanner(System.in);
    static boolean found;

    //Lists that contains data related to the WS
    static List<User> users = new ArrayList<>() {{
        add(new Student("0976152444", "Carolina Montoya", 24, "201547896", "FIEC"));
        add(new Trainer("0976152443", "Washington Pesantez", 36, "lecturer"));
    }};
    static List<Bicycle> bicycles = new ArrayList<>() {{
        add(new Bicycle("B-001","red"));
        add(new Bicycle("B-002","blue"));
        add(new Bicycle("B-003","red"));
        add(new Bicycle("B-004","green"));
        add(new Bicycle("B-005","grey"));
        }};
    static List<Scooter> scooters = new ArrayList<>(){{
        add(new Scooter("S-001","black"));
        add(new Scooter("S-002","blue"));
        add(new Scooter("S-003","grey"));
        add(new Scooter("S-004","grey"));
        add(new Scooter("S-005","black"));
    }};
    static List<Ticket> tickets = new ArrayList<>() {{
        //add(new Ticket());
        //add(new Ticket());
        //add(new Ticket());
    }};

    public static void main(String[] args) {

        //TODO: Implement the necessary logic to make the menu work
        menu(0);
    }

    public static void menu(int option) {
        while (option != 5) {
            System.out.println("Moving - U");
            System.out.println("1. Register user");
            System.out.println("2. Borrow/Return");
            System.out.println("3. Pay a ticket");
            System.out.println("4. Check availability");
            System.out.println("5. Exit");
            option = inputNumber.nextInt();
            switch (option) {
                case 1:
                    registerUser();
                    break;
                case 2:
                    System.out.println("Choose your option: Borrow(B) or Return(R)");
                    if (input.nextLine().equalsIgnoreCase("B")){
                        borrow();
                    }
                    if (input.nextLine().equalsIgnoreCase("R")){
                        returning();
                    }
                    break;
                case 3:

                    break;
                case 4:
                    System.out.println("Choose a vehicle Bicycle(B) or Scooter(S)");
                    String choose = input.nextLine().toUpperCase();
                    checkVhAvailability(choose);
                    break;
                case 5:
                    break;
                default:
                    System.out.println("********** You enter an invalid input, try again **********");
                    break;
            }
        }
    }

    private static void returning() {
    }

    public static void registerUser() {
        //Ask the common data: DNI, Name, age.
        System.out.println("Type the dni");
        String dni = input.nextLine();
        System.out.println("Type the Name");
        String name = input.nextLine();
        System.out.println("Type the age");
        int age = inputNumber.nextInt();
        System.out.print("User is: Student (S) / Trainer (T): \n");
        String type = input.nextLine().toUpperCase();
        switch (type) {
            case "S":
                // Ask the college DNI and his faculty
                System.out.println("Type the collegeDNI");
                String cdni = input.nextLine();
                System.out.println("Type the faculty");
                String faculty = input.nextLine();
                //create the student object
                User s = new Student(dni, name, age, cdni, faculty);
                users.add(s);
                //Display a message: User was registered
                System.out.println("The student " + name + " with dni: " + dni + " was succesfully created");
                break;
            case "T":
                // Ask the category
                System.out.println("Type the category");
                String category = input.nextLine();
                //create the student object
                User t = new Trainer(dni, name, age, category);
                users.add(t);
                //Display a message: User was registered
                System.out.println("The trainer " + name + " with dni: " + dni + " was succesfully created");
                break;
            default:
                System.out.println("********** You enter an invalid input, try again **********");
                pressIntro();
                break;
        }
    }

    static void borrow() {
        System.out.println("Please enter the dni");
        String usrDNI = input.nextLine();
        found = false;
        for (User u : users) {
            if (u.getDni().equals(usrDNI)) {
                found = true;
                if (u.getTicketOn() == "") {
                    if (!u.isBlocked()) {
                        System.out.println("Choose a vehicle Bicycle(B) or Scooter(S)");
                        String choose = input.nextLine().toUpperCase();
                        checkVhAvailability(choose);
                        System.out.println("Write the id of the bicycle to borrow");
                        changeAvOfBicycleById(input.nextLine().toUpperCase());
                        int ticketID = createTicket();
                        u.setTicketOn();
                        break;
                    } else {
                        System.out.println("The user has a debt, he/she can't borrow until the situation is resolved");
                        pressIntro();
                        break;
                    }
                } else {
                    System.out.println("The user already has loan of a vehicle which Ticket is: " + u.getTicketOn() + "\n" +
                            "he/she can't borrow until the situation is resolved");
                    pressIntro();
                    break;
                }
            }
            if (!found) {
                System.out.println("User dni does not exist, register the user first to proceed");
                pressIntro();
                break;
            }
        }

    }

    static void checkVhAvailability(String choose) {
        int availables;
        switch (choose) {
            case "B":
                availables = 0;
                for (Bicycle b : bicycles) {
                    if (b.isAvailable()){
                        availables++;
                        System.out.println(b.toString());
                    }
                }
                if(availables == 0){
                    System.out.println("There's no bicycles available");
                }
                break;

            case "S":
                availables = 0;
                for (Scooter s : scooters) {
                    if (s.isAvailable()){
                        availables++;
                        System.out.println(s.toString());
                    }
                }
                if(availables == 0){
                    System.out.println("There's no scooters available");
                }
                System.out.println("Write the id of the bicycle to borrow");
                changeAvOfScooterById(input.nextLine().toUpperCase());
                break;

            default:
                System.out.println("********** You enter an invalid input, try again **********");
                pressIntro();
                break;
        }
    }

    static void changeAvOfBicycleById(String id){
        found = false;
        for (Vehicle b : bicycles) {
            if (Objects.equals(b.getVId(), id)){
                found = true;
                b.updateAvailability(!b.isAvailable());
                System.out.println("Bicycle availability changed");
                pressIntro();
                break;
            }
            System.out.println(b.toString());
        }
        if (!found){
            System.out.println("The bicycle with id: " + id + " does not exist");
        }
    }

    static void changeAvOfScooterById(String id){
        found = false;
        for (Vehicle b : scooters) {
            if (Objects.equals(b.getVId(), id)){
                found = true;
                b.updateAvailability(!b.isAvailable());
                System.out.println("Scooter availability changed");
                pressIntro();
                break;
            }
            System.out.println(b.toString());
        }
        if (!found){
            System.out.println("The scooter with id: " + id + " does not exist");
        }
    }

    static int createTicket() {
        Ticket ticket = new Ticket("",Ticket.Status.Active);
        return 0;
    }

    static void pressIntro() {
        System.out.println("Press intro to continue");
        input.nextLine();
    }

}