package com.codingdojo.manager.controllers;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.codingdojo.manager.models.Project;
import com.codingdojo.manager.models.Ticket;
import com.codingdojo.manager.services.AuthServ;
import com.codingdojo.manager.services.ProjectServ;
import com.codingdojo.manager.services.TicketServ;

@Controller
public class TicketController {

	@Autowired AuthServ authServ;
	@Autowired ProjectServ projectServ;
	@Autowired TicketServ ticketServ;
	
	@GetMapping("/ticket/new/{id}") 
	public String newTicket(@ModelAttribute("tickets") Ticket t,
			@PathVariable("id") Long id,
			Model model, 
			HttpSession session) {
		Long userId = (Long) session.getAttribute("userId");
		model.addAttribute("project", projectServ.singleProject(id));
		model.addAttribute("userId", userId);
		return "ticket.jsp";
	}
	
	@PostMapping("/ticket/new/{id}")
	public String addTicket(@Valid @ModelAttribute("tickets") Ticket t,
			BindingResult result,
			Model model,
			HttpSession session,
			@PathVariable("id") Long id) {
		if(result.hasErrors()) {
			Long userId = (Long) session.getAttribute("userId");
			model.addAttribute("project", projectServ.singleProject(id));
			model.addAttribute("userId", userId);
			return "ticket.jsp";
		}
		Ticket ticket = ticketServ.createTicket(t);
		Project project = projectServ.singleProject(id);
		project.getTickets().add(ticket);
		projectServ.updateProject(project);
		return "redirect:/ticket/new/{id}";
	}
}
