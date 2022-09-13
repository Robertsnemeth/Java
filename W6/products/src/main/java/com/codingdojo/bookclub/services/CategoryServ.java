package com.codingdojo.bookclub.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.codingdojo.bookclub.models.Category;
import com.codingdojo.bookclub.models.Product;
import com.codingdojo.bookclub.repositories.CategoryRepo;

@Service
public class CategoryServ {

	@Autowired CategoryRepo categoryRepo;
	
	public Category addCategory(Category c) {
		return categoryRepo.save(c);
	}
	
	public List<Category> allCategories() {
		return categoryRepo.findAll();
	}
	
	public Category singleCategory(Long id) {
		Optional<Category> category = categoryRepo.findById(id);
		if(category.isPresent()) {
			return category.get();
		}
		return null;
	}
	
	public void addProduct(Category c, Product p) {
		c.getProducts().add(p);
		categoryRepo.save(c);
	}
}
