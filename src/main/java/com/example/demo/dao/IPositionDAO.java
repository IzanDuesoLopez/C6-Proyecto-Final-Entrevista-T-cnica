package com.example.demo.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.dto.Position;

public interface IPositionDAO extends JpaRepository<Position, Integer>{

	public List<Position> findByTitle(String title);
	
}
