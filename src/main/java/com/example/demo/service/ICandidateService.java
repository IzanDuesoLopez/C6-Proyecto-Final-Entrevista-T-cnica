package com.example.demo.service;

import java.util.List;

import com.example.demo.dto.Candidate;

public interface ICandidateService {
	
	//Metodos del CRUD
	public List<Candidate> listarCandidates(); // Listar All 
	
	public Candidate guardarCandidate(Candidate candidates);	// CREATE
	
	public Candidate candidatesXID(int id); // READ
	
	public Candidate actualizarCandidates(Candidate candidates); // UPDATE
	
	public void eliminarCandidates(int id); // DELETE
	
	public List<Candidate> findByName(String name); // Find by name
	
	public Candidate findByUsername(String username); // Find by username
}
