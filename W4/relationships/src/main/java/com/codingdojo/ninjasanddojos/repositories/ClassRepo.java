package com.codingdojo.ninjasanddojos.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.codingdojo.ninjasanddojos.models.DojoClass;

@Repository
public interface ClassRepo extends CrudRepository<DojoClass, Long> {
	
	List<DojoClass> findAll();
}
