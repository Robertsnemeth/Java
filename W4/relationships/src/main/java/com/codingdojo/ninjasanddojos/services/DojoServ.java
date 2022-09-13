package com.codingdojo.ninjasanddojos.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.codingdojo.ninjasanddojos.models.Dojo;
import com.codingdojo.ninjasanddojos.repositories.DojoRepo;

@Service
public class DojoServ {
	private DojoRepo dojoRepo;
	
	public DojoServ(DojoRepo dojoRepo) {
		this.dojoRepo = dojoRepo;
	}
	
	public List<Dojo> allDojos() {
		return dojoRepo.findAll();
		
	}
	
	public Dojo createDojo(Dojo d) {
		return dojoRepo.save(d);
	}
	
	public Dojo singleDojo(Long id) {
        Optional<Dojo> optionalDojo = dojoRepo.findById(id);
        if(optionalDojo.isPresent()) {
            return optionalDojo.get();
        } else {
            return null;
        }
	}
	
    public void deleteDojo(Long id) {
    	Optional<Dojo> optionalLook = dojoRepo.findById(id);
    	if(optionalLook.isPresent()) {
    		dojoRepo.deleteById(id);
    	} else {
    		return;
    	}
    }
}
