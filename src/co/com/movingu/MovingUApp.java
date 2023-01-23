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
import java.util.Scanner;

public class MovingUApp {

    static Scanner input = new Scanner(System.in);
    static List<User> users = new ArrayList<>() {{
        add(new Student("0976152443", "Carolina Montoya", 24, "201547896", "FIEC"));
        add(new Trainer("0976152443", "Washington Pesantez", 36, "lecturer"));
    }};

    static List<Vehicle> vehicles = new ArrayList<>() {{
            add(new Bicycle("B-001", "red", true, true, "M"));
            add(new Bicycle("B-002", "blue", false, false, "M"));
            add(new Bicycle("B-003", "red", true, true, "R"));
            add(new Bicycle("B-004", "green", false, true, "R"));
            add(new Bicycle("B-005", "grey", true, true, "M"));
            add(new Scooter("S-001", "black", false, true, 20));
            add(new Scooter("S-002", "blue", true, true, 50));
            add(new Scooter("S-003", "grey", true, true, 80));
            add(new Scooter("S-004", "grey", true, false, 50));
            add(new Scooter("S-005", "black", false, false, 50));
        }};
    static List<Ticket> tickets = new ArrayList<>() {{
            add(new Ticket());
            add(new Ticket());
            add(new Ticket());
        }};



    public static void main(String[] args) {
        menu();
    }

    public static void menu() {

        int option = 0;

        do {

            System.out.println("Moving - U");
            System.out.println("1. Register user");
            System.out.println("2. Borrow/Return");
            System.out.println("3. Pay a ticket");
            System.out.println("4. Check availability");
            System.out.println("5. Exit");

            System.out.print("Please, enter the option: ");
            option = input.nextInt();

            switch (option) {
                case 1:
                    registerUser();
                    break;
                case 2:
                    borrowReturn();
                    break;
                case 3:
                    payATicket();
                    break;
                case 4:
                    checkAvailability();
                    break;
                case 5:
                    break;
                default:
                    System.out.println("Please put a valid option");
                    break;
            }
        } while (option != 5);
        System.out.println("The program has finished");
    }


    public static void registerUser() {
        Scanner userInput = new Scanner(System.in);
        //Ask the common data: DNI, Name, age.
        System.out.print("Please, press 1 for Student or press 2 for Trainer: ");
        int type = userInput.nextInt();
        switch (type) {
            case 1:
                // All the student information
                System.out.println("Please, enter your DNI: ");
                String StudentDNI = userInput.next();

                System.out.println("Please, enter your name: ");
                String StudentName = userInput.next();

                System.out.println("Please, enter your age: ");
                int StudentAge = userInput.nextInt();

                System.out.println("Please, enter your College DNI: ");
                String collegeDNI = userInput.next();

                System.out.println("Please, enter the Faculty acronym: ");
                String facultyAcronym = userInput.next();

                //create the student object
                User student = new Student(StudentDNI, StudentName, StudentAge, collegeDNI, facultyAcronym);
                users.add(student);

                //Display a message: User was registered
                System.out.println("The student was registered successfully!");
                System.out.println(student);
                break;

            case 2:
                // All the trainer information
                System.out.print("Please, enter your DNI: ");
                String TrainerDNI = userInput.next();

                System.out.print("Please, enter your name: ");
                String TrainerName = userInput.next();

                System.out.print("Please, enter your age: ");
                int TrainerAge = userInput.nextInt();

                System.out.print("Please, enter your Category: ");
                String category = userInput.next();

                //create the student object
                User trainer = new Trainer(TrainerDNI, TrainerName, TrainerAge, category);
                users.add(trainer);

                //Display a message: User was registered
                System.out.println("The Trainer was registered successfully!");
                System.out.println(trainer);
                break;
        }
    }

    public static void borrowReturn() {

        Scanner userInput = new Scanner(System.in);

        System.out.print("Please, press 1 for Borrow or press 2 for Return: ");
        int type = userInput.nextInt();
        switch (type) {
            case 1:
                // All the student information
                System.out.println("Please, enter your DNI: ");
                String StudentDNI = userInput.next();
            case 2:
                System.out.println("Please, enter your Ticket Id: ");
                String ticketId = userInput.next();
        }
    }

    private static void payATicket () {

    }
    private static void checkAvailability () {

        int numOfScooters = 0;
        int numOfBicycles = 0;

        for ( int i = 0; i < vehicles.size(); i++) {
            if(vehicles.get(i).getClass() == Scooter.class){
                numOfScooters++;
            }
            if(vehicles.get(i).getClass() == Bicycle.class){
                numOfBicycles++;
            }
        }
        System.out.println("There are: " + numOfScooters + " scooters available");
        System.out.println("There are: " + numOfBicycles + " Bicycles available");
    }
}
