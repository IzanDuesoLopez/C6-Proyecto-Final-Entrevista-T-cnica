package com.example.demo.dto;

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
@Table(name="HR_Users")
public class HR_Users {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Column(name="username")
	private String username;
	
	@OneToMany
	@JoinColumn(name="id_HR_Users")
	private List<Position> position;
	
	// Default constructor
	public HR_Users() {
		
	}

	/**
	 * Constructor with all the params
	 * @param id
	 * @param username
	 * @param position
	 */
	public HR_Users(int id, String username, List<Position> position) {
		this.id = id;
		this.username = username;
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
	 * @return the username
	 */
	public String getUsername() {
		return username;
	}

	/**
	 * @param username the username to set
	 */
	public void setUsername(String username) {
		this.username = username;
	}

	/**
	 * @return the position
	 */
	@JsonIgnore
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "Position")
	public List<Position> getPosition() {
		return position;
	}

	/**
	 * @param position the position to set
	 */
	public void setPosition(List<Position> position) {
		this.position = position;
	}

	@Override
	public String toString() {
		return "HR_Users [id=" + id + ", username=" + username + "]";
	}
}
