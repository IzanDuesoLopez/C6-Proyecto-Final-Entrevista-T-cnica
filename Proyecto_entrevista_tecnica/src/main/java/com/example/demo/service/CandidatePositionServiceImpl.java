package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.ICandidatePositionDAO;
import com.example.demo.dto.CandidatePosition;

@Service
public class CandidatePositionServiceImpl implements ICandidatePositionService{

	@Autowired
	ICandidatePositionDAO iCandidatePositionDAO;
	
	@Override
	public List<CandidatePosition> listarCandidatePositions() {
		return iCandidatePositionDAO.findAll();
	}

	@Override
	public CandidatePosition guardarCandidatePosition(CandidatePosition candidatePositions) {
		return iCandidatePositionDAO.save(candidatePositions);
	}

	@Override
	public CandidatePosition candidatePositionsXID(int id) {
		return iCandidatePositionDAO.findById(id).get();
	}

	@Override
	public CandidatePosition actualizarCandidatePositions(CandidatePosition candidatePositions) {
		return iCandidatePositionDAO.save(candidatePositions);
	}

	@Override
	public void eliminarCandidatePositions(int id) {
		iCandidatePositionDAO.deleteById(id);
	}

}
