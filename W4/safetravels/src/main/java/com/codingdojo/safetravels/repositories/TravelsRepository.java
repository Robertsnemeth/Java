package com.codingdojo.safetravels.repositories;

import java.util.ArrayList;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.codingdojo.safetravels.models.Travels;

@Repository
public interface TravelsRepository extends CrudRepository<Travels, Long> {

	ArrayList<Travels> findAll();
}
