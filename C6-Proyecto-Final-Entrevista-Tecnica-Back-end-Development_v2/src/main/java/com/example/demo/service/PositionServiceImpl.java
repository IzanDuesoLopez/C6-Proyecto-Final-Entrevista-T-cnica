package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.IPositionDAO;
import com.example.demo.dto.Position;

@Service
public class PositionServiceImpl implements IPositionService{

	@Autowired
	IPositionDAO iPositionDAO;
	
	@Override
	public List<Position> listarPositions() {
		return iPositionDAO.findAll();
	}

	@Override
	public Position guardarPosition(Position positions) {
		return iPositionDAO.save(positions);
	}

	@Override
	public Position positionsXID(int id) {
		return iPositionDAO.findById(id).get();
	}

	@Override
	public Position actualizarPositions(Position positions) {
		return iPositionDAO.save(positions);
	}

	@Override
	public void eliminarPositions(int id) {
		iPositionDAO.deleteById(id);
	}

	@Override
	public List<Position> findByTitle(String title) {
		return iPositionDAO.findByTitle(title);
	}

}
