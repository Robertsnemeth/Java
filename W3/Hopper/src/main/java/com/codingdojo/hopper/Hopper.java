package com.codingdojo.hopper;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller

public class Hopper {
	// class definition and imports here...
    @RequestMapping("/")
    public String index(Model model) {
        
        String name = "Bobby Nemeth";
        String itemName = "Larb";
        double price = 50.25;
        String description = "Thai dish involving gournd meat and thai vegetables and herbs served with rice";
        String vendor = "My kitchen";
    
    	// Your code here! Add values to the view model to be rendered
    
        model.addAttribute("name", name);
        model.addAttribute("itemName", itemName);
        model.addAttribute("price", price);
        model.addAttribute("description", description);
        model.addAttribute("vendor", vendor);

        return "index.jsp";
        
    }
    
    @RequestMapping("/date")
    public String date(Model model) {
    	String pattern = "EEEEE dd MMMM, yyyy";
    	SimpleDateFormat formatter = new SimpleDateFormat(pattern);
    	String date = formatter.format(new Date());
    	model.addAttribute("date", date);
    	return "date.jsp";
    }
    @RequestMapping("/time")
    public String time(Model model) {
    	String pattern = "KK:MMa";
    	SimpleDateFormat formatter = new SimpleDateFormat(pattern);
    	String time = formatter.format(new Date());
    	model.addAttribute("time", time);
    	return "time.jsp";
    }
    


}
