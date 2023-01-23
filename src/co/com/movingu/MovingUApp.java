package co.com.movingu;

import co.com.movingu.ticket.Ticket;
import co.com.movingu.user.Student;
import co.com.movingu.user.Trainer;
import co.com.movingu.user.User;
import co.com.movingu.utilities.Utilities;
import co.com.movingu.vehicle.Scooter;
import co.com.movingu.vehicle.Vehicle;


import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class MovingUApp {
    static List<User> users = new ArrayList<>(){{
        add(new Student("0976152443", "Carolina Montoya", 24, "201547896", "FIEC"));
        add(new Trainer("0976152443", "Washington Pesantez", 36, "lecturer"));
    }};

    public static void main(String[] args) {
        Utilities utilities = new Utilities();
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
        utilities.menu();






    }



    public static void registerUser(){
        Scanner sc = new Scanner(System.in);
        //Ask the commom data: DNI, Name, age.
        System.out.print("User is: Student (S) / Trainer (T)");
        String type = sc.nextLine();
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