package com.example.demo.dto;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="CandidatePositions")
public class CandidatePosition {

	// Entity variables
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Column(name="registryDate")
	private Date registryDate;
	@Column(name="testDate")
	private Date testDate;
	@Column(name="completionDate")
	private Date completionDate;
	@Column(name="result")
	private float result;
	
	@ManyToOne
	@JoinColumn(name="id_candidate")
	private Candidate candidate;
	
	@ManyToOne
	@JoinColumn(name="id_position")
	private Position position;
	
	// Default constructor
	public CandidatePosition() {
		
	}

	/**
	 * Constructor with full params
	 * @param id
	 * @param registryDate
	 * @param testDate
	 * @param completionDate
	 * @param result
	 * @param candidate
	 * @param position
	 */
	public CandidatePosition(int id, Date registryDate, Date testDate, Date completionDate, float result,
			Candidate candidate, Position position) {
		this.id = id;
		this.registryDate = registryDate;
		this.testDate = testDate;
		this.completionDate = completionDate;
		this.result = result;
		this.candidate = candidate;
		this.position = position;
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
	 * @return the registryDate
	 */
	public Date getRegistryDate() {
		return registryDate;
	}

	/**
	 * @param registryDate the registryDate to set
	 */
	public void setRegistryDate(Date registryDate) {
		this.registryDate = registryDate;
	}

	/**
	 * @return the testDate
	 */
	public Date getTestDate() {
		return testDate;
	}

	/**
	 * @param testDate the testDate to set
	 */
	public void setTestDate(Date testDate) {
		this.testDate = testDate;
	}

	/**
	 * @return the completionDate
	 */
	public Date getCompletionDate() {
		return completionDate;
	}

	/**
	 * @param completionDate the completionDate to set
	 */
	public void setCompletionDate(Date completionDate) {
		this.completionDate = completionDate;
	}

	/**
	 * @return the result
	 */
	public float getResult() {
		return result;
	}

	/**
	 * @param result the result to set
	 */
	public void setResult(float result) {
		this.result = result;
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

	/**
	 * @return the position
	 */
	public Position getPosition() {
		return position;
	}

	/**
	 * @param position the position to set
	 */
	public void setPosition(Position position) {
		this.position = position;
	}

	@Override
	public String toString() {
		return "CandidatePosition [id=" + id + ", registryDate=" + registryDate + ", testDate=" + testDate
				+ ", completionDate=" + completionDate + ", result=" + result + ", candidate=" + candidate
				+ ", position=" + position + "]";
	}
}
