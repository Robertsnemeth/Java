package com.codingdojo.overflow.controllers;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.codingdojo.overflow.models.Answer;
import com.codingdojo.overflow.models.Question;
import com.codingdojo.overflow.models.Tag;
import com.codingdojo.overflow.services.AnswerServ;
import com.codingdojo.overflow.services.QuestionServ;
import com.codingdojo.overflow.services.TagServ;

@Controller
public class HomeController {
	
	@Autowired QuestionServ questionServ;
	
	@Autowired TagServ tagServ;
	
	@Autowired AnswerServ answerServ;
	
	@GetMapping("/")
	public String index(Model model) {
		model.addAttribute("questions", questionServ.allQuestions());
		return "index.jsp";
	}
	
//	==========QUESTION ROUTES==========
	@GetMapping("/question/new")
	public String newQuestion(Model model) {
		return "question.jsp";
	}
	
	@PostMapping("/question/new")
	public String addQuestion(@RequestParam(value="question") String q,
			@RequestParam(value="tag") String t,
			Model model) {
		Question question = new Question(q);
		Tag tag = new Tag(t);	
		Question newQ = questionServ.createQuestion(question);
		Tag newT = tagServ.createTag(tag);
		List<Tag> tagList = new ArrayList<Tag>();
		tagList.add(newT);
		newQ.setTags(tagList);
		questionServ.createQuestion(newQ);
		tagServ.createTag(newT);
		
		return "redirect:/";
	}
	
//	==========ANSWER ROUTES==========
	@GetMapping("/answer/new/{id}")
	public String newAnswer(@PathVariable("id") Long id,
			@ModelAttribute("answers") Answer a,
			Model model) {
		model.addAttribute("question", questionServ.singleQuestion(id));
		return "answer.jsp";
	}
	
	@PostMapping("/answer/new/{id}")
	public String addAnswer(
			@Valid @ModelAttribute("answers") Answer a,
			BindingResult result,
			@PathVariable("id") Long id,
			Model model) {
		if(result.hasErrors()) {
			model.addAttribute("question", questionServ.singleQuestion(id));
			return "answer.jsp";
		}
		answerServ.createAnswer(a);
		return "redirect:/";
	}
	

}
