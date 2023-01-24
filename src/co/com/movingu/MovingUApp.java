package co.com.movingu;

import co.com.movingu.ticket.DebtInterface;
import co.com.movingu.ticket.Ticket;
import co.com.movingu.user.Student;
import co.com.movingu.user.Trainer;
import co.com.movingu.user.User;
import co.com.movingu.vehicle.Bicycle;
import co.com.movingu.vehicle.Scooter;
import co.com.movingu.vehicle.Vehicle;

import java.time.LocalDateTime;
import java.util.*;

public class MovingUApp {
    static List<User> users = new ArrayList<>(){{
        add(new Student("01", "Carolina Montoya", 24, "201547896", "FIEC"));
        add(new Trainer("02", "Washington Pesantez", 36, "lecturer"));

    }};

    static List<Vehicle> vehicles= new ArrayList<>(){{
        add(new Bicycle("B-001","red",true, true, "M"));
        add(new Bicycle("B-002","blue",false, false, "M"));
        add(new Bicycle("B-003","red",true, true, "R"));
        add(new Bicycle("B-004","green",false, true, "R"));
        add(new Bicycle("B-005","grey",true, true, "M"));
        add(new Scooter("S-001","black",false, true, 20));
        add(new Scooter("S-002","blue",true, true, 50));
        add(new Scooter("S-003","grey",true, true, 80));
        add(new Scooter("S-004","grey",true, false, 50));
        add(new Scooter("S-005","black",false, false, 50));

    }};

    static List<Ticket> tickets = new ArrayList<>();


    public static void main(String[] args) {
        //Lists that contains data related to the WS



        //TO DO: Implement the necessary logic to make the menu work
        menu();


    }

    public static void menu(){
        int option = 0;
        do {
            System.out.println();
            System.out.println("Moving - U");
            System.out.println("1. Register user");
            System.out.println("2. Borrow/Return");
            System.out.println("3. Pay a ticket");
            System.out.println("4. Check availability");
            System.out.println("5. Exit");
            Scanner sc = new Scanner(System.in);
            System.out.print("Please, select and option: ");
            int num = sc.nextInt();
            option = num;
            switch (option){
                case 1:
                    registerUser();
                    break;
                case 2:{
                    System.out.println();
                    System.out.println("1. Borrow a vehicle");
                    System.out.println("2. return a vehicle");
                    //Scanner sc = new Scanner(System.in);
                    System.out.print("Please, select and option: ");
                    int num1 = sc.nextInt();
                    switch (num1){
                        case 1:
                            borrowVehicle ();
                            break;
                        case 2:
                            returnVehicle ();
                    }
                    break;
                }
                case 3:{
                    payDebt();
                    break;
                }
            }
        } while (option != 5);

    }

    public static void registerUser(){
        Scanner sc = new Scanner(System.in);
        System.out.print("Please, choose your User: Student (S)/ Trainer (T): ");
        String type = sc.nextLine();
        System.out.print("Please, type your DNI: ");
        String DNI = sc.nextLine();
        System.out.print("Please, type your name: ");
        String name = sc.nextLine();
        System.out.print("Please, type your age: ");
        int age = sc.nextInt();

        switch (type){
            case "S":
                //Ask the commom data: DNI, Name, age.
                Scanner sc2 = new Scanner(System.in);
                System.out.print("Please, type your Collage DNI: ");
                String colleDNI = sc2.nextLine();
                System.out.print("Please, type your faculty: ");
                String faculty = sc2.nextLine();
                User s = new Student(DNI, name, age, colleDNI, faculty);
                users.add(s);
                System.out.println("User created");
                System.out.println(users.size());
                System.out.println(users);
                for (User user: users
                     ) {
                    System.out.println(user);
                }
            case "T":
                Scanner sc3 = new Scanner(System.in);
                System.out.print("Please, choose a role, Professor / Lecturer :  ");
                String role = sc3.nextLine();
                User s1 = new Trainer(DNI, name, age, role);
                users.add(s1);
                System.out.println("User created");
                System.out.println(users.size());
                System.out.println(users);
        }

    }


