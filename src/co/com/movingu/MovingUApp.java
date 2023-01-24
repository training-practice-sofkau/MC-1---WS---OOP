package co.com.movingu;

import co.com.movingu.ticket.Ticket;
import co.com.movingu.ticket.TiketList;
import co.com.movingu.user.Student;
import co.com.movingu.user.Trainer;
import co.com.movingu.user.User;
import co.com.movingu.user.UserList;
import co.com.movingu.vehicle.Bicycle;
import co.com.movingu.vehicle.Scooter;
import co.com.movingu.vehicle.Vehicle;
import co.com.movingu.vehicle.VehicleList;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import static co.com.movingu.vehicle.VehicleList.vehicles;

public class MovingUApp {

    public static void main(String[] args) {

        int menuOption = 0;

        Scanner in = new Scanner(System.in);



        try {
            do {
                menu();
                menuOption = in.nextInt();

                switch (menuOption) {
                    case 1 :
                        registerUser(in);
                        break;
                    case 2 :
                        borrowReturn(in);
                        break;
                    case 4:
                        System.out.println("Vehicles - is available?");
                        for (int i = 0; i < vehicles.size(); i++) {
                            System.out.println(vehicles.get(i).getId() + " - " + vehicles.get(i).isAvailable());
                        }
                        break;
                    case 5 :
                        System.out.println("Bye!");
                        break;
                    default :
                        System.out.println("Invalid menu option\ns");
                        break;
                }
            } while (menuOption != 5);
        } catch (InputMismatchException e) {
            System.out.println("Invalid input type option\n");
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

    public static void borrowReturn(Scanner in){
        System.out.print("Action to do: Borrow (B) / Return (R)");
        String action = in.next().toUpperCase();

        switch (action){
            case "B":
                borrowVehicle(in);
                break;
            case "R":
                //returnVehicle(in);
                break;
            default:
                System.out.println("Invalid option\n");
                break;
        }
    }

    public static void borrowVehicle(Scanner in) {
        System.out.println("Type the user DNI");
        String userDni = in.next();

        User currentUser = null;

        for (User user : UserList.users) {
            if(user.getDni().equals(userDni)) {
                currentUser = user;
            }
        }
        if (currentUser == null) {
            System.out.println("User not registered\n");
            return;
        }
        if (currentUser.isBlocked()) {
            System.out.println("User blocked\n");
            return;
        }

        System.out.println("Choose a type of vehicle: Bicycle (B) / Scooter (S)");
        String vehicleType = in.next().toUpperCase();

        Vehicle assingnedVehicle = null;

        switch (vehicleType){
            case "B":
                int i = 0;
                do {
                    if(vehicles.get(i).isAvailable() && vehicles.get(i).getId().startsWith("B")){
                        assingnedVehicle = VehicleList.vehicles.get(i);
                    }
                    i++;
                }while (assingnedVehicle == null);
                genTicket(currentUser, assingnedVehicle);
                break;
            case "S":
                int j = 0;
                do {
                    if(vehicles.get(j).isAvailable() && vehicles.get(j).getId().startsWith("S")){
                        assingnedVehicle = VehicleList.vehicles.get(j);
                    }
                    j++;
                }while (assingnedVehicle == null);
                genTicket(currentUser, assingnedVehicle);
                break;
            default:
                System.out.println("Invalid option\n");
                break;
        }
    }

    public static void genTicket(User user, Vehicle vehicle){
        Ticket ticket = new Ticket(user, vehicle);
        user.setBlocked(true);
        vehicle.setAvailable(false);
        TiketList.tickets.add(ticket);
        System.out.println(ticket.toString());
    }

    public static void registerUser(Scanner in){
        System.out.println("DNI number:");
        String userDni = in.next();

        System.out.println("User name:");
        String userName = in.next();

        System.out.println("User age:");
        int userAge = in.nextInt();

        System.out.print("User is: Student (S) / Trainer (T)");
        String userType = in.next().toUpperCase();

        switch (userType) {
            case "S" :
                System.out.println("Student college DNI");
                String userCollegeDni = in.next();
                System.out.println("Student faculty");
                String userFaculty = in.next();
                User s = new Student(userDni, userName, userAge, userCollegeDni, userFaculty);
                UserList.users.add(s);
                System.out.println("Student " + userName + " created successfully");
                break;
            case "T":
                System.out.println("Trainer category: ");
                String userCategory = in.next();
                User t = new Trainer(userDni, userName, userAge, userCategory);
                UserList.users.add(t);
                System.out.println("Trainer " + userName + " created successfully");
                break;
            default:
                System.out.println("Invalid option");
                break;
        }
    }

}