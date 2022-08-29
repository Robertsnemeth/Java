package com.codingdojo.safetravels.services;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.codingdojo.safetravels.models.Travels;
import com.codingdojo.safetravels.repositories.TravelsRepository;

@Service
public class TravelsServices {
	private final TravelsRepository travelsRepository;
	
	public TravelsServices(TravelsRepository travelsRepository) {
		this.travelsRepository = travelsRepository;
	}
	
    // returns all the travel expenses
    public ArrayList<Travels> allTravels() {
        return travelsRepository.findAll();
    }
    // creates a travel expense
    public Travels createTravels(Travels b) {
        return travelsRepository.save(b);
    }
    // retrieves a travel expense
    public Travels findTravels(Long id) {
        Optional<Travels> optionalBook = travelsRepository.findById(id);
        if(optionalBook.isPresent()) {
            return optionalBook.get();
        } else {
            return null;
        }
    }
    // deletes a travel expense
    public void deleteTravels(Long id) {
    	Optional<Travels> optionalTravel = travelsRepository.findById(id);
    	if(optionalTravel.isPresent()) {
    		travelsRepository.deleteById(id);
    	} else {
    		return;
    	}
    }
}