    public static void borrowVehicle (){
        User user1 = null;
        Scanner sc = new Scanner(System.in);
        System.out.print("please, type your DNI: ");
        String DNI = sc.nextLine();
        for (User user : users) {
            if (user.getDni().equals(DNI)) {
                user1 = users.get(users.indexOf(user));
            }
        }
        if (user1==null){
            System.out.println("User not found");
        }
        else if (!user1.isBlocked() && !user1.isTicketOn()){
            System.out.print("Please, select your vehicle, Bicycle / Scooter: ");
            String vehicle = sc.nextLine();
            List <Vehicle> vehicles1=new ArrayList<>();
            String id = null;
            Vehicle randomVehi=null;
            int duration=0;
            switch (vehicle){
                case "Bicycle":
                    //System.out.print("Please, select the kind of Bicycle: Mountain (M) / Road (R): ");
                    //String kindBicycle = sc.nextLine();

                    for (Vehicle v: vehicles) {
                        if (v.getId().startsWith("B") && v.isAvailable()){
                            vehicles1.add(v);
                        }
                    }
                    System.out.println(vehicles1);
                    System.out.println(vehicles1.size());
                    if (vehicles1==null){
                        System.out.println("No Vehicles of kind " + vehicle +
                                        "are available, try later");
                    }
                    break;
                case "Scooter":
                    for (Vehicle v: vehicles) {
                        if (v.getId().startsWith("S") && v.isAvailable()){
                            vehicles1.add(v);
                        }
                    }
                    if (vehicles1==null){
                        System.out.println("No Vehicles of kind " + vehicle +
                                "are available, try later");
                    }
                    break;

            }
            Random random = new Random();
            randomVehi = vehicles1.get(random.nextInt(vehicles1.size()));
            System.out.print(randomVehi);
            System.out.print("how many hours will you use this vehicle?: ");
            duration = sc.nextInt();
            if (tickets.isEmpty()){
                id = "T-001";
            }
            if ( tickets.size()>0 && tickets.size()<10){
                id = "T-00" + (tickets.size()+1);
            } else if (tickets.size()>=10 && tickets.size()<100) {
                id = "T-0" + (tickets.size()+1);
            }
            else if (tickets.size()>=100 && tickets.size()<1000) {
                id = "T-" + (tickets.size()+1);
            }

            Ticket ticket = new Ticket(id,  java.time.LocalDateTime.now(),
                    java.time.LocalDateTime.now().plusHours(duration), true, "Active",
                    0,randomVehi, user1);
            user1.setTicketOn(true);
            tickets.add(ticket);

            System.out.println("Your ticket number is: " + ticket.getId());
            System.out.println(tickets);
            System.out.println(users);
            System.out.println(tickets.get(0).getBorrowedVehi().getId());

                } else {
            System.out.println("You can have another ticker for now");
        }

        }
    public static void returnVehicle () {
        Scanner sc = new Scanner(System.in);
        System.out.print("please, type your Ticket Number: ");
        LocalDateTime returnedTime = java.time.LocalDateTime.now();
        String ticNumber = sc.nextLine();
        System.out.print("do you return a helmet? True/False: ");
        boolean helmet = sc.nextBoolean();

        Scanner sc1 = new Scanner(System.in);
        System.out.print("does the helmet have any damage? True/False: ");
        boolean damaHelmet = sc1.nextBoolean();
        Scanner sc2 = new Scanner(System.in);
        System.out.print("does the vehicle have any damage? True/False: ");
        boolean damaVehi = sc2.nextBoolean();
        String type = null;
        Ticket ticket = null;
        for (Ticket ti: tickets
             ) {
            if (ti.getId().equals(ticNumber)){
                ticket = tickets.get(tickets.indexOf(ti));
            }
        }
        if (ticket.getBorrowedVehi().getId().startsWith("B")){
            type = "Bicycle";
        } else if (ticket.getBorrowedVehi().getId().startsWith("S")){
            type = "Scooter";
        }
        ticket.updateDebt(returnedTime, helmet, damaHelmet,
                damaVehi, type);
        System.out.println("Your debt is: $" + ticket.getDebt());
    }

    public static void payDebt(){
        Scanner sc = new Scanner(System.in);
        System.out.print("please, type your Ticket Number: ");
        String ticNumber = sc.nextLine();
        boolean payedDebt = true;
        Ticket ticket = null;
        Boolean helmetDamage = false;
        for (Ticket ti: tickets
        ) {
            if (ti.getId().equals(ticNumber)){
                ticket = tickets.get(tickets.indexOf(ti));
            }
        }
        if (ticket.getDebt()==0){
            System.out.println("You don't have to pay");
        }

        Vehicle v1 = ticket.getBorrowedVehi();
        v1.setCondition(true);
        ticket.getBorrowedVehi().setCondition(false);
        ticket.updateStatus(
                v1.getCondition(),
                helmetDamage,
                payedDebt
                );
        System.out.println(ticket);
    }
    }
