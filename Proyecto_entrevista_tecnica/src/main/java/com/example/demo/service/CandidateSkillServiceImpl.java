package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.ICandidateSkillDAO;
import com.example.demo.dto.CandidateSkill;

@Service
public class CandidateSkillServiceImpl implements ICandidateSkillService{

	@Autowired
	ICandidateSkillDAO iCandidateSkillDAO;
	
	@Override
	public List<CandidateSkill> listarCandidateSkills() {
		return iCandidateSkillDAO.findAll();
	}

	@Override
	public CandidateSkill guardarCandidateSkill(CandidateSkill candidateSkills) {
		return iCandidateSkillDAO.save(candidateSkills);
	}

	@Override
	public CandidateSkill candidateSkillsXID(int id) {
		return iCandidateSkillDAO.findById(id).get();
	}

	@Override
	public CandidateSkill actualizarCandidateSkills(CandidateSkill candidateSkills) {
		return iCandidateSkillDAO.save(candidateSkills);
	}

	@Override
	public void eliminarCandidateSkills(int id) {
		iCandidateSkillDAO.deleteById(id);
	}

}
