package com.studentmanagement.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.studentmanagement.model.Admins;
import com.studentmanagement.repository.AdminsRepository;

@Service
public class AdminsServiceImpl implements AdminsService {

	@Autowired
	AdminsRepository repo;

	@Override
	public Admins findByEmailAndPassword(Admins admins) {
		return repo.findByEmailAndPassword(admins.getEmail(), admins.getPassword());
	}

	@Override
	public Admins getByEmail(String email) {
		return repo.findByEmail(email);
	}

}
