package com.codingdojo.bookclub.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.codingdojo.bookclub.models.Product;

@Repository
public interface ProductRepo extends CrudRepository<Product, Long>{

	List<Product> findAll();
}
