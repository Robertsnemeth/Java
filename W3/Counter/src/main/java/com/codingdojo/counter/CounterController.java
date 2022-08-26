package com.codingdojo.counter;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller


public class CounterController {
	
	@RequestMapping("/your_server")
	public String index(HttpSession session) {
		if(session.getAttribute("count") == null) {
			session.setAttribute("count", 0);
			} 
		Integer sessionCount = (Integer) session.getAttribute("count");
		Integer newCount = sessionCount += 1;
		session.setAttribute("count", newCount);
		return "index.jsp";
	}
	
	@RequestMapping("/your_server/counter")
	public String counter(Model model, HttpSession session) {
		Integer currentCount = (Integer) session.getAttribute("count");
		model.addAttribute("theCount", currentCount);
		return "counter.jsp";
	}
	
	@RequestMapping("/your_server/counter/two")
	public String countTwo(Model model, HttpSession session) {
		Integer currentCount = (Integer) session.getAttribute("count");
		Integer newCount = currentCount += 1;
		session.setAttribute("count", newCount);
		Integer countTwo = (Integer) session.getAttribute("count");
		model.addAttribute("theCount", countTwo);
		return "count_two.jsp";
		
	}
	
	@RequestMapping("/your_server/delete")
	public String delete(HttpSession session) {
		session.invalidate();
		return "index.jsp";
	}
	



}
