package co.com.movingu;

import co.com.movingu.ticket.Ticket;
import co.com.movingu.user.Student;
import co.com.movingu.user.Trainer;
import co.com.movingu.user.User;
import co.com.movingu.vehicle.Bicycle;
import co.com.movingu.vehicle.Scooter;
import co.com.movingu.vehicle.Vehicle;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MovingUApp {

    static Scanner input = new Scanner(System.in);
    static List<User> users = new ArrayList<>() {{
        add(new Student("1234", "Carolina Montoya", 25, "201547896", "FIEC"));
        add(new Trainer("1235", "Oscar Tabares", 36, "lecturer"));
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
        //add(new Ticket(users.get(0), vehicles.get(0)));
        //add(new Ticket(users.get(1), vehicles.get(1)));
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
                    Scanner userInput = new Scanner(System.in);
                    System.out.print("Please, press 1 for Borrow or press 2 for Return: ");
                    int process = userInput.nextInt();

                    if(process == 1) {
                        borrowVehicle();
                    }
                    if(process == 2) {
                        returnVehicle();
                    }
                    break;
                case 3:
                    payATicket();
                    break;
                case 4:
                    checkAvailability();
                    break;
                case 5:
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
                System.out.print("Please, enter your DNI: ");
                String StudentDNI = userInput.next();

                System.out.print("Please, enter your name: ");
                String StudentName = userInput.next();

                System.out.print("Please, enter your age: ");
                int StudentAge = userInput.nextInt();

                System.out.print("Please, enter your College DNI: ");
                String collegeDNI = userInput.next();

                System.out.print("Please, enter the Faculty acronym: ");
                String facultyAcronym = userInput.next();

                //create the student object
                User student = new Student(StudentDNI, StudentName, StudentAge, collegeDNI, facultyAcronym);
                users.add(student);

                //Display a message: User was registered
                System.out.println("The student " + student.getName() + " was registered successfully!");
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
                System.out.println("The Trainer " + trainer.getName() + " was registered successfully!");
                break;
        }
    }

    public static void borrowVehicle() {

        User userFound = null;
        Vehicle borrowedVehicle;
        boolean vehicleFounded = false;
        Scanner userInput = new Scanner(System.in);

        System.out.print("Please, enter your DNI: ");
        String userDNI = userInput.next();

        for(User user : users){
            if(user.getDni().equalsIgnoreCase(userDNI)){
                userFound = user;
            }
        }

        if(userFound.isTicketOn() || userFound.isBlocked()){
            userFound.statusMsg();
        } else {
            System.out.println("Please, press 1 for Scooter or press 2 for Bicycle: ");
            int typeofVehicle = userInput.nextInt();

            if (typeofVehicle == 1){
                for(Vehicle vehicle: vehicles){
                    if(vehicle.getClass() == Scooter.class && vehicle.isAvailable()){
                        vehicleFounded = true;
                        borrowedVehicle = vehicle;
                        borrowedVehicle.setAvailable(false);
                        userFound.setBlocked(true);
                        userFound.setTicketOn(true);
                        Ticket ticket = new Ticket(userFound, borrowedVehicle);
                        tickets.add(ticket);
                        ticket.updateTicketStatus("Active");
                        System.out.println("The transaction was made successfully, Here is your ticket: ");
                        System.out.println(ticket);
                        System.out.println();
                        break;
                    }
                }
            }

            if (typeofVehicle == 2){
                for(Vehicle vehicle: vehicles){
                    if(vehicle.getClass() == Bicycle.class && vehicle.isAvailable()){
                        vehicleFounded = true;
                        borrowedVehicle = vehicle;
                        borrowedVehicle.setAvailable(false);
                        userFound.setBlocked(true);
                        userFound.setTicketOn(true);
                        Ticket ticket = new Ticket(userFound, borrowedVehicle);
                        tickets.add(ticket);
                        ticket.updateTicketStatus("Active");
                        System.out.println("The transaction was made successfully, Here is your ticket: ");
                        System.out.println(ticket);
                        System.out.println();
                        break;
                    }
                }
            }
            if (!vehicleFounded) {
                System.out.println("Unfortunately, all the vehicles of the selected type are borrowed");
                System.out.println();
            }
        }
    }

    public static void returnVehicle() {

        Vehicle returnedVehicle = null;
        Ticket returnedTicket = null;
        Scanner userInput = new Scanner(System.in);

        System.out.println("Please, enter your Ticket Id: ");
        String ticketId = userInput.next();

        for (Ticket ticket: tickets) {
            if(ticket.getId().equalsIgnoreCase(ticketId)) {
                returnedTicket = ticket;
                returnedVehicle = ticket.getVehicle();
            }
        }

    if(returnedTicket != null) {

        if(returnedVehicle.getClass() == Scooter.class) {
            returnedTicket.setReturnDate(LocalDateTime.now());

            System.out.println("Please, press 1 if you return the helmet or 2 if not");
            int checkHelmet = userInput.nextInt();
            returnedTicket.setIsThereAHelmet(checkHelmet);

            System.out.println("Please, press 1 if you returned the vehicle in a good condition or 2 if not");
            int checkDamage = userInput.nextInt();
            returnedTicket.setDamaged(checkDamage);
            returnedVehicle.setUsable(checkHelmet);

            System.out.println("Please, enter the percentage of the battery");
            int batteryPercentage = userInput.nextInt();
            ((Scooter) returnedVehicle).setBatteryPercentage(batteryPercentage);

            if(returnedTicket.isDamaged() || returnedTicket.getIsThereAHelmet()) {
                returnedTicket.updateTicketStatus("Pending");
            } else {
                returnedTicket.updateTicketStatus("OK");
            }

            returnedVehicle.setAvailable(true);
            returnedTicket.setAmountToPay();
            System.out.println("Here is: " + returnedTicket);
            }

        if(returnedVehicle.getClass() == Bicycle.class) {
            returnedTicket.setReturnDate(LocalDateTime.now());

            System.out.println("Please, press 1 if you return the helmet or 2 if not");
            int checkHelmet = userInput.nextInt();
            returnedTicket.setIsThereAHelmet(checkHelmet);

            System.out.println("Please, press 1 if you returned the vehicle in a good condition or 2 if not");
            int checkDamage = userInput.nextInt();
            returnedTicket.setDamaged(checkDamage);
            returnedVehicle.setUsable(checkHelmet);

            if(returnedTicket.isDamaged() || returnedTicket.getIsThereAHelmet()) {
                returnedTicket.updateTicketStatus("Pending");
            } else {
                returnedTicket.updateTicketStatus("OK");
            }
            returnedVehicle.setAvailable(true);
            returnedTicket.setAmountToPay();
            System.out.println("Here is: " + returnedTicket);

        }

    } else {
        System.out.println("Please, enter a valid ticket id");
    }
    }

    private static void payATicket () {

        User releasedUser = null ;
        Ticket releasedTicket = null;
        Scanner userInput = new Scanner(System.in);

        System.out.print("Please, enter your Ticket Id: ");
        String ticketId = userInput.next();

        for (Ticket ticket : tickets) {
            if(ticket.getId().equalsIgnoreCase(ticketId)){
                releasedTicket = ticket;
                releasedUser = ticket.getUser();
            }
        }
        releasedTicket.updateTicketStatus("OK");
        releasedUser.setTicketOn(false);
        releasedUser.setBlocked(false);
        System.out.println("Your Ticket was successfully paid");
    }

    private static void checkAvailability () {

        int numOfScooters = 0;
        int numOfBicycles = 0;

        for ( Vehicle vehicle : vehicles) {
            if(vehicle.getClass() == Scooter.class){
                if(vehicle.isAvailable()){
                    numOfScooters++;
                }
            }
            if(vehicle.getClass() == Bicycle.class){
                if(vehicle.isAvailable()){
                    numOfBicycles++;
                }
            }
        }
        System.out.println("There are: " + numOfScooters + " scooters available");
        System.out.println("There are: " + numOfBicycles + " Bicycles available");
        System.out.println();
    }
}
