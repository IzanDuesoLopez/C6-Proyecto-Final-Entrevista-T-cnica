package com.example.demo.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Roles")
public class Role {
	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@Column(name="nombre")
	private String nombre;

	public Integer getId() {
		return id;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return nombre;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String nombre) {
		this.nombre = nombre;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(Integer id) {
		this.id = id;
	}
	
	
	
}
