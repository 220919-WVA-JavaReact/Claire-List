package com.revature.DAO;
import com.revature.models.User;
import com.revature.util.ConnectionUtil;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
//call getByUsername, extract the user id, feed that to created_by
//also feed this user's user_name to getAllTickets() (--> manager's thing) !

import com.revature.models.Ticket;
public class TicketDAO implements TicketDAOint {
    @Override
    public Ticket createTicket(String reason, float amount, int created_by) {
        Ticket ticket = new Ticket();
        //User user = new User();
       // int created_by = 31; //change bt GET and SET ? //user.getUser_id()

        try (Connection conn = ConnectionUtil.getConnection()){
            String sql = "INSERT INTO tickets (created_by, reason, amount) VALUES (?,?,?)";
            PreparedStatement stmt = conn.prepareStatement(sql);

            stmt.setInt(1, created_by);
            stmt.setString(2, reason);
            stmt.setFloat(3, amount);

            ResultSet rs; //need to dig into this:: not returning any query results...

            if ((rs = stmt.executeQuery()) != null){
                rs.next(); //VERY important that we call next! Otherwise, "waht do you want me to do??"

                int ticket_id = rs.getInt("ticket_id");
                int createdBy = rs.getInt("created_by"); //redundant
                String rson = rs.getString("reason");
                float amnt = rs.getFloat("amount");
                String status = rs.getString("status");

               ticket = new Ticket(ticket_id, createdBy, rson, amnt, status); //dear GOD please work....
               //int ticket_id, int created_by, String reason, float amount, String status
            }

        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Unable to create the ticket, please try again.");
        }

        return ticket;
    }

    @Override
    public List<Ticket> getUserTickets(String user_name) {
        Connection conn = ConnectionUtil.getConnection();
        List<Ticket> tickets = new ArrayList<>();
        // User tixUser = new User();

        try{


            String usSQL = "SELECT users.user_name, tickets.ticket_id, tickets.reason, tickets.amount, tickets.status FROM tickets LEFT JOIN users ON users.user_id = tickets.created_by WHERE users.user_name = '?';"; //"all except created_by int is needed, bc we have th euser name. MOVE THIS LOGIC ABOVE TO GET USER TICKETS!
            PreparedStatement stmt = conn.prepareStatement(usSQL);

            stmt.setString(1, user_name); //now we are getting a COLUMN INDEX IS OUT OF RANGE error. Digging...

            ResultSet rs = stmt.executeQuery(); // let's see if the loop is not a problem anymore

            if ((rs = stmt.executeQuery()) != null) {
                rs.next();


                int ticket_id = rs.getInt("ticket_id");
                int createdBy = rs.getInt("created_by"); //I really REALLY hope this works!
                String reason = rs.getString("reason");
                float amount = Float.parseFloat(rs.getString("amount"));
                String status = rs.getString("password");
                String username = rs.getString("user_name");

                Ticket ticket = new Ticket(ticket_id, createdBy, reason, amount, status, username); // F I X me!
                tickets.add(ticket);
            }

        } catch (SQLException e){
            e.printStackTrace();
        }
        return tickets;
    }


    @Override
    public List<Ticket> getAllTickets(){ // REFACTOR:: SHOULD TAKE IN NO ARGS.
        Connection conn = ConnectionUtil.getConnection();
        List<Ticket> tickets = new ArrayList<>();
       // User tixUser = new User();

        try{


            String usSQL = "SELECT users.user_name, tickets.ticket_id, tickets.reason, tickets.amount, tickets.status FROM tickets LEFT JOIN users ON users.user_id = tickets.created_by;";
            PreparedStatement stmt = conn.prepareStatement(usSQL);



            ResultSet rs = stmt.executeQuery(); // let's see if the loop is not a problem anymore

            if ((rs = stmt.executeQuery()) != null) {
                rs.next();


                int ticket_id = rs.getInt("ticket_id");
                int createdBy = rs.getInt("created_by"); //I really REALLY hope this works!
                String reason = rs.getString("reason");
                float amount = Float.parseFloat(rs.getString("amount"));
                String status = rs.getString("password");
                String username = rs.getString("user_name");

                Ticket ticket = new Ticket(ticket_id, createdBy, reason, amount, status, username); // F I X me!
                tickets.add(ticket);
            }

        } catch (SQLException e){
            e.printStackTrace();
        }
        return tickets;
    }
}
