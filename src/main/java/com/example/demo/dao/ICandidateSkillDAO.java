package com.example.demo.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.dto.Candidate_skill;

public interface ICandidateSkillDAO extends JpaRepository<Candidate_skill, Integer>{
	
}
