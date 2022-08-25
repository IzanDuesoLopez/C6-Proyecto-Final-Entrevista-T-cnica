package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.ICandidateDAO;
import com.example.demo.dto.Candidate;

@Service
public class CandidateServiceImpl implements ICandidateService{

	@Autowired
	ICandidateDAO iCandidateDAO;
	
	@Override
	public List<Candidate> listarCandidates() {
		return iCandidateDAO.findAll();
	}

	@Override
	public Candidate guardarCandidate(Candidate candidates) {
		return iCandidateDAO.save(candidates);
	}

	@Override
	public Candidate candidatesXID(int id) {
		return iCandidateDAO.findById(id).get();
	}

	@Override
	public Candidate actualizarCandidates(Candidate candidates) {
		return iCandidateDAO.save(candidates);
	}

	@Override
	public void eliminarCandidates(int id) {
		iCandidateDAO.deleteById(id);
		
	}

}
