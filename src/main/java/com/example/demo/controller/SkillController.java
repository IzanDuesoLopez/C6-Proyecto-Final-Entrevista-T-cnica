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

import com.example.demo.dto.Skill;
import com.example.demo.service.SkillServiceImpl;

@RestController
@RequestMapping("/api")
public class SkillController {

	/**
	 * Variables autowired
	 */
	@Autowired
	SkillServiceImpl skillServiceImpl;
	
	/**
	 * GET /skills
	 * @return
	 */
	@GetMapping("/skills")
	public List<Skill> listarSkills(){
		return skillServiceImpl.listarSkills();
	}
	
	/**
	 * GET /skills/name/{name}
	 * @param name
	 * @return
	 */
	@GetMapping("/skills/name/{name}")
	public List<Skill> listSkillsByName(@PathVariable(name="name") String name){
		return skillServiceImpl.findByName(name);
	}
	
	/**
	 * POST /skills
	 * @param skill
	 * @return
	 */
	@PostMapping("/skills")
	public Skill guardarSkill(@RequestBody Skill skill) {
		return skillServiceImpl.guardarSkill(skill);
	}
	
	/**
	 * GET /skills/{id}
	 * @param id
	 * @return
	 */
	@GetMapping("/skills/{id}")
	public Skill skillXID(@PathVariable(name="id") int id) {
		
		Skill skill_xid= new Skill();
		skill_xid=skillServiceImpl.skillsXID(id);
		System.out.println("Skill XID: "+skill_xid);
		return skill_xid;
	}

	/**
	 * PUT /skills/{id}
	 * @param id
	 * @param skill
	 * @return
	 */
	@PutMapping("/skills/{id}")
	public Skill actualizarSkills(@PathVariable(name="id")int id,@RequestBody Skill skill) {
		
		Skill skill_seleccionado= new Skill();
		Skill skill_actualizado= new Skill();
		
		skill_seleccionado= skillServiceImpl.skillsXID(id);
		skill_seleccionado.setName(skill.getName());
		skill_actualizado = skillServiceImpl.actualizarSkills(skill_seleccionado);
		
		System.out.println("The updated Skill its: "+ skill_actualizado);
		
		return skill_actualizado;
	}
	
	/**
	 * DELETE /skills/{id}
	 * @param id
	 */
	@DeleteMapping("/skills/{id}")
	public void eliminarSkills(@PathVariable(name="id")int id) {
		skillServiceImpl.eliminarSkills(id);
	}
}
