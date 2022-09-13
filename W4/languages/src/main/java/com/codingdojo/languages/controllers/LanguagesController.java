package com.codingdojo.languages.controllers;

import java.util.ArrayList;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.codingdojo.languages.models.Languages;
import com.codingdojo.languages.services.LanguagesServices;

@Controller
public class LanguagesController {
	
	@Autowired
	LanguagesServices langServices;
	
	@RequestMapping("/")
	public String index() {
		return "redirect:/languages";
	}
	
	@RequestMapping("/languages")
	public String languages(
			@ModelAttribute("language") Languages language, 
			Model model) {
		ArrayList<Languages> languages = langServices.allLangs();
		model.addAttribute("languages", languages);
		return "index.jsp";
	}
	
	@PostMapping("/languages/add")
	public String create(
			@Valid @ModelAttribute("language") Languages language,
			BindingResult result,
			Model model
			) {
		if(result.hasErrors()) {
			ArrayList<Languages> languages = langServices.allLangs();
			model.addAttribute("languages", languages);
			return "index.jsp";
		}
		langServices.createLang(language);
		return "redirect:/languages";
	}
	
	@GetMapping("/languages/edit/{id}")
	public String editLang(
			@ModelAttribute("languages") Languages languages,
			Model model,
			@PathVariable("id") Long id) {
		Languages language = langServices.findLang(id);
		model.addAttribute("language", language);
		return "edit.jsp";
	}
	
	@PostMapping("/languages/updated/{id}")
	public String updatedLang(
			@ Valid @ModelAttribute("languages") Languages languages,
			BindingResult result,
			Model model,
			@PathVariable("id") Long id) {
		
		if(result.hasErrors()) {
			Languages language = langServices.findLang(id);
			model.addAttribute("language", language);
			return "edit.jsp";
		}
		langServices.createLang(languages);
		return "redirect:/languages";

	}
	
	@GetMapping("/languages/{id}")
	public String showLang(
			@PathVariable("id") Long id,
			Model model) {
		Languages language = langServices.findLang(id);
		model.addAttribute("language", language);
		return "show.jsp";
	}
	
	@DeleteMapping("/languages/delete/{id}")
	public String delete(@PathVariable("id") Long id) {
		langServices.deleteLang(id);
		return "redirect:/languages";
	}
	
}
