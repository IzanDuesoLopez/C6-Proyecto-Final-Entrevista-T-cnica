package com.example.demo.service;

import java.util.List;

import static java.util.Collections.emptyList;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.parsing.EmptyReaderEventListener;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.demo.dao.ICandidateDAO;
import com.example.demo.dto.Candidate;
import com.example.demo.dto.JwtRequest;

@Service
public class CandidateServiceImpl implements ICandidateService, UserDetailsService{

	/**
	 * Variables autowired
	 */
	@Autowired
	ICandidateDAO iCandidateDAO;
	
	@Autowired
	private PasswordEncoder bcryptEncoder;
	
	/**
	 * @param iCandidateDAO
	 */
	public CandidateServiceImpl(ICandidateDAO iCandidateDAO) {
		this.iCandidateDAO = iCandidateDAO;
	}
	
	/**
	 * Get all
	 */
	@Override
	public List<Candidate> listarCandidates() {
		return iCandidateDAO.findAll();
	}

	/**
	 * Create
	 */
	@Override
	public Candidate guardarCandidate(Candidate candidates) {
		return iCandidateDAO.save(candidates);
	}
	
	/**
	 * Get by id
	 */
	@Override
	public Candidate candidatesXID(int id) {
		return iCandidateDAO.findById(id).get();
	}

	/**
	 * Update
	 */
	@Override
	public Candidate actualizarCandidates(Candidate candidates) {
		return iCandidateDAO.save(candidates);
	}

	/**
	 * Delete
	 */
	@Override
	public void eliminarCandidates(int id) {
		iCandidateDAO.deleteById(id);
	}

	/**
	 * Find by name
	 */
	@Override
	public List<Candidate> findByName(String name) {
		return iCandidateDAO.findByName(name);
	}
	
	/**
	 * Find by username
	 */
	@Override
	public Candidate findByUsername(String username) {
		return iCandidateDAO.findByUsername(username);
	}

	/**
	 * Search if the user exists, if not, returns an exception, if yes, return the data
	 */
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

		Candidate user = iCandidateDAO.findByUsername(username);
		if (user == null) {
			throw new UsernameNotFoundException("User not found with username: " + username);
		}
		return new MyUserDetails(user);
	}

	/**
	 * Receives by paramater the data from a request, creates a newUser and saves it as a new candidate
	 * @param user
	 * @return
	 */
	public Candidate save(JwtRequest user) {
		System.out.println(user.getPassword());
		Candidate newUser = new Candidate();
		newUser.setName(user.getName());
		newUser.setSurname(user.getSurname());
		newUser.setUsername(user.getUsername());
		newUser.setPassword(bcryptEncoder.encode(user.getPassword()));
		newUser.setEnabled(user.isEnabled());
		newUser.setRoles(user.getRoles());
		return iCandidateDAO.save(newUser);
	}

}
