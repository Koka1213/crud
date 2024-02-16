package com.studentmanagement.service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.studentmanagement.dto.StudentsDto;
import com.studentmanagement.model.Students;
import com.studentmanagement.repository.StudentsRepository;

@Service
public class StudentsServiceImpl implements StudentsService {

	@Autowired
	private StudentsRepository repo;

	@Override
	public List<Students> getAll() {
		return repo.findAll();
	}

	@Override
	public void create(StudentsDto studentDto) {
		Date date = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		String formattedDate = sdf.format(date);
		Students student = new Students();
		student.setName(studentDto.getName());
		student.setPhone(studentDto.getPhone());
		student.setAddress(studentDto.getAddress());
		student.setEmail(studentDto.getEmail());
		student.setGender(studentDto.getGender());
		student.setDateOfBirth(studentDto.getDateOfBirth());
		student.setRegisterDate(formattedDate);
		repo.save(student);
	}

	@Override
	public Students getById(int id) {
		Students optional = repo.findById(id);
		Students student = null;
		
		if(optional!= null) {
			student = optional;
		}
		else {
			throw new RuntimeException("Product not found for id:: " + id);
		}
		return student;
	}

	@Override
	public void edit(int id, StudentsDto studentDto) {
		Students student = repo.findById(id);
		student.setName(studentDto.getName());
		student.setPhone(studentDto.getPhone());
		student.setAddress(studentDto.getAddress());
		student.setEmail(studentDto.getEmail());
		student.setGender(studentDto.getGender());
		student.setDateOfBirth(studentDto.getDateOfBirth());
		repo.save(student);
	}

	@Override
	public void deleteByID(int id) {
		repo.deleteById(id);
	}
	@Override
	public Students findByEmailAndPassword(Students students) {
		return repo.findByEmailAndPassword(students.getEmail(), students.getPassword());
	}

	@Override
	public long countStudents() {
		return repo.count();
	}

	@Override
	public Students getByEmail(String email) {
		return repo.findByEmail(email);
	}
}
