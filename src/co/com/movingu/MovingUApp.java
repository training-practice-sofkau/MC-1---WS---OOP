package co.com.movingu;

import co.com.movingu.ticket.Ticket;
import co.com.movingu.user.Student;
import co.com.movingu.user.Trainer;
import co.com.movingu.user.User;
import co.com.movingu.vehicle.Vehicle;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MovingUApp {
    static Scanner input = new Scanner(System.in);
    static Scanner inputNumber = new Scanner(System.in);
    static boolean found;

    //Lists that contains data related to the WS
    static List<User> users = new ArrayList<>() {{
        add(new Student("0976152443", "Carolina Montoya", 24, "201547896", "FIEC"));
        add(new Trainer("0976152443", "Washington Pesantez", 36, "lecturer"));
    }};
    static List<Vehicle> vehicles = new ArrayList<>() {{
        //add(new Bicycle("B-001","red",true, true, "M"));
        //add(new Bicycle("B-002","blue",false, false, "M"));
        //add(new Bicycle("B-003","red",true, true, "R"));
        //add(new Bicycle("B-004","green",false, true, "R"));
        //add(new Bicycle("B-005","grey",true, true, "M"));
        //add(new Scooter("S-001","black",false, true, 20));
        //add(new Scooter("S-002","blue",true, true, 50));
        //add(new Scooter("S-003","grey",true, true, 80));
        //add(new Scooter("S-004","grey",true, false, 50));
        //add(new Scooter("S-005","black",false, false, 50));

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
                    borrowReturn();
                    break;
                case 3:
                    break;
                case 4:
                    break;
                case 5:
                    break;
                default:
                    System.out.println("********** You enter an invalid input, try again **********");
                    break;
            }
        }
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

    static void borrowReturn() {
        System.out.println("Please enter the dni");
        String usrDNI = input.nextLine();
        found = false;

        for (User u : users) {
            if (u.getDni().equals(usrDNI)) {
                found = true;
                if (u.getTicketOn() == 0) {
                    if (!u.isBlocked()) {

                        checkVhAvailability();
                        createTicket();
                    } else {
                        System.out.println("The user has a debt, he/she can't borrow until the situation is resolved");
                        pressIntro();
                    }
                } else {
                    System.out.println("The user already has loan of a vehicle which Ticket is: " + u.getTicketOn() + "\n" +
                            "he/she can't borrow until the situation is resolved");
                    pressIntro();
                }
            }
            if (!found) {
                System.out.println("User dni does not exist, register the user first to proceed");
                pressIntro();
            }
        }

    }

    static void checkVhAvailability() {
        System.out.println("Choose a vehicle Bicycle(B) or Scooter(S)");
        String choose = input.nextLine().toUpperCase();
        switch (choose) {
            case "B":
                for (Vehicle v : vehicles) {
                    //TODO: only bicycles
                    System.out.println(v.toString());
                }
                System.out.println("X");
                break;
            case "S":
                for (Vehicle v : vehicles) {
                    //TODO: only scooters
                    System.out.println(v.toString());
                }
                System.out.println("Y");
                break;
            default:
                System.out.println("********** You enter an invalid input, try again **********");
                pressIntro();
                break;
        }
    }

    static void createTicket() {

    }

    static void pressIntro() {
        System.out.println("Press intro to continue");
        input.nextLine();
    }

}