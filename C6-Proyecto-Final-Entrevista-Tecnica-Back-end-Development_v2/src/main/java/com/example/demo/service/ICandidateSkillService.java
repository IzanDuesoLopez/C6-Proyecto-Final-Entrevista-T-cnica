package com.example.demo.service;

import java.util.List;

import com.example.demo.dto.Candidate_skill;

public interface ICandidateSkillService {

	//Metodos del CRUD
	public List<Candidate_skill> listarCandidateSkills(); // Listar All 
	
	public Candidate_skill guardarCandidateSkill(Candidate_skill candidateSkills);	// CREATE
	
	public Candidate_skill candidateSkillsXID(int id); // READ
	
	public Candidate_skill actualizarCandidateSkills(Candidate_skill candidateSkills); // UPDATE
	
	public void eliminarCandidateSkills(int id); // DELETE
}
