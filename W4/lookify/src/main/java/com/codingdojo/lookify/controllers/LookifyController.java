package com.codingdojo.lookify.controllers;

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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.codingdojo.lookify.models.Lookify;
import com.codingdojo.lookify.services.LookifyServices;

@Controller
public class LookifyController {

	@Autowired
	LookifyServices service;
	
	@GetMapping("/")
	public String index() {
		return "index.jsp";
	}
	
	@GetMapping("/lookify/dash")
	public String dash(Model model) {
		ArrayList<Lookify> looks = service.allLook();
		model.addAttribute("looks", looks);
		return "dash.jsp";
	}
	
	@PostMapping("/lookify/dash")
	public String dash(@RequestParam("artist") String artist,
			Model model) {
		model.addAttribute("artist", artist);
		if(artist == null) {
			return null;
		} else {
			return "redirect:/lookify/search/" + artist;
		}
	}
	
	@GetMapping("/lookify/show/{id}")
	public String show(@PathVariable("id") Long id, Model model) {
		Lookify song = service.findLook(id);
		model.addAttribute("song", song);
		return "show.jsp";
	}
	
	@GetMapping("/lookify/search/{artist}")
	public String search(@PathVariable("artist") String artist,
			Model model
			) {
		ArrayList<Lookify> songs = service.findArtist(artist);
		model.addAttribute("songs", songs);
		model.addAttribute("artist", artist);
		return "search.jsp";
	}
	
	@GetMapping("/lookify/topTen")
	public String topTen(Model model) {
		ArrayList<Lookify> topSongs = service.topRatings();
		model.addAttribute("topSongs", topSongs);
		return "topTen.jsp";
	}
	
	@RequestMapping("/lookify/new")
	public String newSong(@ModelAttribute("songs") Lookify songs) {
		return "add.jsp";
	}
	
	@PostMapping("/lookify/add")
	public String addSong(
			@Valid @ModelAttribute("songs") Lookify songs,
			BindingResult result
			) {
		if(result.hasErrors()) {
			return "add.jsp";
		} else {
			service.createLook(songs);
			return "redirect:/lookify/dash";
		}
	}
	
	
	@DeleteMapping("/lookify/delete/{id}")
	public String delete(@PathVariable("id") Long id) {
		service.deleteLook(id);
		return "redirect:/lookify/dash";
	}
	
	
	
}
