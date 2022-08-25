package com.example.demo.dto;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="Skills")
public class Skill {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Column(name="name")
	private String name;
	
	@OneToMany
	@JoinColumn(name="id_skill")
	private List<CandidateSkill> candidateSkill;
	
	// Default constructor
	public Skill() {
		
	}

	/**
	 * Constructor with parameters
	 * @param id
	 * @param name
	 * @param candidateSkill
	 */
	public Skill(int id, String name, List<CandidateSkill> candidateSkill) {
		this.id = id;
		this.name = name;
		this.candidateSkill = candidateSkill;
	}

	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the candidateSkill
	 */
	@JsonIgnore
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "CandidateSkill")
	public List<CandidateSkill> getCandidateSkill() {
		return candidateSkill;
	}

	/**
	 * @param candidateSkill the candidateSkill to set
	 */
	public void setCandidateSkill(List<CandidateSkill> candidateSkill) {
		this.candidateSkill = candidateSkill;
	}

	@Override
	public String toString() {
		return "Skill [id=" + id + ", name=" + name + "]";
	}
	
}
