package com.codingdojo.bookclub.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.codingdojo.bookclub.models.Book;
import com.codingdojo.bookclub.models.User;
import com.codingdojo.bookclub.repositories.BookRepo;

@Service
public class BookServ {
	private BookRepo bookRepo;
	
	public BookServ(BookRepo bookRepo) {
		this.bookRepo = bookRepo;
	}
	
	
	public Book createBook(Book b) {
		return bookRepo.save(b);
	}
	
	public List<Book> allBooks() {
		return bookRepo.findAll();
	}
	
	public Book singleBook(Long id) {
		Optional<Book> book = bookRepo.findById(id);
		if(book.isPresent()) {
			return book.get();
		} else {
			return null;
		}
	}
	
	public void deleteBook(Long id) {
		Optional<Book> book = bookRepo.findById(id);
		if(book.isPresent()) {
			 bookRepo.deleteById(id);
		} else {
			return;
		}
	}
	
	public void addBorrowed(Book b, User u) {
		b.setBorrowed(u);
		bookRepo.save(b);
	}
	
	public List<Book> allBorrowed(Long id) {
		return bookRepo.findAllByBorrowedId(id);
	}
	
	
	public Book singleBorrowed(Long id) {
		Optional<Book> book = bookRepo.findById(id);
		if(book.isPresent()) {
			return book.get();
		} else {
			return null;
		}
	}
	
	public void returnBook(Book b) {
		b.setBorrowed(null);
		bookRepo.save(b);
	}
}
