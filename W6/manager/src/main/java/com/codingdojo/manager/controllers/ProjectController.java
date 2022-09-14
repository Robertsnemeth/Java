package com.codingdojo.manager.controllers;

import javax.servlet.http.HttpSession;
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
import org.springframework.web.bind.annotation.RequestParam;

import com.codingdojo.manager.models.Project;
import com.codingdojo.manager.models.User;
import com.codingdojo.manager.services.AuthServ;
import com.codingdojo.manager.services.ProjectServ;
import com.codingdojo.manager.services.TicketServ;

@Controller
public class ProjectController {

	@Autowired AuthServ authServ;
	@Autowired ProjectServ projectServ;
	@Autowired TicketServ ticketServ;
	
	@GetMapping("/project/new")
	public String newProject(@ModelAttribute("project") Project p,
			HttpSession session,
			Model model) {
		model.addAttribute("userId", session.getAttribute("userId"));
		return "project.jsp";
	}
	
	@PostMapping("/project/new")
	public String addProject(@Valid @ModelAttribute("project") Project p,
			BindingResult result,
			HttpSession session,
			Model model) {
		if(result.hasErrors()) {
			model.addAttribute("userId", session.getAttribute("userId"));
			return "project.jsp";
		}
		Project project = projectServ.createProject(p);
		Long userId = (Long) session.getAttribute("userId");
		User user = authServ.singleUser(userId);
		user.getProjects().add(project);
		authServ.updateUser(user);
		return "redirect:/dashboard";
	}
	
	@GetMapping("/project/show/{id}")
	public String showProject(@PathVariable("id") Long id,
			Model model,
			HttpSession session) {
		model.addAttribute("project", projectServ.singleProject(id));
		return "show.jsp";
	}
	
	@GetMapping("/project/edit/{id}")
	public String editProject(@ModelAttribute("project") Project p,
			Model model,
			HttpSession session,
			@PathVariable("id") Long id) {
		model.addAttribute("p", projectServ.singleProject(id));
		return "edit.jsp";
	}
	
	@PutMapping("/project/edit/{id}")
	public String updateProject(@Valid @ModelAttribute("project") Project p,
			BindingResult result,
			Model model,
			HttpSession Session,
			@PathVariable("id") Long id) {
		if(result.hasErrors()) {
			model.addAttribute("p", projectServ.singleProject(id));
			return "edit.jsp";
		}
		projectServ.updateProject(p);
		return "redirect:/project/show/{id}";
	}
	
	@PostMapping("/project/join/{id}")
	public String joinProject(@PathVariable("id") Long id,
			@RequestParam(name="projectId") Long projectId) {
		User user = authServ.singleUser(id);
		Project project = projectServ.singleProject(projectId);
		projectServ.joinProject(project, user);
		return "redirect:/dashboard";
	}
	
	@RequestMapping("/project/leave/{id}")
	public String leaveProject(@PathVariable("id") Long id,
			@RequestParam(name="projectId") Long projectId) {
		User user = authServ.singleUser(id);
		user.getProjects().remove(projectServ.singleProject(projectId));
		authServ.updateUser(user);
		return "redirect:/dashboard";
	}
	
	@DeleteMapping("/project/delete/{id}")
	public String deleteProject(@PathVariable("id") Long id) {
		projectServ.deleteProject(id);
		return "redirect:/dashboard";
	}
}
