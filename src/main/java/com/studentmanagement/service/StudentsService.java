package com.studentmanagement.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.studentmanagement.dto.StudentsDto;
import com.studentmanagement.model.Students;

@Service
public interface StudentsService {
	List<Students> getAll();
	void create(StudentsDto studentDto);
	Students getById(int id);
	void edit(int id,StudentsDto studentDto);
	void deleteByID(int id);
	Students findByEmailAndPassword(Students students);
	Students getByEmail(String email);
	long countStudents();

}
