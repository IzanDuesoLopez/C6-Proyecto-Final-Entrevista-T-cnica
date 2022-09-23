package com.example.demo.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.dto.Skill;

public interface ISkillDAO extends JpaRepository<Skill, Integer>{

	public List<Skill> findByName(String name);
	
}
