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
import java.util.stream.Collectors;

public class MovingUApp {
    static List<User> users = new ArrayList<>() {{
        add(new Student("0976152443", "Carolina Montoya", 24, "201547896", "FIEC"));
        add(new Trainer("0976152443", "Washington Pesantez", 36, "lecturer"));
    }};
    static Scanner sc = new Scanner(System.in);

    static Context context = new Context();

    public static void main(String[] args) {
        List<Vehicle> vehicles = new ArrayList<>() {{
            add(new Bicycle("123",true, "red", "Ready to use"));

            add(new Scooter("465",true, "black", "Ready to use"));

        }};

        List<Ticket> tickets = new ArrayList<>();
        tickets.add(new Ticket(tickets, "111", 0, "000"));
        ;

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
                List<Ticket> userTickets = tickets.stream().filter(ticket -> ticket.getUserDni().equals(personalDNI) && ticket.verifySolved()).collect(Collectors.toList());
                if (userTickets.size() == 0) {
                    System.out.println("No tickets found");
                    System.out.println("Would you like to borrow a vehicle (enter 1) or to return a vehicle  (enter 0)");
                    answer = Integer.parseInt(sc.nextLine());
                    if (answer == 1) {
                        borrowVehicle(sc, vehicles, personalDNI, tickets);
                    }
                } else {
                    System.out.println("Found tickets");
                }
                break;
        }

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
                System.out.println("Please write down the students age");
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
                System.out.println(vehicles.get(0) instanceof Bicycle);
                Vehicle borrowingBicycle = vehicles.stream().filter(vehicle -> vehicle instanceof Bicycle).findFirst().get();
                borrowingBicycle.updateAvailability(false);
                tickets.add(new Ticket(tickets, DNI, 1, borrowingBicycle.getUID()));
                System.out.println("Vehicle borrowed successfully");
                break;
            case "2":
                System.out.println(vehicles.get(0) instanceof Bicycle);
                Vehicle borrowingScooter = vehicles.stream().filter(vehicle -> vehicle instanceof Scooter).findFirst().get();
                borrowingScooter.updateAvailability(false);
                tickets.add(new Ticket(tickets, DNI, 1, borrowingScooter.getUID()));
                System.out.println("Vehicle borrowed successfully");
                break;
        }
    }

}