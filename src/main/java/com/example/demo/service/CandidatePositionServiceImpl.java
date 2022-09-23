package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.ICandidatePositionDAO;
import com.example.demo.dto.Candidate_position;

@Service
public class CandidatePositionServiceImpl implements ICandidatePositionService{

	/**
	 * Variables autowired
	 */
	@Autowired
	ICandidatePositionDAO iCandidatePositionDAO;
	
	/**
	 * Get all
	 */
	@Override
	public List<Candidate_position> listarCandidatePositions() {
		return iCandidatePositionDAO.findAll();
	}

	/**
	 * Create
	 */
	@Override
	public Candidate_position guardarCandidatePosition(Candidate_position candidatePositions) {
		return iCandidatePositionDAO.save(candidatePositions);
	}

	/**
	 * Get by id
	 */
	@Override
	public Candidate_position candidatePositionsXID(int id) {
		return iCandidatePositionDAO.findById(id).get();
	}

	/**
	 * Update
	 */
	@Override
	public Candidate_position actualizarCandidatePositions(Candidate_position candidatePositions) {
		return iCandidatePositionDAO.save(candidatePositions);
	}

	/**
	 * Delete
	 */
	@Override
	public void eliminarCandidatePositions(int id) {
		iCandidatePositionDAO.deleteById(id);
	}

}
