package com.example.demo.service;

import java.util.List;

import com.example.demo.dto.Position;

public interface IPositionService {
	//Metodos del CRUD
	public List<Position> listarPositions(); // Listar All 
	
	public Position guardarPosition(Position positions);	// CREATE
	
	public Position positionsXID(int id); // READ
	
	public Position actualizarPositions(Position positions); // UPDATE
	
	public void eliminarPositions(int id); // DELETE
}
