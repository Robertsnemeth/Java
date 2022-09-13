package com.codingdojo.ninjasanddojos.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.codingdojo.ninjasanddojos.models.DojoClass;
import com.codingdojo.ninjasanddojos.repositories.ClassRepo;

@Service
public class ClassServ {

	@Autowired ClassRepo classRepo;
	
	public DojoClass addClass(DojoClass c) {
		return classRepo.save(c);
	}
	
	public List<DojoClass> allClasses() {
		return classRepo.findAll();
	}
	
	public DojoClass singleClass(Long id) {
		Optional<DojoClass> aClass = classRepo.findById(id);
		if(aClass.isPresent()) {
			return aClass.get();
		}
		return null;
	}
	
	
}
