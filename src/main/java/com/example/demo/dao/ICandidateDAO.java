package com.example.demo.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.dto.Candidate;

public interface ICandidateDAO extends JpaRepository<Candidate, Integer>{

	public List<Candidate> findByName(String name);
	
}
