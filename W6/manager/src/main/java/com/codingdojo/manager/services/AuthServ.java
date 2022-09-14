package com.codingdojo.manager.services;

import java.util.Optional;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;

import com.codingdojo.manager.models.LoginUser;
import com.codingdojo.manager.models.User;
import com.codingdojo.manager.models.repositories.AuthRepo;

@Service
public class AuthServ {
	private AuthRepo authRepo;
	
	AuthServ(AuthRepo authRepo) {
		this.authRepo = authRepo;
	}
//	=====REGISTER USER=====
	public User createUser(User u, BindingResult result) {
		u.setPassword(BCrypt.hashpw(u.getPassword(), BCrypt.gensalt()));
		return authRepo.save(u);
	}
//	=====LOGIN USER=====
	public User login(LoginUser u, BindingResult result) {
		Optional<User> user = authRepo.findByEmail(u.getEmail());
		User newUser = user.get();
		return newUser;
	}
//	=====RETRIEVE SINGLE USER=====
	public User singleUser(Long id) {
		Optional<User> user = authRepo.findById(id);
		if(user.isPresent()) {
			return user.get();
		} else {
			return null;
		}
	}
	
//	=====VALIDATIONS=====
	public void registerValidations(User u, BindingResult result) {
		Optional<User> user = authRepo.findByEmail(u.getEmail());
		if(user.isPresent()) {
			result.rejectValue("email", "Matches", "Email is already taken");
		}
		if(!u.getPassword().equals(u.getConfirm())) {
			result.rejectValue("confirm", "Matches", "Passwords do not match");
		}	
	}
	
	public void loginValidations(LoginUser u, BindingResult result) {
		Optional<User> user = authRepo.findByEmail(u.getEmail());
		if(user.isEmpty()) {
			result.rejectValue("email", "Matches", "User does not exist");		
		}
		if(user.isPresent()) {
			User newUser = user.get();
			if(!BCrypt.checkpw(u.getPassword(), newUser.getPassword())) {
				u.setPassword(BCrypt.hashpw(u.getPassword(), BCrypt.gensalt()));
				result.rejectValue("password", "Matches", "Passwords do not match");
			}
		}
	}
	
	public User updateUser(User u) {
		return authRepo.save(u);
	}

}
		