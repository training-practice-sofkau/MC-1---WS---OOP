package co.com.movingu;

import co.com.movingu.Debt.Debt;
import co.com.movingu.ticket.Ticket;
import co.com.movingu.user.Student;
import co.com.movingu.user.Trainer;
import co.com.movingu.user.User;
import co.com.movingu.vehicle.Bicycle;
import co.com.movingu.vehicle.Scooter;
import co.com.movingu.vehicle.Vehicle;

import java.time.LocalDateTime;
import java.time.Period;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;

public class MovingUApp {

    static Ticket genTicket=new Ticket();
    static List<User> users = new ArrayList<>(){{
        add(new Student("0976152443", "Carolina Montoya", 24, "201547896", "FIEC"));
        add(new Trainer("0976152442", "Washington Pesantez", 36, "lecturer"));

    }};

    static List<Vehicle> vehicles = new ArrayList<>() {{
        add(new Bicycle("B-001","red",true,"M"));
        add(new Bicycle("B-002","blue",false, "M"));
        add(new Bicycle("B-003","red",true, "R"));
        //add(new Bicycle("B-004","green",false, true, "R"));
        //add(new Bicycle("B-005","grey",true, true, "M"));
        add(new Scooter("S-001","black",true,20));
        add(new Scooter("S-002","blue",true, 50));
        add(new Scooter("S-003","grey",true, 80));
        add(new Scooter("S-004","grey",true, 50));
        //add(new Scooter("S-005","black",false, false, 50));

    }};

    static List<Ticket> tickets = new ArrayList<>() {{

    }};
    public static void main(String[] args) {
        //Lists that contains data related to the WS


        int optionMenu;
        do {
            menu();
            Scanner sc = new Scanner(System.in);
            optionMenu = sc.nextInt();

            actionMenu(optionMenu);

        } while (optionMenu != 5);
        //TO DO: Implement the necessary logic to make the menu work

    }

    public static void menu(){
        System.out.println("Moving - U");
        System.out.println("1. Register user");
        System.out.println("2. Borrow/Return");
        System.out.println("3. Pay a ticket");
        System.out.println("4. Check availability");
        System.out.println("5. Exit");
    }

    public static void actionMenu(int op){

        switch (op){
            case 1:
                registerUser();
                break;
            case 2:
                borrowOrReturn();
                break;
            case 3:
                payTicket();
                break;
            case 4:
                checkAvailability();
                break;
            case 5:
                System.out.println("Thanks for use our services");
                break;
            default:
                System.out.println("Wrong option!");
        }

    }

    public static void registerUser(){
        Scanner sc = new Scanner(System.in);
        Scanner sc1 = new Scanner(System.in);
        //Ask the commom data: DNI, Name, age.
        System.out.print("User is: Student (S) / Trainer (T)");
        String type = sc.nextLine();

        String name;
        String dni;
        int age;

        System.out.println("Enter your DNI:");
        dni=sc.nextLine();

        if(lookForUser(dni).isEmpty()){

            switch (type.toLowerCase()) {
                case "s":
                    System.out.println("Provide us your name:");
                    name = sc.nextLine();
                    System.out.println("Enter your age");
                    age = sc.nextInt();
                    System.out.println("Enter your collegeDNI");
                    String collegeDni = sc1.nextLine();
                    System.out.println("Enter your faculty");
                    String faculty = sc1.nextLine();
                    User s = new Student(dni, name, age, collegeDni, faculty);
                    users.add(s);
                    System.out.println("User with name " + s.getName() + "and DNI: " + s.getDni() + " was registered");

                    break;
                case "t":
                    System.out.println("Provide us your name:");
                    name = sc.nextLine();
                    System.out.println("Enter your age");
                    age = sc.nextInt();
                    System.out.println("Select your category");
                    String category = sc1.nextLine();
                    User s1 = new Trainer(dni, name, age, category);
                    users.add(s1);
                    System.out.println("User with name " + s1.getName() + "and DNI: " + s1.getDni() + " was registered");

                    break;
                default:
                    System.out.println("Enter a valid type of user");
            }

        }else{
                System.out.println("User already exist!");
            }

    }


