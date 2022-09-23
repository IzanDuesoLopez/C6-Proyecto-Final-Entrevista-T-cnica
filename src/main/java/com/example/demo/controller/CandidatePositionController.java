package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.Candidate_position;
import com.example.demo.service.CandidatePositionServiceImpl;

@RestController
@RequestMapping("/api")
public class CandidatePositionController {

	/**
	 * Variables autowired
	 */
	@Autowired
	CandidatePositionServiceImpl candidatePositionServiceImpl;
	
	/**
	 * GET /candidatePositions
	 * @return
	 */
	@GetMapping("/candidatePositions")
	public List<Candidate_position> listarCandidatePositions(){
		return candidatePositionServiceImpl.listarCandidatePositions();
	}
	
	/**
	 * POST /candidatePositions
	 * @param candidatePosition
	 * @return
	 */
	@PostMapping("/candidatePositions")
	public Candidate_position guardarCandidatePosition(@RequestBody Candidate_position candidatePosition) {
		return candidatePositionServiceImpl.guardarCandidatePosition(candidatePosition);
	}
	
	/**
	 * GET /candidatePositions/{id}
	 * @param id
	 * @return
	 */
	@GetMapping("/candidatePositions/{id}")
	public Candidate_position candidatePositionXID(@PathVariable(name="id") int id) {
		
		Candidate_position candidatePosition_xid= new Candidate_position();
		candidatePosition_xid=candidatePositionServiceImpl.candidatePositionsXID(id);
		System.out.println("CandidatePosition XID: "+candidatePosition_xid);
		return candidatePosition_xid;
	}

	/**
	 * PUT /candidatePositions/{id}
	 * @param id
	 * @param candidatePosition
	 * @return
	 */
	@PutMapping("/candidatePositions/{id}")
	public Candidate_position actualizarCandidatePositions(@PathVariable(name="id")int id,@RequestBody Candidate_position candidatePosition) {
		
		Candidate_position candidatePosition_seleccionado= new Candidate_position();
		Candidate_position candidatePosition_actualizado= new Candidate_position();
		
		candidatePosition_seleccionado= candidatePositionServiceImpl.candidatePositionsXID(id);
		candidatePosition_seleccionado.setRegistry_date(candidatePosition.getRegistry_date());
		candidatePosition_seleccionado.setTest_date(candidatePosition.getTest_date());
		candidatePosition_seleccionado.setCompletion_date(candidatePosition.getCompletion_date());
		candidatePosition_seleccionado.setResult(candidatePosition.getResult());
		candidatePosition_seleccionado.setCandidate(candidatePosition.getCandidate());
		candidatePosition_seleccionado.setPosition(candidatePosition.getPosition());
		candidatePosition_actualizado = candidatePositionServiceImpl.actualizarCandidatePositions(candidatePosition_seleccionado);
		
		System.out.println("The updated CandidatePosition its: "+ candidatePosition_actualizado);
		
		return candidatePosition_actualizado;
	}
	
	/**
	 * DELETE /candidatePositions/{id}
	 * @param id
	 */
	@DeleteMapping("/candidatePositions/{id}")
	public void eliminarCandidatePositions(@PathVariable(name="id")int id) {
		candidatePositionServiceImpl.eliminarCandidatePositions(id);
	}
}
