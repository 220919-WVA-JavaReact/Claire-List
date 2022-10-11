package com.revature.services;

import com.revature.DAO.TicketDAO;
import com.revature.models.Ticket;
import com.revature.models.User;

import java.util.List;
import java.util.Scanner;
//ticket model, ticketDAO

public class TicketService {
    TicketDAO td = new TicketDAO();

    Scanner io = new Scanner(System.in);
    //I need:: "user_name" to feed to the below. Can i just do a
    //if user.role_num == 2, get all tix. else, only user's own tickets.
    public Ticket create(User user){
       /// Ticket usertick = new Ticket();
        //user.getUser_id();

       // User user = usertick.getUser();


        System.out.println("enter the REASON for this reimbursement request");
        String reason =io.nextLine();

        System.out.println("Enter the AMOUNT you are requesting. Enter only decmial numbers!");
        float amount = io.nextFloat();

        //okay, so we have to pull out the user; the above will not work.

    Ticket tix = td.createTicket(reason, amount, user);
    tix.setUser(user);
        System.out.println("Your ticket: " + tix);
        return tix;

    }

    public void view(User user){ //List<Ticket> view(User user
        System.out.println("Here you can VIEW the tickets.");
       // List<Ticket> allTix = td.getAllTickets(user); //I am creating PROBLEMS at runtime
        System.out.println(user.getUser_name().toString());
       // System.out.println("This USER's tickets: \n" + allTix);
       // return allTix; //ARE YOU HAPPY NOW JAVA
    }

}

    // System.out.println("For whom is this ticket?"); //getUserName();

//    String tusername = io.nextLine();
//
//                                System.out.println("How much should " + tusername + " be reiumbursed?");
//                                        String amount = io.nextLine(); //check to make this a float value!
//
//                                        System.out.println("For what REASON is this reimbursement requested?");
//                                        String reason = io.nextLine();
//
//                                        System.out.println("User " + tusername + " requests " + amount + " for reason \n " + reason);