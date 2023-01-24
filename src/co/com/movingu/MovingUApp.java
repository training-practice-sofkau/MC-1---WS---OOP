package co.com.movingu;

import co.com.movingu.ticket.Ticket;
import co.com.movingu.user.User;
import co.com.movingu.user.Student;
import co.com.movingu.user.Trainer;
import co.com.movingu.vehicle.Vehicle;
import co.com.movingu.vehicle.Bicycle;
import co.com.movingu.vehicle.Scooter;

import java.util.*;

public class MovingUApp {
    static List<User> users = new ArrayList<>(){{
        add(new Student("Carolina Montoya","0976152443",  24, "201547896", "FIEC"));
        add(new Trainer("Washington Pesantez", "0976152448", 36, "lecturer"));
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

    public static void main(String[] args) {

        List<Ticket> tickets = new ArrayList<>(){{
            //add(new Ticket());
            //add(new Ticket());
            //add(new Ticket());

        }};

        menu();

    }

    public static void menu(){
        Scanner opt = new Scanner(System.in);
        boolean exit = false;
        byte menuOpt;

        while (!exit) {
            System.out.println("Moving - U " +
                    "\n1. Register user " +
                    "\n2. Borrow/Return " +
                    "\n3. Pay a ticket " +
                    "\n4. Check availability " +
                    "\n5. Exit");

            try {
                menuOpt = opt.nextByte();

                switch (menuOpt){
                    case 1:
                        registerUser();
                        break;
                    case 2:
                        borrowOrReturn();
                        break;
                    case 3:
                        System.out.println("1");
                        break;
                    case 4:
                        availavility();
                        break;
                    case 5:
                        System.out.println("Closing app....");
                        exit = true;
                        break;
                    default:
                        System.out.println("Only type number between 1-5");
                }
            }
            catch (InputMismatchException e){
                System.out.println("Invalid input");
                opt.nextLine();
            }
        }
        opt.close();
    }

    public static void availavility() {
        int numBicycle = 0;
        int numScooters = 0;
        for (Vehicle v : vehicles){
            System.out.println(v.getClass().getSimpleName());
            if (v.getClass().getSimpleName().equals("Bicycle") && v.isAvailable()){
                numBicycle ++;
            } else if (v.getClass().getSimpleName().equals("Scooter") && v.isAvailable()) {

                numScooters ++;
            }
        }
        System.out.println(numBicycle);
        System.out.println(numScooters);

    }

    public static void registerUser(){
        Scanner sc = new Scanner(System.in);
        //Ask the commom data: DNI, Name, age.
        System.out.println("Enter a name:");
        String name = sc.nextLine();
        System.out.println("Enter a DNI:");
        String dni = sc.nextLine();
        System.out.println("Enter a Age:");
        int age = sc.nextInt();
        sc.nextLine();
        System.out.print("User is: Student (S) / Trainer (T): ");
        String type = sc.nextLine();

        switch (type){
            case "S":
                System.out.println("Enter the college DNI");
                String collegeDni = sc.nextLine();
                System.out.println("Enter the Faculty");
                String faculty = sc.nextLine();

                User s = new Student(name, dni, age, collegeDni, faculty);
                users.add(s);

                System.out.println("Student succesfully register");

                break;
            case "T":
                System.out.print("Trainer is: Proffesor (P) / Lecture (L): ");
                String category = sc.nextLine();

                User t = new Trainer(name, dni, age, category);
                users.add(t);

                System.out.println("Trainer succesfully register");
                break;
            default:
                System.out.println("Wrong input");
        }
    }

    public static void borrowOrReturn(){
        Scanner borrowOrReturn = new Scanner(System.in);

        System.out.println("Enter Borrow (B) / Return (R)");
        String optBorrorOrReturn = borrowOrReturn.nextLine();

        switch (optBorrorOrReturn) {
            case "B":
                borrowVehicle();
                break;
            case "R":
                returnVehicle();
                break;
        }
    }

    public static void borrowVehicle(){
        Scanner borrowScanner = new Scanner(System.in);
        System.out.println("Enter DNI");
        String  userDni = borrowScanner.nextLine();
        boolean found = false;
        for (User u: users) {
            System.out.println(u.getDni().equals(userDni));
            if (u.getDni().equals(userDni)){
                found = true;
                if (!u.isBlocked() && !u.isTicketOn()){
                    System.out.println("Plese select Bicycle (B)/ Scooter (S)");
                    String vehicleSelection = borrowScanner.nextLine();

                }
            }

        }


    }

    public static void returnVehicle(){

    }

}