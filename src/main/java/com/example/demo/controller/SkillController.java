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

@CrossOrigin(origins = "https://team3-c6-project.herokuapp.com", maxAge = 3600)
@RestController
@RequestMapping("/api")
public class SkillController {

	@Autowired
	SkillServiceImpl skillServiceImpl;
	
	@GetMapping("/skills")
	public List<Skill> listarSkills(){
		return skillServiceImpl.listarSkills();
	}
	
	@GetMapping("/skills/name/{name}")
	public List<Skill> listSkillsByName(@PathVariable(name="name") String name){
		return skillServiceImpl.findByName(name);
	}
	
	@PostMapping("/skills")
	public Skill guardarSkill(@RequestBody Skill skill) {
		return skillServiceImpl.guardarSkill(skill);
	}
	
	@GetMapping("/skills/{id}")
	public Skill skillXID(@PathVariable(name="id") int id) {
		
		Skill skill_xid= new Skill();
		skill_xid=skillServiceImpl.skillsXID(id);
		System.out.println("Skill XID: "+skill_xid);
		return skill_xid;
	}

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
	
	@DeleteMapping("/skills/{id}")
	public void eliminarSkills(@PathVariable(name="id")int id) {
		skillServiceImpl.eliminarSkills(id);
	}
}
