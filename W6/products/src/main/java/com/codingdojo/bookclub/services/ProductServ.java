package com.codingdojo.bookclub.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.codingdojo.bookclub.models.Category;
import com.codingdojo.bookclub.models.Product;
import com.codingdojo.bookclub.repositories.ProductRepo;

@Service
public class ProductServ {

	@Autowired ProductRepo productRepo;
	
	public Product addProduct(Product p) {
		return productRepo.save(p);
	}
	
	public List<Product> allProducts() {
		return productRepo.findAll();
	}
	
	public Product singleProduct(Long id) {
		Optional<Product> product = productRepo.findById(id);
		if(product.isPresent()) {
			return product.get();
		}
		return null;
	}
	
	public void addCategory(Product p, Category c) {
		p.getCategories().add(c);
		productRepo.save(p);
	}
}
