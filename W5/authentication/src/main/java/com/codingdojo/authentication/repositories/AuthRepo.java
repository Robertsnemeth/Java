package com.codingdojo.authentication.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.codingdojo.authentication.models.User;


@Repository
public interface AuthRepo extends CrudRepository<User, Long> {

	List<User> findAll();
	
	Optional<User> findByEmail(String email);
}
