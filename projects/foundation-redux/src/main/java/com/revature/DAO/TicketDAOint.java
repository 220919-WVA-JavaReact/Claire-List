package com.revature.DAO;

import com.revature.models.Ticket;
import com.revature.util.ConnectionUtil;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public interface TicketDAOint {
    Ticket createTicket(String reason, float amount, String status);

    List<Ticket> getUserTickets(String user_name); //"I am an employee, I can only see MY tickets". If user_name = user.getUser_name() , allow
                                                                                                    // else, disallow

    List<Ticket> getAllTickets(String user_name){ //"I am a manager, I can see all tickets". Do not check if this username == own user username, uneeded.
        //THIS username is used to print out that specific user's tickets
        Connection conn = ConnectionUtil.getConnection();
        List<Ticket> tickets = new ArrayList<>();

        try{
            Statement stmt = conn.createStatement();

            String usSQL = "SELECT tickets.*, users.user_name FROM tickets LEFT JOIN users ON users.user_id = tickets.created_by;";
            ResultSet rs = stmt.executeQuery(usSQL);

            while (rs.next()){

            }
        } catch (SQLException e){
            e.printStackTrace();;
        }
    }
}
