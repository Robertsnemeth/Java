package com.codingdojo.bookclub.controllers;

import java.util.List;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.codingdojo.bookclub.models.Book;
import com.codingdojo.bookclub.models.LoginUser;
import com.codingdojo.bookclub.models.User;
import com.codingdojo.bookclub.services.AuthServ;
import com.codingdojo.bookclub.services.BookServ;

@Controller
public class AuthController {
	
	@Autowired
	public AuthServ authServ;
	
	@Autowired 
	public BookServ bookServ;

	
	@GetMapping("/")
	public String index(Model model) {
		model.addAttribute("user", new User());
		model.addAttribute("login", new LoginUser());
		return "index.jsp";
	}
	
	@PostMapping("/register")
	public String createUser(@Valid @ModelAttribute("user") User user,
			BindingResult result,
			HttpSession session,
			Model model) {
		authServ.registerValidations(user, result);
		if(result.hasErrors()) {
			model.addAttribute("login", new LoginUser());
			return "index.jsp";
		}
		User newUser = authServ.createUser(user, result);
		session.setAttribute("userId", newUser.getId());
		return "redirect:/dashboard";
	}
	
	@PostMapping("/login")
	public String loginUser(@Valid @ModelAttribute("login") LoginUser login,
			BindingResult result,
			HttpSession session,
			Model model) {
		authServ.loginValidations(login, result);
		if(result.hasErrors()) {
			model.addAttribute("user", new User());
			return "index.jsp";
		}
		User user = authServ.login(login, result);
		session.setAttribute("userId", user.getId());
		return "redirect:/dashboard";
	}
//	
	@GetMapping("/dashboard")
	public String dashboard(Model model,
			HttpSession session) {
		if(null == session.getAttribute("userId")) {
			model.addAttribute("user", new User());
			model.addAttribute("login", new LoginUser());
			return "index.jsp";
		}
		Long userId = (Long) session.getAttribute("userId");
		model.addAttribute("user", authServ.singleUser(userId));
		List<Book> books = bookServ.allBooks();
		model.addAttribute("books", books)
;		return "dash.jsp";
	}
	
	@GetMapping("/logout")
	public String logout(HttpSession session) {
		session.invalidate();
		return "redirect:/";
	}
}