    public static void borrowOrReturn(){
        Scanner sc = new Scanner(System.in);
        Scanner sc1 = new Scanner(System.in);

        System.out.print("What do you want to do? borrow (B) or return a vehicle (R)");
        String op = sc.nextLine();

        switch (op.toLowerCase()){
            case "b":
                System.out.println("Type your DNI:");
                op = sc.nextLine();

                Optional<User> myUser=lookForUser(op);

                if(myUser.isPresent()){
                    if(!myUser.get().isBlocked()){
                        System.out.println("Enter vehicle's type: Bicycle (B) or Scooter (S): ");
                        op = sc.nextLine();
                        Optional<Vehicle> myVehicle;
                        switch (op.toLowerCase()){
                            case "b":
                                myVehicle=vehicles.stream().filter(b -> b.isAvailable() && b.isCondition() && b instanceof Bicycle).findFirst();
                                if(myVehicle.isPresent()){
                                    System.out.println("How many hours do you want to rent? 1 / 2 / 3 hours ");
                                    int hour=sc1.nextInt();
                                    genTicket.setHelmetSupplied(true);
                                    genTicket.setuTicket(myUser.get());
                                    genTicket.setvTicket(myVehicle.get());
                                    genTicket.setCode();
                                    genTicket.setStartTime(LocalDateTime.now());
                                    tickets.add(new Ticket(genTicket.getCode(),'b',genTicket.getStartTime(),genTicket.getuTicket(),genTicket.getvTicket(),hour));
                                    myVehicle.get().setAvailable(false);
                                    myUser.get().setTicketOn(true);
                                    myUser.get().setBlocked(true);
                                    updatedUsers(myUser.get());
                                    updatedVehicles(myVehicle.get());
                                    System.out.println("--------------Ticket--------------");
                                    System.out.println("Ticket number:"+genTicket.getCode());
                                    System.out.println("Vehicle type: Bicycle");
                                    System.out.println("Start time: "+genTicket.getStartTime());
                                }else {
                                    System.out.println("We don't have available bicycles in this moment!");
                                }
                                break;
                            case "s":
                                myVehicle=vehicles.stream().filter(b -> b.isAvailable() && b.isCondition() && b instanceof Scooter).findFirst();
                                if(myVehicle.isPresent()){
                                    System.out.println("How many hours do you want to rent? 1 / 2 / 3 hours ");
                                    int hour=sc1.nextInt();
                                    genTicket.setHelmetSupplied(true);
                                    genTicket.setuTicket(myUser.get());
                                    genTicket.setvTicket(myVehicle.get());
                                    genTicket.setCode();
                                    genTicket.setStartTime(LocalDateTime.now());
                                    tickets.add(new Ticket(genTicket.getCode(),'s',genTicket.getStartTime(),genTicket.getuTicket(),genTicket.getvTicket(),hour));
                                    myVehicle.get().setAvailable(false);
                                    myUser.get().setTicketOn(true);
                                    myUser.get().setBlocked(true);
                                    updatedUsers(myUser.get());
                                    updatedVehicles(myVehicle.get());
                                    System.out.println("--------------Ticket--------------");
                                    System.out.println("Ticket number:"+genTicket.getCode());
                                    System.out.println("Vehicle type: Scooter");
                                    System.out.println("Start time: "+genTicket.getStartTime());
                                }else{
                                    System.out.println("We don't have available scooters in this moment!");
                                }
                                break;
                            default:
                                System.out.println("Type a valid option");
                        }

                    }else{
                        System.out.println("User has a debt or pending ticket");
                    }


                }else {
                    System.out.println("You need to be registered first!");
                }
                break;
            case "r":
                System.out.println("Type id ticket");
                op = sc.nextLine();
                Optional<Ticket> myTicket=lookForTickets(op);

                boolean isHelmet;
                boolean isHelmetDamaged;
                boolean condition;
                String battery;
                if(myTicket.isPresent()){
                    System.out.println("Has helmet? T/F ");
                    op= sc.nextLine();
                    if(op.equalsIgnoreCase("t")) {
                        isHelmet = true;
                    }else{
                        isHelmet = false;
                    }
                    System.out.println("is Helmet damage?");
                    op=sc1.nextLine();
                    if(op.equalsIgnoreCase("t")){
                        isHelmetDamaged=true;
                    }else{
                        isHelmetDamaged=false;
                    }
                    System.out.println("Good condition T/F");
                    op= sc.nextLine();
                    if(op.equalsIgnoreCase("t")){
                        condition=true;
                    }else{
                        condition=false;
                    }
                    if(myTicket.get().getVehicleType()=='s'){
                        System.out.println("Battery status: ");
                        battery= sc.nextLine();
                    }

                    myTicket.get().setEndTime(LocalDateTime.now());

                    Debt myDebt = new Debt();

                    //For WK, second are taken as minutes to work
                    int differenceHours= (int) (ChronoUnit.SECONDS.between(myTicket.get().getStartTime(),myTicket.get().getEndTime()) - myTicket.get().getRentHours()*60);

                    if (differenceHours>0) myDebt.penaltyForNoTime(differenceHours/30);
                    myDebt.withoutHelmet(isHelmet);
                    myDebt.penaltyForDamage(isHelmetDamaged,condition,myTicket.get().getVehicleType());

                    myTicket.get().setAmountToPay(myDebt.getValueDebt());

                    if(myDebt.getValueDebt()==0) {
                        myTicket.get().updateState("OK");
                        myTicket.get().getuTicket().setBlocked(false);
                    }else{
                        myTicket.get().updateState("Pending");
                    }

                    myTicket.get().getuTicket().setTicketOn(false);

                    myTicket.get().getvTicket().setAvailable(condition);

                    updatedVehicles(myTicket.get().getvTicket());

                    updatedUsers(myTicket.get().getuTicket());

                    updatedTickets(myTicket.get());

                    System.out.println("-------------Ticket to return-------------");
                    System.out.println("Ticket number:"+myTicket.get().getCode());
                    System.out.println("Start time: "+myTicket.get().getStartTime());
                    System.out.println("End time: "+myTicket.get().getEndTime());
                    System.out.println("Debt value: "+myTicket.get().getAmountToPay());
                    System.out.println("Status: "+myTicket.get().getTicketStatus());


                }else{
                    System.out.println("Ticket doesn't available");
                }

                break;
            default:
                System.out.println("wrong option");
        }

    }

