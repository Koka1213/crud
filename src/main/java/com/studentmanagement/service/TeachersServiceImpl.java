package com.studentmanagement.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.studentmanagement.dto.TeachersDto;
import com.studentmanagement.model.Teachers;
import com.studentmanagement.repository.TeachersRepository;

@Service
public class TeachersServiceImpl implements TeachersService {
	
	@Autowired
	TeachersRepository teachersRepository;

	@Override
	public List<Teachers> getAll() {
		return teachersRepository.findAll();
	}

	@Override
	public Teachers getById(int id) {
		return teachersRepository.findById(id);
	}

	@Override
	public void create(TeachersDto teacherDto) {
		Teachers teacher = new Teachers();
		teacher.setName(teacherDto.getName());
		teacher.setQualification(teacherDto.getQualification());
		teacher.setPhone(teacherDto.getPhone());
		teacher.setEmail(teacherDto.getEmail());
		teacher.setAddress(teacherDto.getAddress());
		teacher.setServiceYear(teacherDto.getServiceYear());
		teachersRepository.save(teacher);
	}

	@Override
	public void edit(int id, TeachersDto teacherDto) {
		Teachers teacher = teachersRepository.findById(id);
		teacher.setName(teacherDto.getName());
		teacher.setQualification(teacherDto.getQualification());
		teacher.setPhone(teacherDto.getPhone());
		teacher.setEmail(teacherDto.getEmail());
		teacher.setAddress(teacherDto.getAddress());
		teacher.setServiceYear(teacherDto.getServiceYear());
		teachersRepository.save(teacher);
	}

	@Override
	public void deleteByID(int id) {
		teachersRepository.deleteById(id);
	}
	
	@Override
	public Teachers findByEmailAndPassword(Teachers teachers) {
		return teachersRepository.findByEmailAndPassword(teachers.getEmail(), teachers.getPassword());
	}
	@Override
	public Long countTeacher() {
		return teachersRepository.count();
	}

	@Override
	public Teachers getByEmail(String email) {
		return teachersRepository.findByEmail(email);
	}
	
	@Override
	public Teachers editProfile(int id, TeachersDto teacherDto) {
		Teachers teacher = teachersRepository.findById(id);
		teacher.setName(teacherDto.getName());
		teacher.setEmail(teacherDto.getEmail());
		teacher.setPassword(teacherDto.getPassword());
		teacher.setPhone(teacherDto.getPhone());
		teacher.setAddress(teacherDto.getAddress());
		teacher.setQualification(teacherDto.getQualification());
		teacher.setServiceYear(teacherDto.getServiceYear());
		teachersRepository.save(teacher);
	
		
		return null;
	
	}
}
