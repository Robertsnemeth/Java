package com.codingdojo.ninjasanddojos.controllers;

import java.util.List;

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

import com.codingdojo.ninjasanddojos.models.Dojo;
import com.codingdojo.ninjasanddojos.models.DojoClass;
import com.codingdojo.ninjasanddojos.models.Ninja;
import com.codingdojo.ninjasanddojos.services.ClassServ;
import com.codingdojo.ninjasanddojos.services.DojoServ;
import com.codingdojo.ninjasanddojos.services.NinjaServ;

@Controller
public class RelationshipsController {

	@Autowired DojoServ dojoServ;
	@Autowired NinjaServ ninjaServ;
	@Autowired ClassServ classServ;
	
	@GetMapping("/")
	public String index(@ModelAttribute("dojo") Dojo dojo,
			Model model) {
		List<Dojo> dojos = dojoServ.allDojos();
		model.addAttribute("dojos", dojos);
		return "index.jsp";
	}
	
	@PostMapping("/")
	public String create(@Valid @ModelAttribute("dojo") Dojo dojo,
			BindingResult result,
			Model model) {
		if(result.hasErrors()) {
			List<Dojo> dojos = dojoServ.allDojos();
			model.addAttribute("dojos", dojos);
			return "index.jsp";
		} 
		dojoServ.createDojo(dojo);
		return "redirect:/";
	}
	
	@GetMapping("/dojo/new/ninja")
	public String newNinja(@ModelAttribute("ninja") Ninja ninja,
			Model model) {
		List<Dojo> dojos = dojoServ.allDojos();
		model.addAttribute("dojos", dojos);
		return "ninja.jsp";
	}
	
	@PostMapping("/dojo/new/ninja")
	public String addNinja(@Valid @ModelAttribute("ninja") Ninja ninja,
			BindingResult result,
			Model model) {
		if(result.hasErrors()) {
			List<Dojo> dojos = dojoServ.allDojos();
			model.addAttribute("dojos", dojos);
			return "ninja.jsp";
		}
		ninjaServ.createNinja(ninja);
		return "redirect:/";
	}
	
	@GetMapping("/dojo/ninjas/{id}")
	public String dojoNinjas(
			@PathVariable("id") Long id,
			Model model) {
		List<Ninja> ninjas = ninjaServ.dojoNinjas(id);
		Dojo theDojo = dojoServ.singleDojo(id);
		model.addAttribute("dojo", theDojo);
		model.addAttribute("ninjas", ninjas);
		return "dojo.jsp";
	}
	
	@DeleteMapping("/dojo/delete/{id}")
	public String deleteDojo(@PathVariable("id") Long id) {
		dojoServ.deleteDojo(id);
		return "redirect:/";
	}
	
	@GetMapping("/dojo/new/class")
	public String newClass(@ModelAttribute("class") DojoClass c) {
		return "addClass.jsp";
	}
	
	@PostMapping("/dojo/new/class") 
	public String addClass(
			@Valid @ModelAttribute("class") DojoClass c,
			BindingResult result) {
		if(result.hasErrors()) {
			return "addClass.jsp";
		}
		classServ.addClass(c);
		return "redirect:/all/class";
	}
	
	@GetMapping("/all/class")
	public String allClasses(Model model) {
		List<DojoClass> classes = classServ.allClasses();
		model.addAttribute("classes", classes);
		return "classes.jsp";
	}
	
	@GetMapping("/class/{id}")
	public String showClass(@PathVariable("id") Long id,
			Model model) {
		model.addAttribute("c", classServ.singleClass(id));
		return "showClass.jsp";
	}
	
	@GetMapping("/student/{id}")
	public String showStudent(@PathVariable("id") Long id,
			Model model) {
		model.addAttribute("student", ninjaServ.singleNinja(id));
		model.addAttribute("classes", classServ.allClasses());
		return "showStudent.jsp";
	}
	
	@PostMapping("/student/add/class/{id}")
	public String studentClass(@RequestParam(name="c") Long c,
			@PathVariable("id") Long id) {
		Ninja ninja = ninjaServ.singleNinja(id);
		DojoClass aClass = classServ.singleClass(c);
		ninja.getClasses().add(aClass);
		ninjaServ.createNinja(ninja);
		return "redirect:/student/{id}";
		
	}
	
	@RequestMapping("/student/drop/{id}")
	public String dropClass(@PathVariable("id") Long studentId,
			@RequestParam(name="classId") Long classId) {
		Ninja ninja = ninjaServ.singleNinja(studentId);
		ninja.getClasses().remove(classServ.singleClass(classId));
		ninjaServ.createNinja(ninja);
		return "redirect:/student/{id}";
	}
	
	
}
