package com.codingdojo.bookclub.controllers;

import java.util.List;

import javax.servlet.http.HttpSession;
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

import com.codingdojo.bookclub.models.Book;
import com.codingdojo.bookclub.models.LoginUser;
import com.codingdojo.bookclub.models.User;
import com.codingdojo.bookclub.services.AuthServ;
import com.codingdojo.bookclub.services.BookServ;

@Controller
public class BookController {
	
	@Autowired BookServ bookServ;
	
	@Autowired AuthServ authServ;
	
	@GetMapping("/book/add")
	public String newBook(@ModelAttribute("book") Book book,
			HttpSession session,
			Model model) {
		if(null == session.getAttribute("userId")) {
			model.addAttribute("user", new User());
			model.addAttribute("login", new LoginUser());
			return "index.jsp";
		}
		return "add.jsp";
	}
	
	@PostMapping("/book/add")
	public String addBook(@Valid @ModelAttribute("book") Book book,
			BindingResult result,
			HttpSession session,
			Model model) {
		if(result.hasErrors()) {
			return "add.jsp";
		}
		Long userId = (Long) session.getAttribute("userId");
		model.addAttribute("userId", userId);
		bookServ.createBook(book);
		return "redirect:/dashboard";
	}
	
	@GetMapping("book/show/{id}")
	public String showBook(@PathVariable("id") Long id, 
			Model model,
			HttpSession session) {
		if(null == session.getAttribute("userId")) {
			model.addAttribute("user", new User());
			model.addAttribute("login", new LoginUser());
			return "index.jsp";
		}
		Long userId = (Long) session.getAttribute("userId");
		model.addAttribute("userId", userId);
		Book book = bookServ.singleBook(id);
		model.addAttribute("book", book);
		return "show.jsp";
	}
	
	@GetMapping("book/edit/{id}")
	public String editBook(@PathVariable("id") Long id,
			@ModelAttribute("book") Book book,
			Model model, 
			HttpSession session) {
		if(null == session.getAttribute("userId")) {
			model.addAttribute("user", new User());
			model.addAttribute("login", new LoginUser());
			return "index.jsp";
		}
		Book singleBook = bookServ.singleBook(id);
		model.addAttribute("singleBook", singleBook);
		return "update.jsp";
	}
	
	@PutMapping("book/edit/{id}")
	public String updateBook(@PathVariable("id") Long id,
			@Valid @ModelAttribute("book") Book book,
			BindingResult result,
			Model model,
			HttpSession session) {
		if(result.hasErrors()) {
			Book singleBook = bookServ.singleBook(id);
			model.addAttribute("singleBook", singleBook);
			Long userId = (Long) session.getAttribute("userId");
			model.addAttribute("userId", userId);
			return "update.jsp";
		}
		Long userId = (Long) session.getAttribute("userId");
		model.addAttribute("userId", userId);
		bookServ.createBook(book);
		return "redirect:/dashboard";
	}
	@DeleteMapping("book/delete/{id}")
	public String deleteBook(@PathVariable("id") Long id) {
		bookServ.deleteBook(id);
		return "redirect:/dashboard";
	}
	
	@GetMapping("/book/broker/{id}")
	public String broker (@PathVariable("id") Long id,
			@ModelAttribute("borrowedBook") Book borrowedBook,
			Model model,
			HttpSession session) {
				if(null == session.getAttribute("userId")) {
					model.addAttribute("user", new User());
					model.addAttribute("login", new LoginUser());
					return "index.jsp";
				}
				Long userId = (Long) session.getAttribute("userId");
				model.addAttribute("user", authServ.singleUser(userId));
				List<Book> books = bookServ.allBooks();
				model.addAttribute("books", books);
				List<Book> borrow = bookServ.allBorrowed(id);
				model.addAttribute("borrow", borrow);
				return "broker.jsp";
			}
	
	@RequestMapping("/book/borrow/{id}")
	public String borrow(
			@PathVariable("id") Long id,
			HttpSession session,
			Model model) {
		if(null == session.getAttribute("userId")) {
			model.addAttribute("user", new User());
			model.addAttribute("login", new LoginUser());
			return "index.jsp";
		}
		Long userId = (Long) session.getAttribute("userId");
		bookServ.addBorrowed(bookServ.singleBook(id), authServ.singleUser(userId));
		return "redirect:/book/broker/" + userId;
	}
	
	@RequestMapping("/book/return/{id}")
	public String returnBook (@PathVariable("id") Long id,
			HttpSession session,
			Model model) {
		if(null == session.getAttribute("userId")) {
			model.addAttribute("user", new User());
			model.addAttribute("login", new LoginUser());
			return "index.jsp";
		}
		Long userId = (Long) session.getAttribute("userId");
		bookServ.returnBook(bookServ.singleBook(id));
		return "redirect:/book/broker/" + userId;
	}
}
