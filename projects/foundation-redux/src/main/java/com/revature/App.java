package com.revature;

import java.util.Scanner;

import com.revature.services.UsersService;

public class App {
    public static void main(String[] args) {
//        Connection c = ConnectionUtil.getConnection();
//        try {
//            System.out.println(c.getMetaData().getDriverName());
//        } catch (SQLException e) {
//            throw new RuntimeException(e);
//        }
//
//    }
        // public static UsersService us = new UsersService(); //when built...

        UsersService us = new UsersService(); //...let's check this is wired up ...
        boolean on = true; //I control the application run state. Switch to false to exit program execution.
        //initialize user objs, for prosperity
        boolean tickContext = false; //I control the context for ticket menu. Set me to TRUE to toggle ticket context menu ie

        //NEXT TODO: BUILD interface for creating tickets, viewing tickets
        //must take in username, amount, and reason
        System.out.println("Type 1 to login with your credentials; 2 to register. Press 'q' to exit this program.");
        while (on) {
            Scanner io = new Scanner(System.in);
            String choice = io.nextLine();


            switch (choice) {
                case "1":
                    us.login();
                    break;

                case "l":
                    System.out.println("Type 1 to login with your credentials; 2 to register. Press 'q' to exit this program.");
                    break;

                case "t":
                    System.out.println("Type 'v' to view tickets, 'n' to create a new ticket \n or type 'q' to return to previous menu.");
                    tickContext = true;
                    String tickop = io.nextLine();


                    while (tickContext) {

                        switch (tickop) {
                            case "v":
                                System.out.println("Here is where you can view tickets!");
                                break;

                            case "n":
                                System.out.println("Create a NEW ticket here!");
                                System.out.println("For whom is this ticket?"); //getUserName();

                                String tusername = io.nextLine();

                                System.out.println("How much should " + tusername + " be reiumbursed?");
                                String amount = io.nextLine(); //check to make this a float value!

                                System.out.println("For what REASON is this reimbursement requested?");
                                String reason = io.nextLine();

                                System.out.println("User " + tusername + " requests " + amount + " for reason \n " + reason);
                                break;
                            //ticket.createTicket(infos);

                            case "q":
                                tickContext = false;
                                System.out.println("type 't' to view ticket menu options, or 'l' to logout.");
                                break;

                            default:
                                System.out.println("Unknown input, please try again.");
                        }
                    }
                    break;

                case "2":
                    us.register();
                    break;
                case "q":
                    on = false;
                    break;

                default:
                    System.out.println("Invalid INPUT, please try again.");
            }
        }
    }
}

