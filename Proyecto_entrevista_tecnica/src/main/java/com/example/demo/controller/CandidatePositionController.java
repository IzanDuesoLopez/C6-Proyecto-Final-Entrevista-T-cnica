package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.CandidatePosition;
import com.example.demo.service.CandidatePositionServiceImpl;

@RestController
@RequestMapping("/api")
public class CandidatePositionController {

	@Autowired
	CandidatePositionServiceImpl candidatePositionServiceImpl;
	
	@GetMapping("/candidatePositions")
	public List<CandidatePosition> listarCandidatePositions(){
		return candidatePositionServiceImpl.listarCandidatePositions();
	}
	
	@PostMapping("/candidatePositions")
	public CandidatePosition guardarCandidatePosition(@RequestBody CandidatePosition candidatePosition) {
		return candidatePositionServiceImpl.guardarCandidatePosition(candidatePosition);
	}
	
	@GetMapping("/candidatePositions/{id}")
	public CandidatePosition candidatePositionXID(@PathVariable(name="id") int id) {
		
		CandidatePosition candidatePosition_xid= new CandidatePosition();
		candidatePosition_xid=candidatePositionServiceImpl.candidatePositionsXID(id);
		System.out.println("CandidatePosition XID: "+candidatePosition_xid);
		return candidatePosition_xid;
	}

	@PutMapping("/candidatePositions/{id}")
	public CandidatePosition actualizarCandidatePositions(@PathVariable(name="id")int id,@RequestBody CandidatePosition candidatePosition) {
		
		CandidatePosition candidatePosition_seleccionado= new CandidatePosition();
		CandidatePosition candidatePosition_actualizado= new CandidatePosition();
		
		candidatePosition_seleccionado= candidatePositionServiceImpl.candidatePositionsXID(id);
		candidatePosition_seleccionado.setRegistryDate(candidatePosition.getRegistryDate());
		candidatePosition_seleccionado.setTestDate(candidatePosition.getTestDate());
		candidatePosition_seleccionado.setCompletionDate(candidatePosition.getCompletionDate());
		candidatePosition_seleccionado.setResult(candidatePosition.getResult());
		candidatePosition_seleccionado.setCandidate(candidatePosition.getCandidate());
		candidatePosition_seleccionado.setPosition(candidatePosition.getPosition());
		candidatePosition_actualizado = candidatePositionServiceImpl.actualizarCandidatePositions(candidatePosition_seleccionado);
		
		System.out.println("The updated CandidatePosition its: "+ candidatePosition_actualizado);
		
		return candidatePosition_actualizado;
	}
	
	@DeleteMapping("/candidatePositions/{id}")
	public void eliminarCandidatePositions(@PathVariable(name="id")int id) {
		candidatePositionServiceImpl.eliminarCandidatePositions(id);
	}
}
