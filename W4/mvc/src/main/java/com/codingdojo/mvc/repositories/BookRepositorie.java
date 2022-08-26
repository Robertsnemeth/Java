package com.codingdojo.mvc.repositories;

import java.util.ArrayList;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.codingdojo.mvc.models.Book;

@Repository
public interface BookRepositorie extends CrudRepository<Book, Long> {
	
	ArrayList<Book> findAll();


}
