package com.example.demo.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.dto.Skill;

public interface ISkillDAO extends JpaRepository<Skill, Integer>{

	/**
	 * Searchs by the name field and returns a list of skills
	 * @param name
	 * @return
	 */
	public List<Skill> findByName(String name);
	
}
