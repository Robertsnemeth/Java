package com.codingdojo.safetravels.controllers;

import java.util.ArrayList;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
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
}
