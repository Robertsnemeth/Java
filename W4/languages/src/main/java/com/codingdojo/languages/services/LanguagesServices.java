package com.codingdojo.languages.services;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.codingdojo.languages.models.Languages;
import com.codingdojo.languages.repositories.LanguagesRepository;

@Service
public class LanguagesServices {
	private final LanguagesRepository langRepository;
	
	public LanguagesServices(LanguagesRepository langRepository) {
		this.langRepository = langRepository;
	}
	
    // returns all the travel expenses
    public ArrayList<Languages> allLangs() {
        return langRepository.findAll();
    }
    // creates a language
    public Languages createLang(Languages l) {
        return langRepository.save(l);
    }
    // retrieves a language
    public Languages findLang(Long id) {
        Optional<Languages> optionalLang = langRepository.findById(id);
        if(optionalLang.isPresent()) {
            return optionalLang.get();
        } else {
            return null;
        }
    }
    // deletes a language
    public void deleteLang(Long id) {
    	Optional<Languages> optionalLang = langRepository.findById(id);
    	if(optionalLang.isPresent()) {
    		langRepository.deleteById(id);
    	} else {
    		return;
    	}
    }
}