    public static void payTicket(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Type Ticket ID to pay.");
        String ticketId=sc.nextLine();

        Optional<Ticket> myTicket = lookForTickets(ticketId);

        if(myTicket.isPresent()){
            if(myTicket.get().getTicketStatus().equalsIgnoreCase("Pending")){
                myTicket.get().updateState("OK");
                myTicket.get().setAmountToPay(0);
                myTicket.get().getuTicket().setBlocked(false);
                updatedUsers(myTicket.get().getuTicket());
                updatedTickets(myTicket.get());
                System.out.println("--------Ticket Closed--------");
                System.out.println("Ticket number:"+myTicket.get().getCode());
                System.out.println("Time rented: "+myTicket.get().getRentHours()+" hours");
                System.out.println("Status: "+myTicket.get().getTicketStatus());
            }else{
                System.out.println("This ticket has already been paid or it doesn't have debts yet");
            }
        }else{
            System.out.println("Ticket not exist!");
        }
    }

    public static void checkAvailability(){
        long scooters=vehicles.stream().filter(b -> b.isAvailable() && b.isCondition() && b instanceof Scooter).count();
        long bicycles=vehicles.stream().filter(b -> b.isAvailable() && b.isCondition() && b instanceof Bicycle).count();

        System.out.println("Available Vehicles");
        System.out.println("Scooters: "+scooters);
        System.out.println("Bicycles: "+bicycles);

        /*
        System.out.println("-------Tickets-------");
        for(Ticket t:tickets){
            System.out.println(t.getCode());
            System.out.println(t.getTicketStatus());
            System.out.println(t.getuTicket().getName());
            System.out.println("-----------------------");
        }

        System.out.println("-------Users-------");
        for(User s:users){
            System.out.println(s.getName());
            System.out.println(s.isBlocked());
            System.out.println(s.isTicketOn());
            System.out.println("-----------------------");
        }

        System.out.println("-------Vehicles-------");
        for(Vehicle s:vehicles){
            System.out.println(s.getCodeVH());
            System.out.println(s.isCondition());
            System.out.println("-----------------------");
        }*/

    }

    public static Optional<User> lookForUser(String dni){
        return users.stream().filter(us->us.getDni().equalsIgnoreCase(dni)).findFirst();
    }

    public static Optional<Ticket> lookForTickets(String code){
        return tickets.stream().filter(tk->tk.getCode().equalsIgnoreCase(code)).findFirst();
    }

    public static void updatedUsers(User us){
        users.set(users.indexOf(us),us);
    }

    public static void updatedVehicles(Vehicle vh){
        vehicles.set(vehicles.indexOf(vh),vh);
    }

    public static void updatedTickets(Ticket tk){
        tickets.set(tickets.indexOf(tk),tk);
    }
}