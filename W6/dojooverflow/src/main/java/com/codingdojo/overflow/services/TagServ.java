package com.codingdojo.overflow.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.codingdojo.overflow.models.Tag;
import com.codingdojo.overflow.repositories.TagRepo;

@Service
public class TagServ {
	
	@Autowired TagRepo tagRepo;
	
	public Tag createTag(Tag t) {
		return tagRepo.save(t);
	}

	public List<Tag> allTags() {
		return tagRepo.findAll();
	}
}
