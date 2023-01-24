package co.com.movingu;

import co.com.movingu.ticket.Ticket;
import co.com.movingu.user.Student;
import co.com.movingu.user.Trainer;
import co.com.movingu.user.User;
import co.com.movingu.vehicle.Bicycle;
import co.com.movingu.vehicle.Scooter;
import co.com.movingu.vehicle.Vehicle;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class MovingUApp {
    static List<User> users = new ArrayList<>() {{
        add(new Student("000", "Carolina Montoya", 24, "201547896", "FIEC"));
        add(new Trainer("111", "Washington Pesantez", 36, "lecturer"));
    }};
    static Scanner sc = new Scanner(System.in);

    static Context context = new Context();

    public static void main(String[] args) {
        List<Vehicle> vehicles = new ArrayList<>() {{
            add(new Bicycle("123", true, "red", "Ready to use"));

            add(new Scooter("465", true, "black", "Ready to use"));

        }};

        List<Ticket> tickets = new ArrayList<>();

        boolean app = true;
        do {
            //TO DO: Implement the necessary logic to make the menu work
            menu();
            int answer = Integer.parseInt(sc.nextLine());
            switch (answer) {
                case 1:
                    registerUser(sc);
                    break;
                case 2:
                    System.out.println("Enter your personal DNI");
                    String personalDNI = sc.nextLine();
                    if (users.stream().anyMatch(user -> user.getDni().equals(personalDNI))) {
                        if (!tickets.stream().anyMatch(ticket -> ticket.getUserDni().equals(personalDNI) && !ticket.verifySolved())) {
                            System.out.println("---------> No tickets found");
                            borrowVehicle(sc, vehicles, personalDNI, tickets);
                        } else {
                            Ticket tempTicket = tickets.stream().filter(ticket -> ticket.getUserDni().equals(personalDNI) && !ticket.verifySolved()).collect(Collectors.toList()).get(0);
                            System.out.println("---------> To borrow a vehicle you first need to solve the ticket with ID " + tempTicket.getTicketId());
                            System.out.println("To solve it now enter (1)");
                            answer = Integer.parseInt(sc.nextLine());
                            if (answer == 1) {
                                solveTicket(sc, vehicles, personalDNI, tempTicket);
                            } else {
                                System.out.println("---------> Returning to main menu");
                            }
                        }
                    } else {
                        System.out.println("The user DNI was not found in the data base \n Register a new user to continue");
                    }
                    break;
                case 3:
                    System.out.println("Enter your personal DNI");
                    personalDNI = sc.nextLine();
                    if (tickets.stream().anyMatch(ticket -> ticket.getUserDni().equals(personalDNI) && !ticket.verifySolved())) {
                        Ticket tempTicket = tickets.stream().filter(ticket -> ticket.getUserDni().equals(personalDNI) && !ticket.verifySolved()).collect(Collectors.toList()).get(0);
                        if (tempTicket.getStatus().equals(tempTicket.STATUS_CASES[1])) {
                            payTicket(vehicles, tempTicket, personalDNI);
                        } else {
                            System.out.println("---------> You have an unsolved ticket but don't have debts from previous services");
                        }
                    } else {
                        System.out.println("---------> No tickets found");

                    }
                    break;
                    case 4:
                        System.out.println("There are "+ (int) vehicles.stream().filter(vehicle -> vehicle instanceof Bicycle && vehicle.isAvailable()).count() +" bicycles available");
                        System.out.println("There are "+ (int) vehicles.stream().filter(vehicle -> vehicle instanceof Scooter && vehicle.isAvailable()).count() +" scooters available");
                    break;
                    case 5:
                        app=false;
                        break;
            }
        } while (app);
        sc.close();
    }


    static void menu() {
        System.out.println("Moving - U");
        System.out.println("1. Register user");
        System.out.println("2. Borrow/Return");
        System.out.println("3. Pay a ticket");
        System.out.println("4. Check availability");
        System.out.println("5. Exit");
    }

    static void registerUser(Scanner sc) {
        //Ask the commom data: DNI, Name, age.
        System.out.println("User is: Student (1) / Trainer (2)");
        int type = Integer.parseInt(sc.nextLine());
        switch (type) {
            case 1:
                System.out.println("Please write down the students personal DNI");
                String studentsPersonalDNI = sc.nextLine();
                System.out.println("Please write down the students college DNI");
                String studentsCollegeDNI = sc.nextLine();
                System.out.println("Please write down the students faculty");
                String studentsFaculty = sc.nextLine();
                System.out.println("Please write down the students name");
                String studentsName = sc.nextLine();
                System.out.println("Please write down the students age");
                int studentsAge = Integer.parseInt(sc.nextLine());
                User s = new Student(studentsPersonalDNI, studentsName, studentsAge, studentsCollegeDNI, studentsFaculty);
                users.add(s);
                System.out.println("Student created successfully");
                break;
            case 2:
                System.out.println("Please write down the trainers personal DNI");
                String trainersPersonalDNI = sc.nextLine();
                System.out.println("Please write down the trainers college DNI");
                String trainersName = sc.nextLine();
                System.out.println("Please write down the trainers age");
                int trainerAge = Integer.parseInt(sc.nextLine());
                System.out.println("Please write '0' if the trainer is a professor , or '1' if the trainer is a lecturer");
                boolean category = Boolean.parseBoolean(sc.nextLine());
                User t = new Trainer(trainersPersonalDNI, trainersName, trainerAge, category ? "lecturer" : "professor");
                users.add(t);
                System.out.println("Trainer created successfully");
                break;
        }
    }

    static void borrowVehicle(Scanner sc, List<Vehicle> vehicles, String DNI, List<Ticket> tickets) {
        System.out.println("Would you like to borrow a bicycle (enter 1) or a scooter (enter 2)?");
        switch (sc.nextLine()) {
            case "1":
                Vehicle borrowingBicycle = checkAvailability(vehicles, "Bicycle");
                if (borrowingBicycle != null) {
                    borrowingBicycle.updateAvailability(false);
                    tickets.add(new Ticket(tickets, DNI, 1, borrowingBicycle.getUID()));
                    System.out.println("---------> Vehicle borrowed successfully");
                    break;
                } else {
                    System.out.println("---------> No vehicles available");
                }
                break;
            case "2":
                Vehicle borrowingScooter = checkAvailability(vehicles, "Scooter");
                if (borrowingScooter != null) {
                    borrowingScooter.updateAvailability(false);
                    tickets.add(new Ticket(tickets, DNI, 1, borrowingScooter.getUID()));
                    System.out.println("---------> Vehicle borrowed successfully");
                    break;
                } else {
                    System.out.println("---------> No vehicles available");
                }
                break;
        }
    }

    static void payTicket(List<Vehicle> vehicles, Ticket tempTicket, String personalDNI) {
        System.out.println("You have a debt from a previous service, would you like to cancel it?\nEnter (1) if you do");
        int answer = Integer.parseInt(sc.nextLine());
        if (answer == 1) {
            User tempUser = users.stream().filter(user -> user.getDni().equals(personalDNI)).findFirst().get();
            if (tempUser instanceof Student) {
                ((Student) tempUser).financeDebt(tempTicket);
            } else {
                tempTicket.cancelFee();
            }
            vehicles.stream().filter(v -> v.getUID().equals(tempTicket.getVehicleID())).collect(Collectors.toList()).get(0).updateState(true);
        } else {
            System.out.println("---------> Returning to main menu");
        }
    }

    static void solveTicket(Scanner sc, List<Vehicle> vehicles, String personalDNI, Ticket tempTicket) {
        if (tempTicket.getStatus().equals(tempTicket.STATUS_CASES[2])) {
            System.out.println("---------> The borrowed vehicle will be returned");
            returnVehicle(sc, vehicles, personalDNI, tempTicket);
        } else if (tempTicket.getStatus().equals(tempTicket.STATUS_CASES[1])) {
            payTicket(vehicles, tempTicket, personalDNI);
        } else {
            System.out.println("---------> The ticket is already solved");
            tempTicket.cancelFee();
            tempTicket.solveTiket();
        }
    }

    static void returnVehicle(Scanner sc, List<Vehicle> vehicles, String personalDNI, Ticket tempTicket) {
        Vehicle tempVehicle = vehicles.stream().filter(v -> v.getUID().equals(tempTicket.getVehicleID())).collect(Collectors.toList()).get(0);
        boolean damagedVehicle = false;
        if (tempTicket.verifyReturnTime(new Date())) {
            System.out.println("---------> The vehicle is being returned on time, no delayed return fee will be applied");
        } else {
            System.out.println("---------> The vehicle has been returned over the time, a delayed return fee will be applied");
            tempTicket.increseDebt(0);
        }
        System.out.println("Are you returning the helmet lent to you?\nEnter (1) if you do, otherwise enter(0)");
        int answer = Integer.parseInt(sc.nextLine());
        if (answer == 1) {
            System.out.println("Is the helmet damaged?\nEnter (1) if you do, otherwise enter(0)");
            answer = Integer.parseInt(sc.nextLine());
            if (answer == 1) {
                System.out.println("---------> A damaged accessories fee will be applied");
                tempTicket.increseDebt(2);
                damagedVehicle = true;
            } else {
                System.out.println("---------> No accessories related fees will be applied");
            }
        } else {
            System.out.println("---------> A missing accessory fee will be applied");
            tempTicket.increseDebt(1);
            damagedVehicle = true;
        }
        System.out.println("Are you returning the vehicle lent to you damaged?\nEnter (1) if you do, otherwise enter(0)");
        answer = Integer.parseInt(sc.nextLine());
        if (answer == 1) {
            System.out.println("---------> A damaged vehicle fee will be applied");
            tempTicket.increseDebt(3);
            damagedVehicle = true;
        } else {
            System.out.println("---------> No vehicle related fees will be applied");
        }
        if (tempTicket.solveTiket()) {
            tempVehicle.updateState(true);
        } else if (damagedVehicle) {
            tempVehicle.updateState(false);
        } else {
            tempVehicle.updateState(true);
        }
    }

    static Vehicle checkAvailability(List<Vehicle> vehicles, String className) {
        if (className.equals("Bicycle")) {
            if (vehicles.stream().anyMatch(vehicle -> vehicle instanceof Bicycle && vehicle.isAvailable())) {
                return vehicles.stream().filter(vehicle -> vehicle instanceof Bicycle).findFirst().get();
            } else {
                return null;
            }
        } else {
            if (vehicles.stream().anyMatch(vehicle -> vehicle instanceof Scooter && vehicle.isAvailable())) {
                return vehicles.stream().filter(vehicle -> vehicle instanceof Scooter).findFirst().get();
            } else {
                return null;
            }
        }
    }

}