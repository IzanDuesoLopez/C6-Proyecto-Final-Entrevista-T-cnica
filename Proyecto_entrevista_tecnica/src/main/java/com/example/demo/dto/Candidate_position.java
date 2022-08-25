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
@Table(name="Candidate_positions")
public class Candidate_position {

	// Entity variables
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Column(name="registry_date")
	private Date registry_date;
	@Column(name="test_date")
	private Date test_date;
	@Column(name="completion_date")
	private Date completion_date;
	@Column(name="result")
	private float result;
	
	@ManyToOne
	@JoinColumn(name="id_candidate")
	private Candidate candidate;
	
	@ManyToOne
	@JoinColumn(name="id_position")
	private Position position;
	
	// Default constructor
	public Candidate_position() {
		
	}

	/**
	 * @param id
	 * @param registry_date
	 * @param test_date
	 * @param completion_date
	 * @param result
	 * @param candidate
	 * @param position
	 */
	public Candidate_position(int id, Date registry_date, Date test_date, Date completion_date, float result,
			Candidate candidate, Position position) {
		super();
		this.id = id;
		this.registry_date = registry_date;
		this.test_date = test_date;
		this.completion_date = completion_date;
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
	 * @return the registry_date
	 */
	public Date getRegistry_date() {
		return registry_date;
	}

	/**
	 * @param registry_date the registry_date to set
	 */
	public void setRegistry_date(Date registry_date) {
		this.registry_date = registry_date;
	}

	/**
	 * @return the test_date
	 */
	public Date getTest_date() {
		return test_date;
	}

	/**
	 * @param test_date the test_date to set
	 */
	public void setTest_date(Date test_date) {
		this.test_date = test_date;
	}

	/**
	 * @return the completion_date
	 */
	public Date getCompletion_date() {
		return completion_date;
	}

	/**
	 * @param completion_date the completion_date to set
	 */
	public void setCompletion_date(Date completion_date) {
		this.completion_date = completion_date;
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
		return "Candidate_position [id=" + id + ", registry_date=" + registry_date + ", test_date=" + test_date
				+ ", completion_date=" + completion_date + ", result=" + result + ", candidate=" + candidate
				+ ", position=" + position + "]";
	}

	
}
