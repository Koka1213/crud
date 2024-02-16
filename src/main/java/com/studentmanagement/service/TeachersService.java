package com.studentmanagement.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.studentmanagement.dto.TeachersDto;
import com.studentmanagement.model.Teachers;

@Service
public interface TeachersService {
	List<Teachers> getAll(); 
	void create(TeachersDto teachersDto);
	Teachers getById(int id);
	void edit(int id,TeachersDto teacherDto);
	void deleteByID(int id);
	Teachers findByEmailAndPassword(Teachers teachers);
	Long countTeacher();
	Teachers getByEmail(String email);
	Teachers editProfile(int id,TeachersDto teacherDto);
}
