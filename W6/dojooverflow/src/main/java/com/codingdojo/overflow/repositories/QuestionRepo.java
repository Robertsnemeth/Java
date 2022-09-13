package com.codingdojo.overflow.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.codingdojo.overflow.models.Question;

@Repository
public interface QuestionRepo extends CrudRepository<Question, Long>{

	List<Question> findAll();
}
