package com.example.demo.service;

import java.util.List;

import com.example.demo.dto.HR_User;

public interface IHR_UserService {

	//Metodos del CRUD
	public List<HR_User> listarHR_Users(); // Listar All 
	
	public HR_User guardarHR_User(HR_User hr_users);	// CREATE
	
	public HR_User hr_usersXID(int id); // READ
	
	public HR_User actualizarHR_Users(HR_User hr_users); // UPDATE
	
	public void eliminarHR_Users(int id); // DELETE
	
	public List<HR_User> findByUsername(String username); // Find by username
}
