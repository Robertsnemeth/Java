package com.codingdojo.safetravels.controllers;

import java.util.ArrayList;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.codingdojo.safetravels.models.Travels;
import com.codingdojo.safetravels.services.TravelsServices;

@Controller
public class TravelsController {
	
	@Autowired
	TravelsServices travelServices;
	
	@RequestMapping("/")
	public String index() {
		return "redirect:/expenses";
	}
	
	@RequestMapping("/expenses")
	public String expenses(
			@ModelAttribute("travels") Travels travels, 
			Model model) {
		ArrayList<Travels> expenses = travelServices.allTravels();
		model.addAttribute("expenses", expenses);
		return "index.jsp";
	}
	
	@PostMapping("/expenses/add")
	public String create(
			@Valid @ModelAttribute("travels") Travels travels,
			BindingResult result
			) {
		if(result.hasErrors()) {
			return "index.jsp";
		}
		travelServices.createTravels(travels);
		return "redirect:/expenses";
	}
	
	@GetMapping("/expenses/edit/{id}")
	public String editExpenses(
			@ModelAttribute("travels") Travels travels,
			Model model,
			@PathVariable("id") Long id) {
		Travels expense = travelServices.findTravels(id);
		model.addAttribute("expense", expense);
		return "edit.jsp";
	}
	
	@PostMapping("/expenses/updated/{id}")
	public String updatedExpenses(
			@ Valid @ModelAttribute("travels") Travels travels,
			BindingResult result,
			Model model,
			@PathVariable("id") Long id) {
		
		if(result.hasErrors()) {
			model.addAttribute("expense", travelServices.findTravels(id));
			return "edit.jsp";
		}
		travelServices.createTravels(travels);
		return "redirect:/expenses";

	}
	
	@GetMapping("/expenses/{id}")
	public String showExpense(
			@PathVariable("id") Long id,
			Model model) {
		Travels expense = travelServices.findTravels(id);
		model.addAttribute("expense", expense);
		return "show.jsp";
	}
	
	@DeleteMapping("/expenses/delete/{id}")
	public String delete(@PathVariable("id") Long id) {
		travelServices.deleteTravels(id);
		return "redirect:/expenses";
	}
	
}
