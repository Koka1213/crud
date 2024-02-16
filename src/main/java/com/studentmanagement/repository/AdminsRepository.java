package com.studentmanagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.studentmanagement.model.Admins;

@Repository
public interface AdminsRepository extends JpaRepository<Admins, Integer> {
	Admins findByEmailAndPassword(String email,String password);
	Admins findByEmail(String email);
}
