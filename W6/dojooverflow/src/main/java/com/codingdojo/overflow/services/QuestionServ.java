package com.codingdojo.overflow.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.codingdojo.overflow.models.Question;
import com.codingdojo.overflow.repositories.QuestionRepo;

@Service
public class QuestionServ {
	
	@Autowired QuestionRepo questionRepo;
	
	public Question createQuestion(Question q) {
		return questionRepo.save(q);
	}

	public List<Question> allQuestions() {
		return questionRepo.findAll();
	}
	
	public Question singleQuestion(Long id) {
		Optional<Question> question = questionRepo.findById(id);
		if(question.isPresent()) {
			return question.get();
		}
		return null;
	}
}
