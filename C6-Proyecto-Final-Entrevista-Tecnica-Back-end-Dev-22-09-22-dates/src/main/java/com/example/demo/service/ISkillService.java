package com.example.demo.service;

import java.util.List;

import com.example.demo.dto.Skill;

public interface ISkillService {

	//Metodos del CRUD
	public List<Skill> listarSkills(); // Listar All 
	
	public Skill guardarSkill(Skill skills);	// CREATE
	
	public Skill skillsXID(int id); // READ
	
	public Skill actualizarSkills(Skill skills); // UPDATE
	
	public void eliminarSkills(int id); // DELETE
	
	public List<Skill> findByName(String name); // Find by name
}
