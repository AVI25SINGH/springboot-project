package com.employee.models;

import java.util.Date;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

@Entity
public class Employee {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column
	private int id;
	
	@Column
	@NotBlank(message = "Name can not be blank")
	private String name;

	@Column
	@NotNull(message = "Surname can not be null")
	private String surname;

	@Column
	@Min(value = 10000, message = "Min salary must be 10000")
	private long salary;

	@Column
	@NotBlank(message="Location can not be blank")
	private String location;
	
	@Email(message="Email is not valid")
	@Column
	private String email;
	
	@Column
	@Pattern(regexp = "(\\+91|0)[6-9][0-9]{9}", message="Phone number is invalid")
	private String phone;

	@CreationTimestamp
	private Date createdDate;

	@UpdateTimestamp
	private Date updatedDate;
	

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

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public long getSalary() {
		return salary;
	}

	public void setSalary(long salary) {
		this.salary = salary;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	public Date getUpdatedDate() {
		return updatedDate;
	}

	public void setUpdatedDate(Date updatedDate) {
		this.updatedDate = updatedDate;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	public Employee(int id, @NotBlank(message = "Name can not be blank") String name,
			@NotNull(message = "Surname can not be null") String surname,
			@Min(value = 10000, message = "Min salary must be 10000") long salary,
			@NotBlank(message = "Location can not be blank") String location,
			@Email(message = "Email is not valid") String email,
			@Pattern(regexp = "[6-9][0-9]{9}", message = "Phone number is invalid") String phone, Date createdDate,
			Date updatedDate) {
		super();
		this.id = id;
		this.name = name;
		this.surname = surname;
		this.salary = salary;
		this.location = location;
		this.email = email;
		this.phone = phone;
		this.createdDate = createdDate;
		this.updatedDate = updatedDate;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public Employee() {
		super();
		// TODO Auto-generated constructor stub
	}

}
