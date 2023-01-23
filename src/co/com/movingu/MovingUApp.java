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
    static List<User> users = new ArrayList<>(){{
        add(new Student("0976152443", "Carolina Montoya", 24, "201547896", "FIEC"));
        add(new Trainer("0976152443", "Washington Pesantez", 36, "lecturer"));


    }};
    public static void main(String[] args) {
        //Lists that contains data related to the WS


        List<Vehicle> vehicles= new ArrayList<>(){{
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

        List<Ticket> tickets = new ArrayList<>(){{
            //add(new Ticket());
            //add(new Ticket());
            //add(new Ticket());

        }};

        //TO DO: Implement the necessary logic to make the menu work
        menu();


    }

    public static void menu(){
        int option = 0;
        do {
            System.out.println("Moving - U");
            System.out.println("1. Register user");
            System.out.println("2. Borrow/Return");
            System.out.println("3. Pay a ticket");
            System.out.println("4. Check availability");
            System.out.println("5. Exit");
            //Ask the commom data: DNI, Name, age.
            Scanner sc = new Scanner(System.in);
            System.out.print("Please, select and option: ");
            int num = sc.nextInt();
            try{
                option = num;
                switch (option){
                    case 1:{registerUser();}
                    //case 2:{}
                }
            } catch (InputMismatchException e){
                System.out.println(e);
                System.out.println("Please, type a number");
                option = 0;
            }
        } while (option != 5);

    }

    public static void registerUser(){
        Scanner sc = new Scanner(System.in);
        //Ask the commom data: DNI, Name, age.

        System.out.print("Please, type your DNI: ");
        String DNI = sc.nextLine();
        System.out.print("Please, type your name: ");
        String name = sc.nextLine();
        System.out.print("Please, type your age: ");
        int age = sc.nextInt();
        System.out.print("Please, choose your User: Student (S) / Trainer (T): ");
        String type = sc.nextLine();

        switch (type){
            case "S":
                Scanner sc2 = new Scanner(System.in);
                // Ask the college DNI and the faculty
                System.out.print("Please, type your Collage DNI: ");
                String collDNI = sc2.nextLine();
                System.out.print("Please, type your faculty: ");
                String faculty = sc2.nextLine();
                //create the student object
                User s = new Student( DNI, name, age, collDNI, faculty);
                users.add(s);
                //Display a message: User was registered
                System.out.println("User Added");
                break;

            case "T":
                Scanner sc3 = new Scanner(System.in);
                System.out.print("Please, choose: Professor / Lecture: ");
                String category = sc3.nextLine();
                User s1 = new Trainer( DNI, name, age, category);
                users.add(s1);
                //Display a message: User was registered
                System.out.println("User Added");
                break;

        }
    }

}