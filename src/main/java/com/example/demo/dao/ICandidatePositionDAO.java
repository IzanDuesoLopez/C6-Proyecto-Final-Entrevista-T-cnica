package com.example.demo.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.dto.Candidate_position;

public interface ICandidatePositionDAO extends JpaRepository<Candidate_position, Integer>{
	
}
