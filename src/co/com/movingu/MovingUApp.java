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
import java.util.Optional;
import java.util.Scanner;

public class MovingUApp {
    static List<User> users = new ArrayList<>(){{
        add(new Student("0976152443", "Carolina Montoya", 24, "201547896", "FIEC"));
        add(new Trainer("0976152443", "Washington Pesantez", 36, "lecturer"));

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
    public static void main(String[] args) {
        //Lists that contains data related to the WS


        List<Ticket> tickets = new ArrayList<>() {{
            //add(new Ticket());
            //add(new Ticket());
            //add(new Ticket());

        }};


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
                    Ticket genTicket;
                    switch (op.toLowerCase()){
                        case "b":
                            myVehicle=vehicles.stream().filter(b -> b.isAvailable() && b instanceof Bicycle).findFirst();
                            if(myVehicle.isPresent()){
                                genTicket=new Ticket(true, myUser.get(), myVehicle.get());
                            }else {
                                System.out.println("We don't have bicycles in this moment!");
                            }
                            break;
                        case "s":
                            myVehicle=vehicles.stream().filter(b -> b.isAvailable() && b instanceof Scooter).findFirst();
                            if(myVehicle.isPresent()){
                                System.out.println("Making ticket scooter");
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
                System.out.println("I'm making in this function");
                break;
            default:
                System.out.println("wrong option");
        }

    }

    public static Optional<User> lookForUser(String dni){
        return users.stream().filter(us->us.getDni().equalsIgnoreCase(dni)).findFirst();
    }

}