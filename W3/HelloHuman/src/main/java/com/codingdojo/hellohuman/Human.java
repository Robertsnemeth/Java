package com.codingdojo.hellohuman;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller

public class Human {
	
	@RequestMapping("/")
	public String index(@RequestParam(value = "qfirst_name", required = false) String firstQuery,
			@RequestParam(value = "last_name", required = false) String lastQuery, 
			@RequestParam(value = "times", required = false) String timesQuery  ) {
		if(firstQuery == null && lastQuery == null && timesQuery == null) {
			firstQuery = "Human";
			return "Hello " + firstQuery;
		}
		int times = Integer.parseInt(timesQuery);
		String statement = "";
		for(int i = 0; i < times; i++) {
			statement += "Hello " + firstQuery + " " + lastQuery + " ";
		}
		return statement;
	}
	
	@RequestMapping("/test")
	public String test(Model model) {
		model.addAttribute("fruit", "orange");
		return "Demo.jsp";
	}

}
