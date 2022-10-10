package com.revature.services;

import com.revature.DAO.TicketDAO;
import com.revature.models.Ticket;
import com.revature.models.User;

import java.util.Scanner;
//ticket model, ticketDAO

public class TicketService {
    TicketDAO td = new TicketDAO();

    Scanner io = new Scanner(System.in);
    //I need:: "user_name" to feed to the below. Can i just do a
    //if user.role_num == 2, get all tix. else, only user's own tickets.
    public Ticket create(){
        Ticket usertick = new Ticket();
        //user.getUser_id();

        User user = usertick.getUser();


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