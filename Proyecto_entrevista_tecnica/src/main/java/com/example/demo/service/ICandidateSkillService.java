package com.example.demo.service;

import java.util.List;

import com.example.demo.dto.CandidateSkill;

public interface ICandidateSkillService {

	//Metodos del CRUD
	public List<CandidateSkill> listarCandidateSkills(); // Listar All 
	
	public CandidateSkill guardarCandidateSkill(CandidateSkill candidateSkills);	// CREATE
	
	public CandidateSkill candidateSkillsXID(int id); // READ
	
	public CandidateSkill actualizarCandidateSkills(CandidateSkill candidateSkills); // UPDATE
	
	public void eliminarCandidateSkills(int id); // DELETE
}
