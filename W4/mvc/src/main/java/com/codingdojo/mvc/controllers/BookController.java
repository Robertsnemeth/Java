package com.codingdojo.mvc.controllers;

import java.util.ArrayList;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.codingdojo.mvc.models.Book;
import com.codingdojo.mvc.services.BookService;

@Controller
public class BookController {
	
	@Autowired
	BookService bookService;
	
	@RequestMapping("/books")
	public String books(Model model) {
		ArrayList<Book> books = bookService.allBooks();
		model.addAttribute("books", books);
		return "index.jsp";
	}
		
	@GetMapping("/books/{id}")
	public String books(Model model, @PathVariable("id") Long id) {
		Book book = bookService.findBook(id);
		model.addAttribute("book", book);
		
		return "show.jsp";
	}
	
	@RequestMapping("/books/new")
	public String newBook(@ModelAttribute("book") Book book) {
		return "newBook.jsp";
	}
	
	@PostMapping("/books/new/add")
	public String create(
			@Valid @ModelAttribute("book") Book book,
			BindingResult result
			) {
		if(result.hasErrors()) {
			return "newBook.jsp";
		}
			bookService.createBook(book);
			return "redirect:/books";
		}
	
}
