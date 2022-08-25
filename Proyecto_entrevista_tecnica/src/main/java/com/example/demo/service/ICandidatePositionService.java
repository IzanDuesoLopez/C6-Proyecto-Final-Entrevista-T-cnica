package com.example.demo.service;

import java.util.List;

import com.example.demo.dto.CandidatePosition;

public interface ICandidatePositionService {

	//Metodos del CRUD
	public List<CandidatePosition> listarCandidatePositions(); // Listar All 
	
	public CandidatePosition guardarCandidatePosition(CandidatePosition candidatePositions);	// CREATE
	
	public CandidatePosition candidatePositionsXID(int id); // READ
	
	public CandidatePosition actualizarCandidatePositions(CandidatePosition candidatePositions); // UPDATE
	
	public void eliminarCandidatePositions(int id); // DELETE
}
