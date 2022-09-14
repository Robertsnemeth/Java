package com.codingdojo.manager.models.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.codingdojo.manager.models.Ticket;

@Repository
public interface TicketRepo extends CrudRepository<Ticket, Long>{

	public List<Ticket> findAll();
}
