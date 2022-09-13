package com.codingdojo.bookclub.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.codingdojo.bookclub.models.Category;
import com.codingdojo.bookclub.models.Product;
import com.codingdojo.bookclub.services.CategoryServ;
import com.codingdojo.bookclub.services.ProductServ;

@Controller
public class HomeController {

	@Autowired ProductServ productServ;
	
	@Autowired CategoryServ categoryServ;
	
	@GetMapping("/")
	public String home(Model model) {
		model.addAttribute("products", productServ.allProducts());
		model.addAttribute("categories", categoryServ.allCategories());
		return "index.jsp";
	}
	
//	==========PRODUCTS ROUTES==========
	@GetMapping("/product/new")
	public String product(@ModelAttribute("product") Product prodcut) {
		return "product.jsp";
	}
	
	@PostMapping("/product/new")
	public String addProduct(
			@Valid @ModelAttribute("product") Product product,
			BindingResult result) {
		productServ.addProduct(product);
		return "redirect:/";
	}
	
	@GetMapping("/product/add/category/{id}")
	public String productAddCategory(@PathVariable("id") Long id,
			Model model) {
		model.addAttribute("product", productServ.singleProduct(id));
		model.addAttribute("categories", categoryServ.allCategories());
		return "showproduct.jsp";
	}
	
	@PostMapping("/product/add/category/{id}")
	public String categoryAdded(@PathVariable("id") Long id,
			@RequestParam(value="categoryId") Long categoryId) {
		Product p = productServ.singleProduct(id);
		Category c = categoryServ.singleCategory(categoryId);
		productServ.addCategory(p, c);
		return "redirect:/product/add/category/" + id;
	}
	
//	==========CATEGORY ROUTES==========
	@GetMapping("/category/new")
	public String category(@ModelAttribute("category") Category category) {
		return "category.jsp";
	}
	
	@PostMapping("/category/new")
	public String addCategory(
			@Valid @ModelAttribute("category") Category category,
			BindingResult result) {
		categoryServ.addCategory(category);
		return "redirect:/";
	}
	
	@GetMapping("/category/add/product/{id}")
	public String categoryAddProduct(@PathVariable("id") Long id,
			Model model) {
		model.addAttribute("category", categoryServ.singleCategory(id));
		model.addAttribute("products", productServ.allProducts());
		return "showcategory.jsp";
	}
	
	@PostMapping("/category/add/product/{id}")
	public String productAdded(@PathVariable("id") Long id,
			@RequestParam(value="productsId") Long productsId) {
		Product p = productServ.singleProduct(productsId);
		Category c = categoryServ.singleCategory(id);
		productServ.addCategory(p, c);
		return "redirect:/category/add/product/" + id;
	}
}
