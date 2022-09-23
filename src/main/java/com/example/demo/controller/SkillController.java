package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.demo.dto.Skill;
import com.example.demo.service.SkillServiceImpl;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "*", methods= {RequestMethod.GET,RequestMethod.POST,RequestMethod.PUT,RequestMethod.DELETE})
public class SkillController {

	@Autowired
	SkillServiceImpl skillServiceImpl;
	
	@GetMapping("/response-entity-builder-with-http-headers")
	public ResponseEntity<String> usingResponseEntityBuilderAndHttpHeaders() {
	    HttpHeaders responseHeaders = new HttpHeaders();
	    responseHeaders.set("Baeldung-Example-Header", 
	      "Value-ResponseEntityBuilderWithHttpHeaders");

	    return ResponseEntity.ok()
	      .headers(responseHeaders)
	      .body("Response with header using ResponseEntity");
	}
	
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
	public ResponseEntity<Skill> actualizarSkills(@PathVariable(name="id")int id,@RequestBody Skill skill) {
		
		Skill skill_seleccionado= new Skill();
		Skill skill_actualizado= new Skill();
		
		skill_seleccionado= skillServiceImpl.skillsXID(id);
		skill_seleccionado.setName(skill.getName());
		skill_actualizado = skillServiceImpl.actualizarSkills(skill_seleccionado);
		
		System.out.println("The updated Skill its: "+ skill_actualizado);
		
//		HttpHeaders responseHeaders = new HttpHeaders();
//		responseHeaders.set("Access-Control-Allow-Origin", "*");
//		responseHeaders.set("Access-Control-Allow-Methods", "*");
//		responseHeaders.set("Access-Control-Max-Age", "3600");
//		responseHeaders.set("Access-Control-Allow-Credentials", "true");
//		responseHeaders.set("Access-Control-Allow-Headers", "*");
		
		
		return ResponseEntity.status(HttpStatus.OK).body(skill_actualizado);
	}
	
	@DeleteMapping("/skills/{id}")
	public void eliminarSkills(@PathVariable(name="id")int id) {
		skillServiceImpl.eliminarSkills(id);
	}
}
