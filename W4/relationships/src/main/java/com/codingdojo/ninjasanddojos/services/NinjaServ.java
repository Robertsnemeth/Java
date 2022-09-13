package com.codingdojo.ninjasanddojos.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.codingdojo.ninjasanddojos.models.DojoClass;
import com.codingdojo.ninjasanddojos.models.Ninja;
import com.codingdojo.ninjasanddojos.repositories.NinjaRepo;

@Service
public class NinjaServ {
	private NinjaRepo ninjaRepo;
	
	public NinjaServ(NinjaRepo ninjaRepo) {
		this.ninjaRepo = ninjaRepo;
	}
	
	public List<Ninja> allNinjas() {
		return ninjaRepo.findAll();
		
	}
	
	public Ninja createNinja(Ninja n) {
		return ninjaRepo.save(n);
	}
	
	public Ninja singleNinja(Long id) {
        Optional<Ninja> optionalNinja = ninjaRepo.findById(id);
        if(optionalNinja.isPresent()) {
            return optionalNinja.get();
        } else {
            return null;
        }
	}
	
	public List<Ninja> dojoNinjas(Long id) {
		return ninjaRepo.findAllByDojoId(id);
	}
	
    public void deleteNinja(Long id) {
    	Optional<Ninja> optionalLook = ninjaRepo.findById(id);
    	if(optionalLook.isPresent()) {
    		ninjaRepo.deleteById(id);
    	} else {
    		return;
    	}
    }
    
    
}
