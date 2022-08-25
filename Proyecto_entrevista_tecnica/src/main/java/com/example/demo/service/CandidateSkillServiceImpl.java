package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.ICandidateSkillDAO;
import com.example.demo.dto.Candidate_skill;

@Service
public class CandidateSkillServiceImpl implements ICandidateSkillService{

	@Autowired
	ICandidateSkillDAO iCandidateSkillDAO;
	
	@Override
	public List<Candidate_skill> listarCandidateSkills() {
		return iCandidateSkillDAO.findAll();
	}

	@Override
	public Candidate_skill guardarCandidateSkill(Candidate_skill candidateSkills) {
		return iCandidateSkillDAO.save(candidateSkills);
	}

	@Override
	public Candidate_skill candidateSkillsXID(int id) {
		return iCandidateSkillDAO.findById(id).get();
	}

	@Override
	public Candidate_skill actualizarCandidateSkills(Candidate_skill candidateSkills) {
		return iCandidateSkillDAO.save(candidateSkills);
	}

	@Override
	public void eliminarCandidateSkills(int id) {
		iCandidateSkillDAO.deleteById(id);
	}

}
