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

import com.example.demo.service.CandidateServiceImpl;

import com.example.demo.dto.Candidate;

@RestController
@RequestMapping("/api")
public class CandidateController {

	@Autowired
	CandidateServiceImpl candidateServiceImpl;
	
	@GetMapping("/candidates")
	public List<Candidate> listarCandidates(){
		return candidateServiceImpl.listarCandidates();
	}
	
	@PostMapping("/candidates")
	public Candidate guardarCandidate(@RequestBody Candidate candidate) {
		return candidateServiceImpl.guardarCandidate(candidate);
	}
	
	@GetMapping("/candidates/{id}")
	public Candidate candidateXID(@PathVariable(name="id") int id) {
		
		Candidate candidate_xid= new Candidate();
		candidate_xid=candidateServiceImpl.candidatesXID(id);
		System.out.println("Candidate XID: "+candidate_xid);
		return candidate_xid;
	}

	@PutMapping("/candidates/{id}")
	public Candidate actualizarCandidates(@PathVariable(name="id")int id,@RequestBody Candidate candidate) {
		
		Candidate candidate_seleccionado= new Candidate();
		Candidate candidate_actualizado= new Candidate();
		
		candidate_seleccionado= candidateServiceImpl.candidatesXID(id);
		candidate_seleccionado.setName(candidate.getName());
		candidate_seleccionado.setSurname(candidate.getSurname());
		candidate_actualizado = candidateServiceImpl.actualizarCandidates(candidate_seleccionado);
		
		System.out.println("The updated Candidate its: "+ candidate_actualizado);
		
		return candidate_actualizado;
	}
	
	@DeleteMapping("/candidates/{id}")
	public void eliminarCandidates(@PathVariable(name="id")int id) {
		candidateServiceImpl.eliminarCandidates(id);
	}
}
