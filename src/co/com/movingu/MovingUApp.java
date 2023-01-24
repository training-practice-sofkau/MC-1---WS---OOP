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
                    Integer option;
                    System.out.println("Type 1 to borrow a vehicle or 2 to return one");
                    option=util.captureInt();
                    if (option==1){
                    try {
                        tickets.addTicket();
                    } catch (Exception e) {
                        System.out.println("Please verify the input data and try again");;
                    }}
                    if (option==2){
                        System.out.println("Type ticket ID");
                        String ticketId = util.captureString();
                        tickets.returnVehicle(tickets.getTicket(ticketId));
                    }

                    break;
                case 3 ://Pay a ticket
                    System.out.println("Type ticket ID:");
                    String ticketIdToPay = util.captureString();
                    tickets.payTicket(tickets.getTicket(ticketIdToPay));
                    break;
                case 4 ://Search available
                    System.out.println("Available vehicles:");
                    System.out.println(vehicles);
                    break;
                case 5 ://Exit
                    System.out.println("The app has finished");
                    break;
                case 6 ://Shows tickets
                    System.out.println(tickets);
                    break;
                case 7:
                    System.out.println(tickets.getTicket("0")
                            .calculateDebt("B",vehicles.getVehicleById("B-001") ));
                default:
                    System.out.println("Invalid option");
                    break;
            }
            //System.out.println("Presione 'enter' para continuar");

        }while (option != 5);


    }


    }

