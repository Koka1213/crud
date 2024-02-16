package com.studentmanagement.service;

import org.springframework.stereotype.Service;

import com.studentmanagement.model.Admins;

@Service
public interface AdminsService {
	Admins findByEmailAndPassword(Admins admins);
	Admins getByEmail(String email);
}
