package com.codingdojo.manager.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.codingdojo.manager.models.Ticket;
import com.codingdojo.manager.models.repositories.TicketRepo;

@Service
public class TicketServ {

	@Autowired TicketRepo ticketRepo;
	
	public Ticket createTicket(Ticket t) {
		return ticketRepo.save(t);
	}
	
	public List<Ticket> allTickets(){
		return ticketRepo.findAll();
	}
}
