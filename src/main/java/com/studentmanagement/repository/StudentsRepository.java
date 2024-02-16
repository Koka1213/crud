package com.studentmanagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.studentmanagement.model.Students;

@Repository
public interface StudentsRepository extends JpaRepository<Students, Integer> {
	Students findById(int id);
	Students findByEmail(String email);
	Students findByEmailAndPassword(String email,String password);
	long count();
}
