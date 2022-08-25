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

import com.example.demo.dto.CandidateSkill;
import com.example.demo.service.CandidateSkillServiceImpl;

@RestController
@RequestMapping("/api")
public class CandidateSkillController {

	@Autowired
	CandidateSkillServiceImpl candidateSkillServiceImpl;
	
	@GetMapping("/candidateSkills")
	public List<CandidateSkill> listarCandidateSkills(){
		return candidateSkillServiceImpl.listarCandidateSkills();
	}
	
	@PostMapping("/candidateSkills")
	public CandidateSkill guardarCandidateSkill(@RequestBody CandidateSkill candidateSkill) {
		return candidateSkillServiceImpl.guardarCandidateSkill(candidateSkill);
	}
	
	@GetMapping("/candidateSkills/{id}")
	public CandidateSkill candidateSkillXID(@PathVariable(name="id") int id) {
		
		CandidateSkill candidateSkill_xid= new CandidateSkill();
		candidateSkill_xid=candidateSkillServiceImpl.candidateSkillsXID(id);
		System.out.println("CandidateSkill XID: "+candidateSkill_xid);
		return candidateSkill_xid;
	}

	@PutMapping("/candidateSkills/{id}")
	public CandidateSkill actualizarCandidateSkills(@PathVariable(name="id")int id,@RequestBody CandidateSkill candidateSkill) {
		
		CandidateSkill candidateSkill_seleccionado= new CandidateSkill();
		CandidateSkill candidateSkill_actualizado= new CandidateSkill();
		
		candidateSkill_seleccionado= candidateSkillServiceImpl.candidateSkillsXID(id);
		candidateSkill_seleccionado.setValue(candidateSkill.getValue());
		candidateSkill_seleccionado.setNotes(candidateSkill.getNotes());
		candidateSkill_seleccionado.setSkill(candidateSkill.getSkill());
		candidateSkill_seleccionado.setCandidate(candidateSkill.getCandidate());
		candidateSkill_actualizado = candidateSkillServiceImpl.actualizarCandidateSkills(candidateSkill_seleccionado);
		
		System.out.println("The updated CandidateSkill its: "+ candidateSkill_actualizado);
		
		return candidateSkill_actualizado;
	}
	
	@DeleteMapping("/candidateSkills/{id}")
	public void eliminarCandidateSkills(@PathVariable(name="id")int id) {
		candidateSkillServiceImpl.eliminarCandidateSkills(id);
	}
}
