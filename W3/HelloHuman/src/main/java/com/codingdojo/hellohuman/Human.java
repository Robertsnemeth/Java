package com.codingdojo.hellohuman;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController

public class Human {
	
	@RequestMapping("/")
	public String index(@RequestParam(value = "qfirst_name", required = false) String firstQuery, @RequestParam(value = "last_name", required = false) String lastQuery, @RequestParam(value = "times", required = false) String timesQuery  ) {
		if(firstQuery == null && lastQuery == null && timesQuery == null) {
			firstQuery = "Human";
			return "Hello " + firstQuery;
		}
		int times = Integer.parseInt(timesQuery);
		return ("Hello " + firstQuery + " " + lastQuery);
	}

}
