package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.ISkillDAO;
import com.example.demo.dto.Skill;

@Service
public class SkillServiceImpl implements ISkillService{

	@Autowired
	ISkillDAO iSkillDAO;
	
	@Override
	public List<Skill> listarSkills() {
		return iSkillDAO.findAll();
	}

	@Override
	public Skill guardarSkill(Skill skills) {
		return iSkillDAO.save(skills);
	}

	@Override
	public Skill skillsXID(int id) {
		return iSkillDAO.findById(id).get();
	}

	@Override
	public Skill actualizarSkills(Skill skills) {
		return iSkillDAO.save(skills);
	}

	@Override
	public void eliminarSkills(int id) {
		iSkillDAO.deleteById(id);
	}

}
