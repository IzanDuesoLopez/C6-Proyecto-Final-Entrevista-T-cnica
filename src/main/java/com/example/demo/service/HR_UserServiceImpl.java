package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.IHR_UserDAO;
import com.example.demo.dto.HR_User;

@Service
public class HR_UserServiceImpl implements IHR_UserService{

	@Autowired
	IHR_UserDAO iHR_UserDAO;
	
	@Override
	public List<HR_User> listarHR_Users() {
		return iHR_UserDAO.findAll();
	}

	@Override
	public HR_User guardarHR_User(HR_User hr_users) {
		return iHR_UserDAO.save(hr_users);
	}

	@Override
	public HR_User hr_usersXID(int id) {
		return iHR_UserDAO.findById(id).get();
	}

	@Override
	public HR_User actualizarHR_Users(HR_User hr_users) {
		return iHR_UserDAO.save(hr_users);
	}

	@Override
	public void eliminarHR_Users(int id) {
		iHR_UserDAO.deleteById(id);
	}

}
