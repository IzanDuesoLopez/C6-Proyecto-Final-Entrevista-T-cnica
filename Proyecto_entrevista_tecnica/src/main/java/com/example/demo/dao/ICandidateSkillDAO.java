package com.example.demo.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.dto.CandidateSkill;

public interface ICandidateSkillDAO extends JpaRepository<CandidateSkill, Integer>{
	
}
