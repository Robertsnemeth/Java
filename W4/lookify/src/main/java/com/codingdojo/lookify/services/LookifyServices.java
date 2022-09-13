package com.codingdojo.lookify.services;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.codingdojo.lookify.models.Lookify;
import com.codingdojo.lookify.repositories.LookifyRepo;

@Service
public class LookifyServices {
	private final LookifyRepo lookifyRepo;
	
	public LookifyServices(LookifyRepo lookifyRepo) {
		this.lookifyRepo = lookifyRepo;
	}
	
    // returns all the songs
    public ArrayList<Lookify> allLook() {
        return lookifyRepo.findAll();
    }
    
    // returns all songs by id
    public ArrayList<Lookify> allSongs(Long id) {
        return lookifyRepo.findAllById(id);
    }
    
    // returns top 10 songs
    public ArrayList<Lookify> topRatings() {
    	ArrayList<Lookify> topTen = lookifyRepo.topTen();
        return topTen;
    }
    // returns searched song
    public ArrayList<Lookify> findSong(String song) {
    	ArrayList<Lookify> songs = lookifyRepo.findByTitleContaining(song);
        return songs;
    }
    // returns searched artist
    public ArrayList<Lookify> findArtist(String artist) {
    	ArrayList<Lookify> songs = lookifyRepo.findByArtistContaining(artist);
        return songs;
    }
    // creates a song
    public Lookify createLook(Lookify l) {
        return lookifyRepo.save(l);
    }
    // retrieves a song
    public Lookify findLook(Long id) {
        Optional<Lookify> optionalLook = lookifyRepo.findById(id);
        if(optionalLook.isPresent()) {
            return optionalLook.get();
        } else {
            return null;
        }
    }
    // deletes a song
    public void deleteLook(Long id) {
    	Optional<Lookify> optionalLook = lookifyRepo.findById(id);
    	if(optionalLook.isPresent()) {
    		lookifyRepo.deleteById(id);
    	} else {
    		return;
    	}
    }


}
