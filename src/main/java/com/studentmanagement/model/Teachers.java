package com.studentmanagement.model;

import java.util.List;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotEmpty;

@Entity
@Table( name = "teachers")
public class Teachers {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;


	private String name;
	private String qualification;
	private String phone;
	private String email;
	private String address;
	private String password;
	private int serviceYear;
	
	
	@OneToMany(mappedBy = "teachers" , cascade =CascadeType.ALL)
	private List<TeacherCourses> teacherCourses;
	

	public Teachers() {
		super();
	}


	public Teachers(int id,String name, String qualification, String phone, String email, String address, String password,
			int serviceYear) {
		super();
		this.id=id;
		this.name = name;
		this.qualification = qualification;
		this.phone = phone;
		this.email = email;
		this.address = address;
		this.password = password;
		this.serviceYear = serviceYear;
	}



	public Teachers(String name, String qualification, String phone, String email, String address, String password,
			int serviceYear, List<TeacherCourses> teacherCourses) {
		super();
		this.name = name;
		this.qualification = qualification;
		this.phone = phone;
		this.email = email;
		this.address = address;
		this.password = password;
		this.serviceYear = serviceYear;
		this.teacherCourses = teacherCourses;
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


	public String getQualification() {
		return qualification;
	}


	public void setQualification(String qualification) {
		this.qualification = qualification;
	}


	public String getPhone() {
		return phone;
	}


	public void setPhone(String phone) {
		this.phone = phone;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getAddress() {
		return address;
	}


	public void setAddress(String address) {
		this.address = address;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	public int getServiceYear() {
		return serviceYear;
	}


	public void setServiceYear(int serviceYear) {
		this.serviceYear = serviceYear;
	}


	public List<TeacherCourses> getTeacherCourses() {
		return teacherCourses;
	}


	public void setTeacherCourses(List<TeacherCourses> teacherCourses) {
		this.teacherCourses = teacherCourses;
	}


	
}
