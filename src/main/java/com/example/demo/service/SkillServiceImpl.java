package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.ISkillDAO;
import com.example.demo.dto.Skill;

@Service
public class SkillServiceImpl implements ISkillService{

	/**
	 * Variables autowired
	 */
	@Autowired
	ISkillDAO iSkillDAO;
	
	/**
	 * Get all
	 */
	@Override
	public List<Skill> listarSkills() {
		return iSkillDAO.findAll();
	}

	/**
	 * Create
	 */
	@Override
	public Skill guardarSkill(Skill skills) {
		return iSkillDAO.save(skills);
	}

	/**
	 * Finds by id
	 */
	@Override
	public Skill skillsXID(int id) {
		return iSkillDAO.findById(id).get();
	}

	/**
	 * Update
	 */
	@Override
	public Skill actualizarSkills(Skill skills) {
		return iSkillDAO.save(skills);
	}

	/**
	 * Delete
	 */
	@Override
	public void eliminarSkills(int id) {
		iSkillDAO.deleteById(id);
	}

	/**
	 * Finds by name
	 */
	@Override
	public List<Skill> findByName(String name) {
		return iSkillDAO.findByName(name);
	}

}
