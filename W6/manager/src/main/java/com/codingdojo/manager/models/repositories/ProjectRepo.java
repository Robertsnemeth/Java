package com.codingdojo.manager.models.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.codingdojo.manager.models.Project;
import com.codingdojo.manager.models.User;

@Repository
public interface ProjectRepo extends CrudRepository<Project, Long> {

	public List<Project> findAll();
	
	public List<Project> findByUsersNotContains(User user);
}
