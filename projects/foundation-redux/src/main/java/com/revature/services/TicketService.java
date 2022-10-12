package com.revature.services;

import com.revature.DAO.TicketDAO;
import com.revature.models.Ticket;
import com.revature.models.User;

import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.List;
import java.util.Scanner;

public class TicketService {
    TicketDAO td = new TicketDAO();

    Scanner io = new Scanner(System.in);
    //I need:: "user_name" to feed to the below. Can i just do a
    //if user.role_num == 2, get all tix. else, only user's own tickets.
    public Ticket create(){
       /// Ticket usertick = new Ticket();
        //user.getUser_id();

       // User user = usertick.getUser();

        System.out.println("For WHOMST is this ticket? (enter the user's ID)");
        int createdBy = Integer.parseInt(io.nextLine()); //let's hope this stops the skipping...
        System.out.println("enter the REASON for this reimbursement request"); //for some reason, I am being skipped...
        String reason = io.nextLine();

        System.out.println("Enter the AMOUNT you are requesting. Enter only decmial numbers!");
        float amount = io.nextFloat();

        DecimalFormat df = new DecimalFormat("##.##");
        df.setRoundingMode(RoundingMode.DOWN);


    Ticket tix = td.createTicket(reason, Float.parseFloat(df.format(amount)), createdBy); //jesus CHRIST JAVA D:<
   // tix.setUser(user);
        System.out.println("Your ticket: " + tix);
        return tix;

    }

    public List<Ticket> view(){ //List<Ticket> view(User user
        System.out.println("Here you can VIEW the tickets.");
        System.out.println("Enter your USERNAME for verification.");
        String user = io.nextLine();

        List<Ticket> allTix = td.getUserTickets(user); //I am creating PROBLEMS at runtime
        System.out.println(allTix); //user is still NULL ??????????????
       // System.out.println("This USER's tickets: \n" + allTix);
        return allTix; //in case we want to DO something with this...
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