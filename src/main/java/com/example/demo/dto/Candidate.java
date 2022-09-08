package com.example.demo.dto;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="Candidates")
public class Candidate {

	// Entity variables
	@Id
	@Column(name="id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Column(name="name")
	private String name;
	@Column(name="surname")
	private String surname;
	@Column(name="password")
	@JsonIgnore
	private String password;
	@Column(unique=true)
	private String username;
	@Column(name="enabled")
	private boolean enabled;
	
	 @ManyToMany(cascade = CascadeType.MERGE, fetch = FetchType.EAGER)
	    @JoinTable(
	            name = "Users_Roles",
	            joinColumns = @JoinColumn(name = "user_id"),
	            inverseJoinColumns = @JoinColumn(name = "role_id")
	            )
	    private Set<Role> roles = new HashSet<>();
	
	@OneToMany
	@JoinColumn(name="id_candidate")
	private List<Candidate_position> candidatePosition;
	
	@OneToMany
	@JoinColumn(name="id_candidate")
	private List<Candidate_skill> candidateSkill;
	
	@OneToMany
	@JoinColumn(name="id_HR_Users")
	private List<Position> position;
	
	// Default constructor
	public Candidate() {
		
	}

	/**
	 * @param id
	 * @param name
	 * @param surname
	 * @param password
	 * @param username
	 * @param enabled
	 * @param roles
	 * @param candidatePosition
	 * @param candidateSkill
	 * @param position
	 */
	public Candidate(int id, String name, String surname, String password, String username, boolean enabled,
			Set<Role> roles, List<Candidate_position> candidatePosition, List<Candidate_skill> candidateSkill,
			List<Position> position) {
		super();
		this.id = id;
		this.name = name;
		this.surname = surname;
		this.password = password;
		this.username = username;
		this.enabled = enabled;
		this.roles = roles;
		this.candidatePosition = candidatePosition;
		this.candidateSkill = candidateSkill;
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
	 * @return the surname
	 */
	public String getSurname() {
		return surname;
	}

	/**
	 * @param surname the surname to set
	 */
	public void setSurname(String surname) {
		this.surname = surname;
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
	 * @return the candidateSkill
	 */
	@JsonIgnore
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "CandidateSkill")
	public List<Candidate_skill> getCandidateSkill() {
		return candidateSkill;
	}

	/**
	 * @param candidateSkill the candidateSkill to set
	 */
	public void setCandidateSkill(List<Candidate_skill> candidateSkill) {
		this.candidateSkill = candidateSkill;
	}
	

	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * @param password the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
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
	
	

	/**
	 * @return the enabled
	 */
	public boolean getEnabled() {
		return enabled;
	}

	/**
	 * @param enabled the enabled to set
	 */
	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}
	
	

	/**
	 * @return the roles
	 */
	public Set<Role> getRoles() {
		return roles;
	}


	/**
	 * @param roles the roles to set
	 */
	public void setRoles(Set<Role> roles) {
		this.roles = roles;
	}

	@Override
	public String toString() {
		return "Candidate [id=" + id + ", name=" + name + ", surname=" + surname + ", password=" + password
				+ ", username=" + username + ", enabled=" + enabled + ", roles=" + roles + ", candidatePosition="
				+ candidatePosition + ", candidateSkill=" + candidateSkill + ", position=" + position + "]";
	}

}
