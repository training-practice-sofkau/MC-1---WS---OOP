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
import java.util.*;

public class MovingUApp {
    static Scanner input = new Scanner(System.in);
    static Scanner inputNumber = new Scanner(System.in);
    static boolean found;

    //Lists that contains data related to the WS
    static List<User> users = new ArrayList<>() {{
        add(new Student("123", "Carolina Montoya", 24, "201547896", "FIEC"));
        add(new Trainer("124", "Washington Pesantez", 36, "lecturer"));
    }};
    static List<Bicycle> bicycles = new ArrayList<>() {{
        add(new Bicycle("B-001", "red", true, true, "M"));
        add(new Bicycle("B-002", "blue", false, false, "M"));
        add(new Bicycle("B-003", "red", true, true, "R"));
        add(new Bicycle("B-004", "green", false, true, "R"));
        add(new Bicycle("B-005", "grey", true, true, "M"));
    }};
    static List<Scooter> scooters = new ArrayList<>() {{
        add(new Scooter("S-001", "black", false, true, 20));
        add(new Scooter("S-002", "blue", true, true, 50));
        add(new Scooter("S-003", "grey", true, true, 80));
        add(new Scooter("S-004", "grey", true, false, 50));
        add(new Scooter("S-005", "black", false, false, 50));
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
                    String op = input.nextLine();
                    switch (op.toUpperCase()) {
                        case "B":
                            borrow();
                            break;
                        case "R":
                            returning();
                            break;
                        default:
                            System.out.println("********** You enter an invalid input, try again **********");
                            pressIntro();
                            break;
                    }
                    break;
                case 3:
                    for(Ticket t : tickets){
                        System.out.println("Ticket id: "+t.getTicketId());
                    }
                    System.out.println("Type the ticket id you want to pay: ");
                    String ticketId = input.nextLine();
                    Ticket t = searchTicket(ticketId);

                    if(t != null){
                        System.out.println("Pay $" + t.getDebt()+ "?(Y/N): ");

                        if (input.nextLine().toUpperCase().equals("Y")){
                            Vehicle toReturn = searchVehicle(t.getVehicleId());
                            User usr = searchUser(t.getUsrID());

                            if (toReturn != null && usr != null) {
                                toReturn.setGoodCondition(true);
                                toReturn.updateAvailability(true);
                                if(toReturn instanceof Scooter){
                                    ((Scooter) toReturn).setBattery(100);
                                }
                                t.setStatus(Ticket.Status.Ok);
                                usr.setBlocked(false);
                                usr.setTicketOn("");
                                System.out.println("Debt was payed, user free to borrow again, vehicle repaired and available to be borrowed");
                                pressIntro();
                            }
                        }
                    }else {
                        System.out.println("That ticket id does not exist");
                    }
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
                    pressIntro();
                    break;
            }
        }
    }

    public static void returning() {
        System.out.println("Please enter the ticket id to continue");
        String ticketId = input.nextLine();
        Ticket ticket = searchTicket(ticketId);

        if (ticket != null) {
            Vehicle toReturn = searchVehicle(ticket.getVehicleId());
            User usr = searchUser(ticket.getUsrID());

            if (toReturn != null && usr != null) {
                ticket.setStatus(Ticket.Status.Pending);
                //Calculate debt
                double hoursDiff = ticket.getDateOfBorrow().getHour() - LocalDateTime.now().getHour();

                if (hoursDiff > 0) {
                    System.out.println("Date 1 occurs after Date 2");
                    double value = ticket.getDebt() + 3 * (int)(hoursDiff / 30);
                    ticket.updateDebt(value);
                }

                System.out.println("Has helmet?(Y/N): ");
                if(input.nextLine().toUpperCase().equals("N")){
                    double value = ticket.getDebt() + 10;
                    ticket.updateDebt(value);
                } else{
                    System.out.println("Helmet has damage?(Y/N): ");
                    if(input.nextLine().toUpperCase().equals("Y")){
                        double value = ticket.getDebt() + 5;
                        ticket.updateDebt(value);
                    }
                }
                System.out.println("is the vehicle damaged?(Y/N): ");
                if(input.nextLine().toUpperCase().equals("Y")){
                    if(toReturn instanceof Bicycle){
                        double value = ticket.getDebt() + 20;
                        ticket.updateDebt(value);
                    } else if (toReturn instanceof Scooter) {
                        double value = ticket.getDebt() + 30;
                        ticket.updateDebt(value);
                        ((Scooter) toReturn).setBattery(((Scooter) toReturn).getBattery() - 20);
                    }

                }

                usr.setBlocked(true);

            }

        }
    }

    public static User searchUser(String userId) {
        User usr = null;
        for (User u : users) {
            if (Objects.equals(u.getDni(), userId)) {
                usr = u;
            }
        }
        return usr;
    }

    public static Vehicle searchVehicle(String vehicleId) {
        Vehicle vehicle = null;
        for (Vehicle v : bicycles) {
            if (v.getVId().equals(vehicleId)) {
                vehicle = v;
                break;
            }
        }
        for (Vehicle v : scooters) {
            if (v.getVId().equals(vehicleId)) {
                vehicle = v;
                break;
            }
        }
        return vehicle;
    }

    private static void payTicket() {
        System.out.println("Type the ticket id: ");
        String ticketId = input.nextLine();
        searchTicket(ticketId);
        pressIntro();
    }

    public static Ticket searchTicket(String ticketId) {
        found = false;
        Ticket ticket = null;
        for (Ticket t : tickets) {
            if (t.getTicketId().equals(ticketId)) {
                t.setStatus(Ticket.Status.Ok);
                found = true;
                ticket = t;
                break;
            }
        }
        if (!found) {
            System.out.println("No ticket wit id: " + ticketId + " was found");
        }
        return ticket;
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
        for (User u : users) {
            System.out.println(u.toString());
        }
    }

    static void borrow() {
        System.out.println("Please enter the dni");
        String usrDNI = input.nextLine();
        found = false;
        for (User u : users) {
            if (u.getDni().equals(usrDNI)) {
                found = true;
                if (Objects.equals(u.getTicketOn(), "")) {
                    if (!u.isBlocked()) {

                        System.out.println("Choose a vehicle Bicycle(B) or Scooter(S)");
                        String choose = input.nextLine().toUpperCase();
                        checkVhAvailability(choose);
                        int randInt = -1;

                        switch (choose) {
                            case "B":
                                do {
                                    randInt = (int) (Math.random() * (bicycles.size()));
                                } while (!bicycles.get(randInt).isAvailable());
                                changeAvOfBicycleById(randInt);
                                System.out.println("You got the " + bicycles.get(randInt).getColor() + " bicycle");
                                break;
                            case "S":
                                do {
                                    randInt = (int) (Math.random() * (scooters.size()));
                                } while (!scooters.get(randInt).isAvailable());
                                changeAvOfScooterById(randInt);
                                System.out.println("You got the " + bicycles.get(randInt).getColor() + " scooter");
                                break;
                            default:
                                System.out.println("********** You enter an invalid input, try again **********");
                                pressIntro();
                                break;
                        }
                        String ticketID = createTicket(u.getDni(), scooters.get(randInt).getVId());
                        u.setTicketOn(ticketID);
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
        }
        if (!found) {

            System.out.println("User dni does not exist, register the user first to proceed");
            pressIntro();

        }

    }

    static void checkVhAvailability(String choose) {
        int availables;
        switch (choose) {
            case "B":
                availables = 0;
                for (Bicycle b : bicycles) {
                    if (b.isAvailable()) {
                        availables++;
                    }
                }
                if (availables == 0) {
                    System.out.println("There are no bicycles available");
                } else {
                    System.out.println("There are " + availables + " bicycles available");
                }
                break;

            case "S":
                availables = 0;
                for (Scooter s : scooters) {
                    if (s.isAvailable()) {
                        availables++;
                    }
                }
                if (availables == 0) {
                    System.out.println("There ars no scooters available");
                } else {
                    System.out.println("There are " + availables + " scooters available");
                }
                break;

            default:
                System.out.println("********** You enter an invalid input, try again **********");
                pressIntro();
                break;
        }
    }

    static void changeAvOfBicycleById(int index) {
        Bicycle bike = bicycles.get(index);
        if (bike.isAvailable()) {
            bike.updateAvailability(!bike.isAvailable());
        }
    }

    static void changeAvOfScooterById(int index) {
        Scooter sco = scooters.get(index);
        if (sco.isAvailable()) {
            sco.updateAvailability(!sco.isAvailable());
        }
    }

    static String createTicket(String usrID, String vehicleId) {
        Ticket ticket = new Ticket(String.valueOf(tickets.size()), Ticket.Status.Active, usrID, vehicleId);
        tickets.add(ticket);
        System.out.println("Ticket created successfully, ticket id: " + ticket.getTicketId());
        return ticket.getTicketId();
    }

    static void pressIntro() {
        System.out.println("Press intro to continue");
        input.nextLine();
    }

}