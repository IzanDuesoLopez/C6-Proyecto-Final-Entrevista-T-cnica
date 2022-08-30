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

import com.example.demo.dto.HR_User;
import com.example.demo.service.HR_UserServiceImpl;

@RestController
@RequestMapping("/api")
public class HR_UserController {

	@Autowired
	HR_UserServiceImpl hr_userServiceImpl;
	
	@GetMapping("/hr_users")
	public List<HR_User> listarHR_Users(){
		return hr_userServiceImpl.listarHR_Users();
	}
	
	@GetMapping("/hr_users/username/{username}")
	public List<HR_User> listUsersByName(@PathVariable(name="username") String username){
		return hr_userServiceImpl.findByUsername(username);
	}
	
	@PostMapping("/hr_users")
	public HR_User guardarHR_User(@RequestBody HR_User hr_user) {
		return hr_userServiceImpl.guardarHR_User(hr_user);
	}
	
	@GetMapping("/hr_users/{id}")
	public HR_User hr_userXID(@PathVariable(name="id") int id) {
		
		HR_User hr_user_xid= new HR_User();
		hr_user_xid=hr_userServiceImpl.hr_usersXID(id);
		System.out.println("HR_User XID: "+hr_user_xid);
		return hr_user_xid;
	}

	@PutMapping("/hr_users/{id}")
	public HR_User actualizarHR_Users(@PathVariable(name="id")int id,@RequestBody HR_User hr_user) {
		
		HR_User hr_user_seleccionado= new HR_User();
		HR_User hr_user_actualizado= new HR_User();
		
		hr_user_seleccionado= hr_userServiceImpl.hr_usersXID(id);
		hr_user_seleccionado.setUsername(hr_user.getUsername());
		hr_user_actualizado = hr_userServiceImpl.actualizarHR_Users(hr_user_seleccionado);
		
		System.out.println("The updated HR_User its: "+ hr_user_actualizado);
		
		return hr_user_actualizado;
	}
	
	@DeleteMapping("/hr_users/{id}")
	public void eliminarHR_Users(@PathVariable(name="id")int id) {
		hr_userServiceImpl.eliminarHR_Users(id);
	}
}
