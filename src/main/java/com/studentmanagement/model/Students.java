package com.studentmanagement.model;

import java.util.Date;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table( name = "students")
public class Students {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	private String 	name;
	private String phone;
	private String address;
	private String email;
	private String password;
	private String gender;
	private String dateOfBirth;
	private String registerDate;
	
	
	@OneToMany(mappedBy = "students" , cascade =CascadeType.ALL)
	private List<TeacherCourseStudents> teacherCourseStudents;


	
	
	public Students() {
		super();
	}


	public Students(String name, String phone, String address, String email, String password, String gender,
			String dateOfBirth,String registerDate, List<TeacherCourseStudents> teacherCourseStudents) {
		super();
		this.name = name;
		this.phone = phone;
		this.address = address;
		this.email = email;
		this.password = password;
		this.gender = gender;
		this.dateOfBirth = dateOfBirth;
		this.registerDate = registerDate;
		this.teacherCourseStudents = teacherCourseStudents;
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getPhone() {
		return phone;
	}


	public void setPhone(String phone) {
		this.phone = phone;
	}


	public String getAddress() {
		return address;
	}


	public void setAddress(String address) {
		this.address = address;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	public String getGender() {
		return gender;
	}


	public void setGender(String gender) {
		this.gender = gender;
	}


	public String getDateOfBirth() {
		return dateOfBirth;
	}


	public void setDateOfBirth(String dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}


	public String getRegisterDate() {
		return registerDate;
	}


	public void setRegisterDate(String registerDate) {
		this.registerDate = registerDate;
	}


	public List<TeacherCourseStudents> getTeacherCourseStudents() {
		return teacherCourseStudents;
	}


	public void setTeacherCourseStudents(List<TeacherCourseStudents> teacherCourseStudents) {
		this.teacherCourseStudents = teacherCourseStudents;
	}

	
	
	

}
