package com.revature.DAO;
import com.revature.util.ConnectionUtil;
import java.sql.*;
import java.util.List;
//call getByUsername, extract the user id, feed that to created_by
//also feed this user's user_name to getAllTickets() (--> manager's thing) !

import com.revature.models.Ticket;
public class TicketDAO implements TicketDAOint {
    @Override
    public Ticket createTicket(String reason, float amount, String status) {
        Ticket ticket = new Ticket();

        try (Connection conn = ConnectionUtil.getConnection()){
            String sql = "INSERT INTO tickets () VALUES (?,?,?,?)";
            PreparedStatement stmt = conn.prepareStatement(sql);


        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Unable to create the ticket, please try again.");
        }

        return ticket;
    }

    @Override
    public List<Ticket> getUserTickets(String user_name) {
        return null;
    }

    @Override
    public List<Ticket> getAllTickets(String user_name) {
        return null;
    }
}