package com.codingdojo.omikuji;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller

public class OmikujiController {
	
	@RequestMapping("/")
	public String index() {
		return "redirect:/login_page";
	}
	
	@RequestMapping("/login_page") 
	public String login_page() {
		return "login.jsp";
	}
	
	@PostMapping("/login")
	public String login( 
			@RequestParam(value="number") String number,
			@RequestParam(value="city") String city,
			@RequestParam(value="person") String person,
			@RequestParam(value="hobby") String hobby,
			@RequestParam(value="thing") String thing,
			@RequestParam(value="statement") String statement,
			HttpSession session
			) {
		
		session.setAttribute("number", number);
		session.setAttribute("city", city);
		session.setAttribute("person", person);
		session.setAttribute("hobby", hobby);
		session.setAttribute("thing", thing);
		session.setAttribute("statement", statement);

		return "redirect:/omikuji";
	}
	
	@RequestMapping("/omikuji")
	public String omikuji(Model model, HttpSession session) {
		
		String number = (String) session.getAttribute("number");
		String city = (String) session.getAttribute("city");
		String person = (String) session.getAttribute("person");
		String hobby = (String) session.getAttribute("hobby");
		String thing = (String) session.getAttribute("thing");
		String statement = (String) session.getAttribute("statement");
		
		model.addAttribute("number", number);
		model.addAttribute("city", city);
		model.addAttribute("person", person);
		model.addAttribute("hobby", hobby);
		model.addAttribute("thing", thing);
		model.addAttribute("statement", statement);
	
		return "omikuji.jsp";
	}
	
	@RequestMapping("/home")
	public String home(HttpSession session) {
		session.invalidate();
		return "redirect:/login_page";
	}
	

}
