package com.example.demo.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.dto.HR_User;

public interface IHR_UserDAO extends JpaRepository<HR_User, Integer>{

	public List<HR_User> findByUsername(String username);
	
}
