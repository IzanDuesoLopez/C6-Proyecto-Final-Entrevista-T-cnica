package com.example.demo.dto;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="Positions")
public class Position {

	// Entity variables
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Column(name="title")
	private String title;
	@Column(name="description")
	private String description;
	
	@OneToMany
	@JoinColumn(name="id_position")
	private List<Candidate_position> candidatePosition;
	
	@ManyToOne
	@JoinColumn(name="id_HR_Users")
	private HR_User hr_Users;
	
	// Default constructor
	public Position() {
		
	}

	/**
	 * Constructor with full params
	 * @param id
	 * @param title
	 * @param description
	 * @param candidatePosition
	 * @param hr_Users
	 */
	public Position(int id, String title, String description, List<Candidate_position> candidatePosition,
			HR_User hr_Users) {
		this.id = id;
		this.title = title;
		this.description = description;
		this.candidatePosition = candidatePosition;
		this.hr_Users = hr_Users;
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
	 * @return the title
	 */
	public String getTitle() {
		return title;
	}

	/**
	 * @param title the title to set
	 */
	public void setTitle(String title) {
		this.title = title;
	}

	/**
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * @param description the description to set
	 */
	public void setDescription(String description) {
		this.description = description;
	}

	/**
	 * @return the candidatePosition
	 */
	@JsonIgnore
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "CandidatePosition")
	public List<Candidate_position> getCandidatePosition() {
		return candidatePosition;
	}

	/**
	 * @param candidatePosition the candidatePosition to set
	 */
	public void setCandidatePosition(List<Candidate_position> candidatePosition) {
		this.candidatePosition = candidatePosition;
	}

	/**
	 * @return the hr_Users
	 */
	public HR_User getHr_Users() {
		return hr_Users;
	}

	/**
	 * @param hr_Users the hr_Users to set
	 */
	public void setHr_Users(HR_User hr_Users) {
		this.hr_Users = hr_Users;
	}

	@Override
	public String toString() {
		return "Position [id=" + id + ", title=" + title + ", description=" + description + ", hr_Users=" + hr_Users
				+ "]";
	}
}
