package co.com.movingu;

import co.com.movingu.ticket.Ticket;
import co.com.movingu.user.Student;
import co.com.movingu.user.Trainer;
import co.com.movingu.user.User;
import co.com.movingu.vehicle.Scooter;
import co.com.movingu.vehicle.Vehicle;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class MovingUApp {

    //Lists that contains data related to the WS
    public static List<User> users = new ArrayList<>(){{
        add(new Student("0976152443", "Carolina Montoya", 24, "201547896", "FIEC"));
        add(new Trainer("0976152443", "Washington Pesantez", 36, "lecturer"));
    }};

    public static List<Vehicle> vehicles= new ArrayList<>(){{
        //add(new Bicycle("B-001","red",true, true, "M"));
        //add(new Bicycle("B-002","blue",false, false, "M"));
        //add(new Bicycle("B-003","red",true, true, "R"));
        //add(new Bicycle("B-004","green",false, true, "R"));
        //add(new Bicycle("B-005","grey",true, true, "M"));
        //add(new Scooter("S-001","black",false, true, 20));
        //add(new Scooter("S-002","blue",true, true, 50));
        //add(new Scooter("S-003","grey",true, true, 80));
        //add(new Scooter("S-004","grey",true, false, 50));
        //add(new Scooter("S-005","black",false, false, 50));

    }};

    public static List<Ticket> tickets = new ArrayList<>(){{
        //add(new Ticket());
        //add(new Ticket());
        //add(new Ticket());

    }};

    public static void main(String[] args) {

        int menuOption = 0;

        Scanner in = new Scanner(System.in);



        try {
            do {
                menu();
                menuOption = in.nextInt();

                switch (menuOption) {
                    case 1: registerUser(in);
                            break;
                    case 2:
                    default:
                        System.out.println("Opcion invalida");
                        break;
                }
            } while (menuOption != 5);
        } catch (InputMismatchException e) {
            System.out.println("Tipo de caracter incorrecto");
        }catch (Exception e) {
            System.out.println(e);
        }





    }

    public static void menu(){
        System.out.println("Moving - U");
        System.out.println("1. Register user");
        System.out.println("2. Borrow/Return");
        System.out.println("3. Pay a ticket");
        System.out.println("4. Check availability");
        System.out.println("5. Exit");
    }

    public static void registerUser(Scanner in){
        System.out.println("Número de identificación");
        String userName = in.next();

        System.out.println("Nombre del usuario");
        String userName = in.next();

        //Ask the commom data: DNI, Name, age.
        System.out.print("User is: Student (S) / Trainer (T)");
        switch (type){
            case "S":
                // Ask the college DNI and he faculty
                //create the student object
                User s = new Student("0976152443", "Carolina Montoya", 24, "201547896", "FIEC");
                users.add(s);
                //Display a message: User was registered
                break;
        }
    }

}