package com.revature.DAO;
import com.revature.util.ConnectionUtil;
import java.sql.*;
import java.util.ArrayList;
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
    public List<Ticket> getAllTickets(int user_id){ //"I am a manager, I can see all tickets". Do not check if this username == own user username, uneeded.
        //THIS username is used to print out that specific user's tickets
        Connection conn = ConnectionUtil.getConnection();
        List<Ticket> tickets = new ArrayList<>();

        try{


            String usSQL = "SELECT users.user_name, tickets.ticket_id, tickets.reason, tickets.amount, tickets.status FROM tickets LEFT JOIN users ON users.? = tickets.created_by;"; //"all except created_by int is needed, bc we have th euser name.
            PreparedStatement stmt = conn.prepareStatement(usSQL);

            stmt.setInt(1, user_id);
            ResultSet rs = stmt.executeQuery(usSQL);

            //I AM STILL IN PROGRESS
            //I AM STILL IN PROGRESS
            //I AM STILL IN PROGRESS

            while (rs.next()){
                Ticket tickets = new Ticket(ticket_id, createdBy, reason, amount, status)
            }
        } catch (SQLException e){
            e.printStackTrace();
        }
        return tickets;
    }
}
