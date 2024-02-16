package com.studentmanagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.studentmanagement.model.Teachers;

@Repository
public interface TeachersRepository extends JpaRepository<Teachers, Integer> {
		Teachers findById(int id);
		Teachers findByEmail(String email);
		Teachers findByEmailAndPassword(String email,String password);
		long count();
}
