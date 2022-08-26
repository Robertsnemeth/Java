package com.codingdojo.Gold;

import java.util.ArrayList;
import java.util.Random;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller

@SuppressWarnings("unchecked")
public class GoldController {
	
	@RequestMapping("/")
	public String index() {
		return "redirect:/gold";
	}
	
	@RequestMapping("/gold")
	public String gold(Model model, HttpSession session) {
		
		ArrayList<String> activities = new ArrayList<String>();
		
		if(session.getAttribute("gold") == null) {
			session.setAttribute("gold", 0);
			session.setAttribute("activities", activities);
		}
		Integer gold = (Integer) session.getAttribute("gold");
		activities = (ArrayList<String>) session.getAttribute("activities");
		if(gold <= -50) {
			return "prison.jsp";
		}
		model.addAttribute("gold", gold);
		model.addAttribute("activities", activities);
		return "Gold.jsp";
	}
	
	@PostMapping("/gold/add")
	public String addGold(
			@RequestParam(value="gold10", required=false) String gold10,
			@RequestParam(value="gold5", required=false) String gold5,
			@RequestParam(value="gold2", required=false) String gold2,
			@RequestParam(value="gold50", required=false) String gold50,
			@RequestParam(value="spa", required=false) String spa,
			@RequestParam(value="reset", required=false) String reset,
			HttpSession session
			) {
		
		Random r = new Random();
		
		Integer goldNew = (Integer) session.getAttribute("gold");
		
		ArrayList<String> activities = new ArrayList<String>();
		
		
		if(gold10 != null) {
			Integer randAmount = r.nextInt(10,21);
			goldNew += randAmount;
			session.setAttribute("gold", goldNew);
			activities.add("You have added " + randAmount + " gold to your account");
			session.setAttribute("activities", activities);

			
			return "redirect:/gold";
			}
		
		if(gold5 != null) {
			Integer randAmount = r.nextInt(5,11);
			goldNew += randAmount;
			session.setAttribute("gold", goldNew);
			activities.add("You have added " + randAmount + " gold to your account");
			session.setAttribute("activities", activities);

			
			return "redirect:/gold";
			}
		
		if(gold2 != null) {
			Integer randAmount = r.nextInt(2,6);
			goldNew += randAmount;
			session.setAttribute("gold", goldNew);
			activities.add("You have added " + randAmount + " gold to your account");
			session.setAttribute("activities", activities);

			
			return "redirect:/gold";
			}
		
		if(gold50 != null) {
			Integer randAmount = r.nextInt(0,51);
			goldNew += randAmount;
			session.setAttribute("gold", goldNew);
			activities.add("You have added " + randAmount + " gold to your account");
			session.setAttribute("activities", activities);
			

			
			return "redirect:/gold";
			}
				
		if(spa != null) {
			Integer randAmount = r.nextInt(5,21);
			goldNew -= randAmount;
			session.setAttribute("gold", goldNew);
			activities.add("You have lost " + randAmount + " gold to your account");
			session.setAttribute("activities", activities);
			
			return "redirect:/gold";
		}
		
		if(reset != null) {
			session.invalidate();
			return "redirect:/gold";
		}
		
		return "redirect:/gold";
	}
}
