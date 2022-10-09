package com.revature.DAO;

import com.revature.models.Ticket;

import java.util.List;

public interface TicketDAOint {
    Ticket createTicket(int created_by, String reason, float amount, String status);

    List<Ticket> getUserTickets(); //"I am an employee, I can only see MY tickets"

    List<Ticket> getAllTickets(); //"I am a manager, I can see all tickets"
}
