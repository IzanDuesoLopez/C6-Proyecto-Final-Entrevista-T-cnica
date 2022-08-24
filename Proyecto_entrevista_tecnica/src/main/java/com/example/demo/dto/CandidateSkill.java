package com.example.demo.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="CandidateSkills")
public class CandidateSkill {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Column(name="value")
	private float value;
	@Column(name="notes")
	private String notes;
	
	@ManyToOne
	@JoinColumn(name="id_skill")
	private Skill skill;
	
	@ManyToOne
	@JoinColumn(name="id_candidate")
	private Candidate candidate;
	
	// Default constructor
	public CandidateSkill() {
		
	}

	/**
	 * Constructor with parameters
	 * @param id
	 * @param value
	 * @param notes
	 * @param skill
	 * @param candidate
	 */
	public CandidateSkill(int id, float value, String notes, Skill skill, Candidate candidate) {
		this.id = id;
		this.value = value;
		this.notes = notes;
		this.skill = skill;
		this.candidate = candidate;
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
	 * @return the value
	 */
	public float getValue() {
		return value;
	}

	/**
	 * @param value the value to set
	 */
	public void setValue(float value) {
		this.value = value;
	}

	/**
	 * @return the notes
	 */
	public String getNotes() {
		return notes;
	}

	/**
	 * @param notes the notes to set
	 */
	public void setNotes(String notes) {
		this.notes = notes;
	}

	/**
	 * @return the skill
	 */
	public Skill getSkill() {
		return skill;
	}

	/**
	 * @param skill the skill to set
	 */
	public void setSkill(Skill skill) {
		this.skill = skill;
	}

	/**
	 * @return the candidate
	 */
	public Candidate getCandidate() {
		return candidate;
	}

	/**
	 * @param candidate the candidate to set
	 */
	public void setCandidate(Candidate candidate) {
		this.candidate = candidate;
	}

	@Override
	public String toString() {
		return "CandidateSkill [id=" + id + ", value=" + value + ", notes=" + notes + ", skill=" + skill
				+ ", candidate=" + candidate + "]";
	}
}
