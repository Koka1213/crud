package com.studentmanagement.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

public class TeachersDto {

		private int id;

		@NotEmpty(message = "Name is required")
		private String name;
		
		@NotEmpty(message = "Qualification is required")
		private String qualification;
		
		@NotEmpty(message = "Phone is required")
		@Pattern(regexp="[0-9]+", message="Phone number must contain only digits")
		@Size(min = 10, max = 15, message = "Phone number must be between 10 and 15 digits")
		private String phone;
		
		@NotEmpty(message = "Email is required")
		private String email;
		
		@NotEmpty(message = "Address is required")
		private String address;
		
		private String password;
		
		@NotNull(message = "Service year is required")
		@Min(value = 1, message = "Service year must be at least 1")
		private int serviceYear;

		
		
		public TeachersDto() {
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
		
		
	
		
	}

