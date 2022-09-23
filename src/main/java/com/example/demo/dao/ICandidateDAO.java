package com.example.demo.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.security.core.userdetails.User;

import com.example.demo.dto.Candidate;

public interface ICandidateDAO extends JpaRepository<Candidate, Integer>{

	/**
	 * Searchs by the name field and returns a list of candidates
	 * @param name
	 * @return
	 */
	public List<Candidate> findByName(String name);
	
	/**
	 * Search a candidate by the username field and returns its data
	 * @param username
	 * @return
	 */
	public Candidate findByUsername(String username);
}
