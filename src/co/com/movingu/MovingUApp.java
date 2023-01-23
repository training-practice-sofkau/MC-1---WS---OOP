package co.com.movingu;

import co.com.movingu.ticket.Ticket;
import co.com.movingu.user.Student;
import co.com.movingu.user.Trainer;
import co.com.movingu.user.User;
import co.com.movingu.vehicle.Scooter;
import co.com.movingu.vehicle.Vehicle;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MovingUApp {
    static List<User> users = new ArrayList<>() {{
        add(new Student("0976152443", "Carolina Montoya", 24, "201547896", "FIEC"));
        add(new Trainer("0976152443", "Washington Pesantez", 36, "lecturer"));
    }};
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        //Lists that contains data related to the WS


        List<Vehicle> vehicles = new ArrayList<>() {{
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

        List<Ticket> tickets = new ArrayList<>() {{
            //add(new Ticket());
            //add(new Ticket());
            //add(new Ticket());

        }};

        //TO DO: Implement the necessary logic to make the menu work
        menu();
        int answer = Integer.parseInt(sc.nextLine());
        switch (answer) {
            case 1:
                registerUser(sc);
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
                User t = new Trainer(trainersPersonalDNI, trainersName, trainerAge, category? "lecturer" : "professor");
                users.add(t);
                System.out.println("Trainer created successfully");
                break;
        }
    }

}