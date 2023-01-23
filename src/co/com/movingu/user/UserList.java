package co.com.movingu.user;

import co.com.movingu.utilities.Utilities;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class UserList {
    private List<User> users;
    private Utilities util;

    /**
     * Constructor of the list of user with
     * an initial userlist
     */
    public UserList() {
        this.users = new ArrayList<>() {{
            add(new Student("0976152443", "Carolina Montoya", 24, "201547896", "FIEC"));
            add(new Trainer("0976152443", "Washington Pesantez", 36, "lecturer"));
        }};
    }

    public List<User> getUsers() {
        return users;
    }

    public void registerUser() {
        System.out.println("Type your DNI");
        String dni = util.captureString();
        System.out.println("Type your Age");
        Integer age = util.captureInt();
        System.out.println("Type your Name");
        String name = util.captureString();
        System.out.print("User is: Student (S) / Trainer (T)?");
        String type = util.captureString();

        switch (type) {
            case "S":
                // Ask the college DNI and he faculty
                System.out.println("Type your college DNI");
                String collegeDNI = util.captureString();
                System.out.println("Type your faculty");
                String faculty = util.captureString();
                //create the student object
                User s = new Student(dni, name, age, collegeDNI, faculty);
                users.add(s);
                System.out.println("Successfully registered user");
                break;

            case "T":
                System.out.println("Type your category");
                String category = util.captureString();
                //create the trainer object
                User t = new Trainer(dni, name, age, category);
                users.add(t);
                System.out.println("Successfully registered user");
                break;
            default:
                System.out.println("Invalid option");
                break;

        }

    }


}
