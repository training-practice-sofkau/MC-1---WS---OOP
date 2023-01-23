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
    static List<User> users = new ArrayList<>() {{
        add(new Student("0976152443", "Carolina Montoya", 24, "201547896", "FIEC"));
        add(new Trainer("0976152443", "Washington Pesantez", 36, "lecturer"));
    }};

    public static void main(String[] args) {
        //Lists that contains data related to the WS


        List<Vehicle> vehicles = new ArrayList<>() {{
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

        List<Ticket> tickets = new ArrayList<>() {{
            //add(new Ticket());
            //add(new Ticket());
            //add(new Ticket());

        }};

        //TO DO: Implement the necessary logic to make the menu work
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
        //Ask the commom data: DNI, Name, age.
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
                pressEnter();
                break;
        }
    }

     static public void pressEnter(){
        System.out.println("Press intro to continue");
        input.nextLine();
    }

}