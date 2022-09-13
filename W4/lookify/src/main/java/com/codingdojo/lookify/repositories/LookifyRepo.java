package com.codingdojo.lookify.repositories;

import java.util.ArrayList;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.codingdojo.lookify.models.Lookify;

@Repository
public interface LookifyRepo extends CrudRepository<Lookify, Long> {

	ArrayList<Lookify> findAll();
	ArrayList<Lookify> findAllById(Long id);
	
	ArrayList<Lookify> findByTitleContaining(String title);
	ArrayList<Lookify> findByArtistContaining(String artist);
	
	@Query(value= "SELECT * FROM travels.lookify ORDER BY rating DESC LIMIT 10;", nativeQuery = true)
	ArrayList<Lookify> topTen();

}
