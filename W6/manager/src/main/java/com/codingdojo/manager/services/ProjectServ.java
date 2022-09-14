package com.codingdojo.manager.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.codingdojo.manager.models.Project;
import com.codingdojo.manager.models.User;
import com.codingdojo.manager.models.repositories.ProjectRepo;

@Service
public class ProjectServ {

	@Autowired ProjectRepo projectRepo;
	
	public Project createProject(Project p) {
		return projectRepo.save(p);
	}
	
	public List<Project> allProjects(){
		return projectRepo.findAll();
	}
	
	public Project singleProject(Long id) {
		Optional<Project> project = projectRepo.findById(id);
		if(project.isPresent()) {
			return project.get();
		}
		return null;
	}
	
	public List<Project> unassigned(User u) {
		return projectRepo.findByUsersNotContains(u);
	}
	
	public Project updateProject(Project p) {
		return projectRepo.save(p);
	}
	
	public void joinProject(Project p, User u) {
		p.getUsers().add(u);
		projectRepo.save(p);
	}
	
	public void deleteProject(Long id) {
		Optional<Project> project = projectRepo.findById(id);
		if(project.isPresent()) {
			projectRepo.deleteById(id);;
		}
		return;
	}
	
	
}
