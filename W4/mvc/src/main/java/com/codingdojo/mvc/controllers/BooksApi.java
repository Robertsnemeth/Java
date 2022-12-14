package com.codingdojo.mvc.controllers;


import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.codingdojo.mvc.models.Book;
import com.codingdojo.mvc.services.BookService;

@RestController
public class BooksApi {
	private final BookService bookService;
	
	public BooksApi(BookService bookService) {
		this.bookService = bookService;
	}
	
	@RequestMapping("/")
	public String index() {
		return "redirect:/api/books";
	}
	
//	@RequestMapping("/api/books")
//	public List<Book> books() {
//		return bookService.allBooks();
//	}
	
	@RequestMapping(value="/api/books", method=RequestMethod.POST )
	public Book create(
			@RequestParam(value="title") String title,
			@RequestParam(value="description") String description,
			@RequestParam(value="language") String language,
			@RequestParam(value="numberOfPages") Integer numberOfPages
			) {
			Book book = new Book(title, description, language, numberOfPages);
			return bookService.createBook(book);
		}
	
	@RequestMapping(value="/api/books/update/{id}", method=RequestMethod.POST )
	public Book update(
			@PathVariable("id") Long id,
			@RequestParam(value="title") String title,
			@RequestParam(value="description") String description,
			@RequestParam(value="language") String language,
			@RequestParam(value="numberOfPages") Integer numberOfPages
			) {
			Book book = bookService.findBook(id);
			book.setTitle(title);
			book.setDescription(description);
			book.setLanguage(language);
			book.setNumberOfPages(numberOfPages);
			return bookService.createBook(book);
		}
	
	@RequestMapping("/api/books/{id}")
	public Book show(@PathVariable("id") Long id) {
		Book book = bookService.findBook(id);
		return book;
	}
	
	@RequestMapping("/api/books/delete/{id}")
	public void delete(@PathVariable("id") Long id) {
		bookService.deleteBook(id);
	}
}

