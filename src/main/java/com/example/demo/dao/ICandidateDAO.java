package com.example.demo.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.security.core.userdetails.User;

import com.example.demo.dto.Candidate;

public interface ICandidateDAO extends JpaRepository<Candidate, Integer>{

	public List<Candidate> findByName(String name);
	public Candidate findByUsername(String username);
	
	@Query("SELECT c FROM Candidate c WHERE c.username = :username")
    public User getUserByUsername(@Param("username") String username);
}
