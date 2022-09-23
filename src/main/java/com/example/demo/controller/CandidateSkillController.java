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

import com.example.demo.dto.Candidate_skill;
import com.example.demo.service.CandidateSkillServiceImpl;

@RestController
@RequestMapping("/api")
public class CandidateSkillController {

	/**
	 * Variables autowired
	 */
	@Autowired
	CandidateSkillServiceImpl candidateSkillServiceImpl;
	
	/**
	 * GET /candidateSkills
	 * @return
	 */
	@GetMapping("/candidateSkills")
	public List<Candidate_skill> listarCandidateSkills(){
		return candidateSkillServiceImpl.listarCandidateSkills();
	}
	
	/**
	 * POST /candidateSkills
	 * @param candidateSkill
	 * @return
	 */
	@PostMapping("/candidateSkills")
	public Candidate_skill guardarCandidateSkill(@RequestBody Candidate_skill candidateSkill) {
		return candidateSkillServiceImpl.guardarCandidateSkill(candidateSkill);
	}
	
	/**
	 * GET /candidateSkills/{id}
	 * @param id
	 * @return
	 */
	@GetMapping("/candidateSkills/{id}")
	public Candidate_skill candidateSkillXID(@PathVariable(name="id") int id) {
		
		Candidate_skill candidateSkill_xid= new Candidate_skill();
		candidateSkill_xid=candidateSkillServiceImpl.candidateSkillsXID(id);
		System.out.println("CandidateSkill XID: "+candidateSkill_xid);
		return candidateSkill_xid;
	}

	/**
	 * PUT /candidateSkills/{id}
	 * @param id
	 * @param candidateSkill
	 * @return
	 */
	@PutMapping("/candidateSkills/{id}")
	public Candidate_skill actualizarCandidateSkills(@PathVariable(name="id")int id,@RequestBody Candidate_skill candidateSkill) {
		
		Candidate_skill candidateSkill_seleccionado= new Candidate_skill();
		Candidate_skill candidateSkill_actualizado= new Candidate_skill();
		
		candidateSkill_seleccionado= candidateSkillServiceImpl.candidateSkillsXID(id);
		candidateSkill_seleccionado.setValue(candidateSkill.getValue());
		candidateSkill_seleccionado.setNotes(candidateSkill.getNotes());
		candidateSkill_seleccionado.setSkill(candidateSkill.getSkill());
		candidateSkill_seleccionado.setCandidate(candidateSkill.getCandidate());
		candidateSkill_actualizado = candidateSkillServiceImpl.actualizarCandidateSkills(candidateSkill_seleccionado);
		
		System.out.println("The updated CandidateSkill its: "+ candidateSkill_actualizado);
		
		return candidateSkill_actualizado;
	}
	
	/**
	 * DELETE /candidateSkills/{id}
	 * @param id
	 */
	@DeleteMapping("/candidateSkills/{id}")
	public void eliminarCandidateSkills(@PathVariable(name="id")int id) {
		candidateSkillServiceImpl.eliminarCandidateSkills(id);
	}
}
