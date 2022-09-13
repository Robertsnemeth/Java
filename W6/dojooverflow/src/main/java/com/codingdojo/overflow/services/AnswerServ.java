package com.codingdojo.overflow.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.codingdojo.overflow.models.Answer;
import com.codingdojo.overflow.repositories.AnswerRepo;

@Service
public class AnswerServ {
	
	@Autowired AnswerRepo answerRepo;
		
	public Answer createAnswer(Answer a) {
		return answerRepo.save(a);
	}
}
