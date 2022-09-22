package com.example.demo.service;

import java.util.List;

import com.example.demo.dto.Candidate_position;

public interface ICandidatePositionService {

	//Metodos del CRUD
	public List<Candidate_position> listarCandidatePositions(); // Listar All 
	
	public Candidate_position guardarCandidatePosition(Candidate_position candidatePositions);	// CREATE
	
	public Candidate_position candidatePositionsXID(int id); // READ
	
	public Candidate_position actualizarCandidatePositions(Candidate_position candidatePositions); // UPDATE
	
	public void eliminarCandidatePositions(int id); // DELETE
}
