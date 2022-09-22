package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.ICandidatePositionDAO;
import com.example.demo.dto.Candidate_position;

@Service
public class CandidatePositionServiceImpl implements ICandidatePositionService{

	@Autowired
	ICandidatePositionDAO iCandidatePositionDAO;
	
	@Override
	public List<Candidate_position> listarCandidatePositions() {
		return iCandidatePositionDAO.findAll();
	}

	@Override
	public Candidate_position guardarCandidatePosition(Candidate_position candidatePositions) {
		return iCandidatePositionDAO.save(candidatePositions);
	}

	@Override
	public Candidate_position candidatePositionsXID(int id) {
		return iCandidatePositionDAO.findById(id).get();
	}

	@Override
	public Candidate_position actualizarCandidatePositions(Candidate_position candidatePositions) {
		return iCandidatePositionDAO.save(candidatePositions);
	}

	@Override
	public void eliminarCandidatePositions(int id) {
		iCandidatePositionDAO.deleteById(id);
	}

}
