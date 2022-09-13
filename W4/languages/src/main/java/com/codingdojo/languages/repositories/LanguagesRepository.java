package com.codingdojo.languages.repositories;

import java.util.ArrayList;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.codingdojo.languages.models.Languages;

@Repository
public interface LanguagesRepository extends CrudRepository<Languages, Long> {

	ArrayList<Languages> findAll();
}
