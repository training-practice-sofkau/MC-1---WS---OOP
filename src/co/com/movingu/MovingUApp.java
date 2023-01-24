package co.com.movingu;

import co.com.movingu.ticket.Ticket;
import co.com.movingu.user.Student;
import co.com.movingu.user.Trainer;
import co.com.movingu.user.User;
import co.com.movingu.vehicle.Bicycle;
import co.com.movingu.vehicle.Scooter;
import co.com.movingu.vehicle.Vehicle;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class MovingUApp {
    static LocalDateTime t = LocalDateTime.now();
    static LocalDateTime t1 = t.plusDays(1);
    static int fl = 1;
    static List<User> users = new ArrayList<>() {
        {
            add(new Student("0976152443", "Carolina Montoya", 24, "201547896", "FIEC"));
            add(new Trainer("0976152444", "Washington Pesantez", 36, "lecturer"));
        }
    };
    static List<Ticket> tickets = new ArrayList<>() {{
        add(new Ticket("T-001", t, t1, "OK", true, 0, "B-002", "Carolina Montoya"));
        add(new Ticket("T-002", t, t1, "OK", true, 0, "S-001", "Washington Pesantez"));
        //add(new Ticket());

    }};
    static List<Vehicle> vehicles = new ArrayList<>() {{
        add(new Bicycle(true, "B-001", "red", true, "M"));
        add(new Bicycle(false, "B-002", "blue", false, "M"));
        //add(new Bicycle("B-003","red",true, true, "R"));
        //add(new Bicycle("B-004","green",false, true, "R"));
        //add(new Bicycle("B-005","grey",true, true, "M"));
        add(new Scooter(false, "S-001", "black", true, 20));
        add(new Scooter(true, "S-002", "blue", true, 50));
        //add(new Scooter("S-003","grey",true, true, 80));
        //add(new Scooter("S-004","grey",true, false, 50));
        //add(new Scooter("S-005","black",false, false, 50));

    }};

    public static void main(String[] args) {
        //Lists that contains data related to the WS


        //TO DO: Implement the necessary logic to make the menu work
        while (fl != 0) {
            menu();
        }


    }

    public static void menu() {
        System.out.println("Moving - U");
        System.out.println("1. Register user");
        System.out.println("2. Borrow/Return");
        System.out.println("3. Pay a ticket");
        System.out.println("4. Check availability");
        System.out.println("5. Exit");
        Scanner sc = new Scanner(System.in);
        String option = sc.nextLine();
        switch (option) {
            case "1":
                registerUser();
                break;
            case "2":
                borrowReturn();
                break;
            case "3":
                payTicket();
                break;
            case "4":
                checkAvailability();
                break;
            case "5":
                fl = 0;
                break;
        }
    }

    public static void registerUser() {
        String category = "";
        Scanner sc = new Scanner(System.in);
        //Ask the commom data: DNI, Name, age.
        System.out.print("Enter your DNI: ");
        String dni = sc.nextLine();
        System.out.print("Enter your name: ");
        String name = sc.nextLine();
        System.out.print("Enter your age: ");
        int age = Integer.parseInt(sc.nextLine());
        System.out.print("User is: Student (S) / Trainer (T)");
        String type = sc.nextLine();
        switch (type) {
            case "S":
                // Ask the college DNI and the faculty
                System.out.print("Please enter your college DNI: ");
                String collegeDni = sc.nextLine();
                System.out.print("Please enter your faculty: ");
                String faculty = sc.nextLine();
                //create the student object
                User s = new Student(dni, name, age, collegeDni, faculty);
                users.add(s);
                //Display a message: User was registered
                System.out.print("User registered");
                break;

            case "T":
                // Ask if Trainer is Lecturer or Professor
                System.out.print("Are you a Lecturer(L) or Professor?(P): [L/P]");
                String trainerType = sc.nextLine();
                category = ((trainerType == "L") ? ("Lecturer") : ("Professor"));
                //create the trainer object
                User t = new Trainer(dni, name, age, category);
                users.add(t);
                //Display a message: User was registered
                System.out.print("User registered");
                break;

        }
    }

    public static void borrowReturn() {
        System.out.print("Will you borrow (1) or will you return (2) a vehicle?: ");
        Scanner sc = new Scanner(System.in);
        String option = sc.nextLine();
        switch (option) {
            case "1":
                System.out.print("Enter the User DNI: ");
                String userDni = sc.nextLine();
                //Search for User in array and determines current user
                User userC = null;
                for (User user : users) {

                    if (user.getDni().equals(userDni)) {
                        userC = user;

                        if (user.getBlocked() || user.getTicketOn()) {
                            user.statusMsg();
                            break;
                        } else {
                            borrow(userC.getName());
                            break;
                        }


                    } else if (userC == null) {
                        System.out.println("User does not exist");
                        System.out.println("Please create a User first");
                        break;
                    }


                }
            case "2":
                LocalDateTime t = LocalDateTime.now();
                returnTicket(t);
        }

    }


    public static void payTicket() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter Ticket number: ");
        String ticketId = sc.nextLine();
        for (Ticket Ticket : tickets) {
            if (Ticket.getId().equals(ticketId)) {
                Ticket.setStatus("OK");
                System.out.print("Ticket has been paid");
                break;
            }
        }


        //Search for User in array

    }

    public static void checkAvailability() {
        vehiclesCount();
    }

    public static void vehiclesCount() {
        int bikes = 0;
        int scooters = 0;
        for (Vehicle vehicle : vehicles) {
            if (vehicle.getCode().startsWith("B") && vehicle.isAvailable()) {
                bikes++;
            } else if (vehicle.getCode().startsWith("S") && vehicle.isAvailable()) {
                scooters++;
            }
        }
        System.out.println("Number of Bikes: " + bikes);
        System.out.println("Number of Scooters: " + scooters);
    }

    public static void borrow(String user) {
        List<Vehicle> bicycles = new ArrayList<>() {{
        }}; //List of available bicycles
        List<Vehicle> scooters = new ArrayList<>() {{
        }}; //List of available scooters
        for (Vehicle vehicle : vehicles) {
            if (vehicle.getCode().startsWith("B") && vehicle.isAvailable()) {
                bicycles.add(vehicle);
            } else if (vehicle.getCode().startsWith("S") && vehicle.isAvailable()) {
                scooters.add(vehicle);
            }
        }
        Scanner sc = new Scanner(System.in);
        System.out.println("There are");
        vehiclesCount();
        System.out.println("What kind of vehicle do you want?");
        System.out.println("1. Bicycle");
        System.out.println("2. Scooter");
        String v = sc.nextLine();
        Random rand = new Random();
        LocalDateTime tm = LocalDateTime.now();
        int n = tickets.size();
        n = n++;
        switch (v) {
            case "1":

                String id = "T-00" + n;
                Bicycle bike = (Bicycle) bicycles.get(rand.nextInt(bicycles.size()));
                String bikecode = bike.getCode();
                Ticket t = new Ticket(id, tm, null, "OK", true, 0, bikecode, user);
                tickets.add(t);
                System.out.println("The ticket has been issued");
                System.out.println(t.getId());
                break;
            case "2":

                id = "T-" + n;
                Scooter scoot = (Scooter) scooters.get(rand.nextInt(scooters.size()));
                String scootcode = scoot.getCode();
                t = new Ticket(id, tm, null, "OK", true, 0, scootcode, user);
                tickets.add(t);
                System.out.println("The ticket has been issued");
                System.out.println(t.getId());
                break;
        }

    }

    public static void returnTicket(LocalDateTime time) {
        int debtMoney = 0;
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the Ticket id: ");
        String ticketId = sc.nextLine();
        Ticket ticketC = null;
        System.out.print("Is the vehicle damaged?: [Y/N]");
        String damagedV = sc.nextLine();
        System.out.print("Helmet was returned?: [Y/N]");
        String damagedH = sc.nextLine();


        for (Ticket ticket : tickets) {
            if (ticket.getId().equals(ticketId)) {
                ticketC = ticket;
                break;

            }
        }
        ticketC.setTimeEnd(time);
        String vehicleC = ticketC.getVehicle();
        for (Vehicle vehicle : vehicles) {
            if (vehicle.getCode() == vehicleC) {
                vehicle.setAvailable(true);

                break;
            }
        }
            if (damagedV.equals("Y")) {
                if (vehicleC.startsWith("B")) {
                    debtMoney = debtMoney + 20;
                } else {
                    debtMoney = debtMoney + 30;
                }
            }
            if (damagedH.equals("N")) {
                debtMoney = debtMoney + 10;
            }

            ticketC.setDebt(debtMoney);
            ticketC.setStatus("Pending");
            System.out.println("The ticket has been processed");
            System.out.println("There is a debt of: " + ticketC.getDebt());



        }
    }





