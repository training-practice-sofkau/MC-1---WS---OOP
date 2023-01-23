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
        //add(new Bicycle("B-002","blue",false, false, "M"));
        //add(new Bicycle("B-003","red",true, true, "R"));
        //add(new Bicycle("B-004","green",false, true, "R"));
        //add(new Bicycle("B-005","grey",true, true, "M"));
        add(new Scooter("S-001","black",false,20));
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
            case 5:
                System.out.println("Thanks for use our services");
                break;
            default:
                System.out.println("Wrong option!");
        }

    }

    public static void registerUser(){
        Scanner sc = new Scanner(System.in);
        //Ask the commom data: DNI, Name, age.
        System.out.print("User is: Student (S) / Trainer (T)");
        String type = sc.nextLine();

        String name;
        String dni;
        int age;

        switch (type.toLowerCase()){
            case "s":
                System.out.println("Enter your DNI:");
                dni=sc.nextLine();

                if(lookForUser(dni).isEmpty()){
                    System.out.println("Provide us your name:");
                    name= sc.nextLine();
                    System.out.println("Enter your age");
                    age= sc.nextInt();
                    System.out.println("Enter your collegeDNI");
                    String collegeDni=sc.nextLine();
                    System.out.println("Enter your faculty");
                    String faculty=sc.nextLine();
                    User s = new Student(dni,name,age,collegeDni,faculty);
                    users.add(s);
                    System.out.println("User with name "+s.getName()+"and DNI: "+s.getDni()+" was registered");
                }else{
                    System.out.println("User already exist!");
                }
                break;
            case "t":
                System.out.println("Enter your DNI:");
                dni=sc.nextLine();

                if(lookForUser(dni).isEmpty()){
                    System.out.println("Provide us your name:");
                    name= sc.nextLine();
                    System.out.println("Enter your age");
                    age= sc.nextInt();
                    System.out.println("Select your category");
                    String category=sc.nextLine();
                    User s = new Trainer(dni,name,age,category);
                    users.add(s);
                    System.out.println("User with name "+s.getName()+"and DNI: "+s.getDni()+" was registered");
                }else{
                    System.out.println("User already exist!");
                }
                break;
            default:
                System.out.println("Enter a valid type of user");
        }
    }



    public static void borrowOrReturn(){
        Scanner sc = new Scanner(System.in);

        System.out.print("Can you borrow (B) or return a vehicle (R)?");
        String op = sc.nextLine();

        switch (op.toLowerCase()){
            case "b":
                System.out.println("Type your DNI:");
                op = sc.nextLine();

                Optional<User> myUser=lookForUser(op);


                if(myUser.isPresent()){
                    System.out.println("Enter vehicle's type: Bicycle (B) or Scooter (S): ");
                    op = sc.nextLine();
                    Optional<Vehicle> myVehicle;
                    switch (op.toLowerCase()){
                        case "b":
                            myVehicle=vehicles.stream().filter(b -> b.isAvailable() && b instanceof Bicycle).findFirst();
                            if(myVehicle.isPresent()){
                                genTicket.setHelmetSupplied(true);
                                genTicket.setuTicket(myUser.get());
                                genTicket.setvTicket(myVehicle.get());
                                genTicket.setCode();
                                genTicket.setStartTime(LocalDateTime.now());
                                tickets.add(genTicket);
                                myVehicle.get().setAvailable(false);
                                myUser.get().setTicketOn(true);
                                updatedUsers(myUser.get());
                                updatedVehicles(myVehicle.get());
                                System.out.println("--------------Ticket--------------");
                                System.out.println("Ticket number:"+genTicket.getCode());
                                System.out.println("Vehicle type: Bicycle");
                                System.out.println("Start time: "+genTicket.getStartTime());
                            }else {
                                System.out.println("We don't have bicycles in this moment!");
                            }
                            break;
                        case "s":
                            myVehicle=vehicles.stream().filter(b -> b.isAvailable() && b instanceof Scooter).findFirst();
                            if(myVehicle.isPresent()){
                                genTicket.setHelmetSupplied(true);
                                genTicket.setuTicket(myUser.get());
                                genTicket.setvTicket(myVehicle.get());
                                genTicket.setCode();
                                genTicket.setStartTime(LocalDateTime.now());
                                tickets.add(genTicket);
                                myVehicle.get().setAvailable(false);
                                myUser.get().setTicketOn(true);
                                updatedUsers(myUser.get());
                                updatedVehicles(myVehicle.get());
                                System.out.println("--------------Ticket--------------");
                                System.out.println("Ticket number:"+genTicket.getCode());
                                System.out.println("Vehicle type: Scooter");
                                System.out.println("Start time: "+genTicket.getStartTime());
                            }else{
                                System.out.println("We don't have scooters in this moment!");
                            }
                            break;
                        default:
                            System.out.println("Type a valid option");
                    }

                }else {
                    System.out.println("You need to be registered first!");
                }
                break;
            case "r":
                System.out.println("Type id ticket");
                op = sc.nextLine();
                Optional<Ticket> myTicket=lookForTickets(op);

                boolean statusVehicle;
                boolean condition;
                String battery;
                if(myTicket.isPresent()){
                    System.out.println("Has helmet? T/F ");
                    op= sc.nextLine();
                    if(op.equalsIgnoreCase("t")) {
                        statusVehicle = true;
                    }else{
                        statusVehicle = false;
                    }
                    System.out.println("Good condition T/F");
                    op= sc.nextLine();
                    if(op.equalsIgnoreCase("t")){
                        condition=true;
                    }else{
                        condition=false;
                    }
                    System.out.println("Battery status: ");
                    battery= sc.nextLine();

                    myTicket.get().getuTicket().setTicketOn(false);

                    myTicket.get().getvTicket().setAvailable(true);

                    updatedVehicles(myTicket.get().getvTicket());

                    updatedUsers(myTicket.get().getuTicket());

                    myTicket.get().setEndTime(LocalDateTime.now());

                    updatedTickets(myTicket.get());


                    System.out.println("-------------Ticket to return-------------");
                    System.out.println("Ticket number:"+myTicket.get().getCode());
                    System.out.println("Start time: "+myTicket.get().getStartTime());
                    System.out.println("End time: "+myTicket.get().getEndTime());


                }else{
                    System.out.println("Ticket doesn't available");
                }

                break;
            default:
                System.out.println("wrong option");
        }

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