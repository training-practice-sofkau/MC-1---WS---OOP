package co.com.movingu;

import co.com.movingu.ticket.Ticket;
import co.com.movingu.ticket.TicketList;
import co.com.movingu.user.Student;
import co.com.movingu.user.Trainer;
import co.com.movingu.user.User;
import co.com.movingu.user.UserList;
import co.com.movingu.utilities.Utilities;
import co.com.movingu.vehicle.Scooter;
import co.com.movingu.vehicle.Vehicle;
import co.com.movingu.vehicle.VehicleInventory;


import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class MovingUApp {
    private static int option;

    public static void main(String[] args) {
        Utilities util = new Utilities();
        UserList userList = new UserList();
        VehicleInventory vehicles = new VehicleInventory();
        TicketList tickets = new TicketList(vehicles, userList);


        do{
            util.menu();
            option = util.captureInt();
            switch (option) {
                 case 1 ://register
                    userList.registerUser();
                    break;
                case 2 ://Borrow/return
                    try {
                        tickets.addTicket();
                    } catch (Exception e) {
                        System.out.println("Please verify the input data and try again");;
                    }

                    break;
                case 3 ://Pay a ticket

                    break;
                case 4 ://Search available
                    System.out.println("Available vehicles:");
                    System.out.println(vehicles);
                    break;
                case 5 ://Exit
                    System.out.println("The app has finished");
                    break;
                default:
                    System.out.println("Invalid option");
                    break;
            }
            //System.out.println("Presione 'enter' para continuar");
            /*try {
                System.in.read();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }*/
        }while (option != 5);


    }


    }

