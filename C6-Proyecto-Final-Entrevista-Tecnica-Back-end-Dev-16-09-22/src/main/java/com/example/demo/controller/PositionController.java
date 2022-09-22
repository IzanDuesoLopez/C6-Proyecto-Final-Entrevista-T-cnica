package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.Position;
import com.example.demo.service.PositionServiceImpl;

@RestController
@RequestMapping("/api")
public class PositionController {

	@Autowired
	PositionServiceImpl positionServiceImpl;
	
	@GetMapping("/positions")
	public List<Position> listarPositions(){
		return positionServiceImpl.listarPositions();
	}
	
	@GetMapping("/positions/title/{title}")
	public List<Position> listPositionByTitle(@PathVariable(name="title") String title){
		return positionServiceImpl.findByTitle(title);
	}
	
	@PostMapping("/positions")
	public Position guardarPosition(@RequestBody Position position) {
		return positionServiceImpl.guardarPosition(position);
	}
	
	@GetMapping("/positions/{id}")
	public Position positionXID(@PathVariable(name="id") int id) {
		
		Position position_xid= new Position();
		position_xid=positionServiceImpl.positionsXID(id);
		System.out.println("Position XID: "+position_xid);
		return position_xid;
	}

	@PutMapping("/positions/{id}")
	public Position actualizarPositions(@PathVariable(name="id")int id,@RequestBody Position position) {
		
		Position position_seleccionado= new Position();
		Position position_actualizado= new Position();
		
		position_seleccionado= positionServiceImpl.positionsXID(id);
		position_seleccionado.setTitle(position.getTitle());
		position_seleccionado.setDescription(position.getDescription());
		position_seleccionado.setHr_Users(position.getHr_Users());
		position_actualizado = positionServiceImpl.actualizarPositions(position_seleccionado);
		
		System.out.println("The updated Position its: "+ position_actualizado);
		
		return position_actualizado;
	}
	
	@DeleteMapping("/positions/{id}")
	public void eliminarPositions(@PathVariable(name="id")int id) {
		positionServiceImpl.eliminarPositions(id);
	}
}
