package com.codingdojo.ninjasanddojos.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.codingdojo.ninjasanddojos.models.Ninja;

@Repository
public interface NinjaRepo extends CrudRepository<Ninja, Long> {
	
	List<Ninja> findAll();

	List<Ninja> findAllByDojoId(Long id);

}
