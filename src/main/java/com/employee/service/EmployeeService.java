package com.employee.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.employee.models.Employee;
import com.employee.repo.EmployeeRepo;

@Service
public class EmployeeService implements ServiceInf{

	@Autowired
	EmployeeRepo repo;
	
	@Override
	public String savewEmployee(Employee employee) {
		try {
			repo.save(employee);
			return "Employee details stored for id: "+employee.getId();
		} catch(Exception e) {
			System.out.println(e);
			return "Something went wrong!";
		}
	}

	@Override
	public List<Employee> getEmployees() {
		try {
//			return repo.findAll();
			return repo.fetchAllEmployees();
		} catch(Exception e) {
			System.out.println(e);
			return null;
		}
	}

	@Override
	public List<Employee> deleteEmployee(int id) {
		try {
			repo.deleteById(id);
			return repo.findAll();
		} catch(Exception e) {
			System.out.println(e);
			return null;
		}
	}

	@Override
	public Employee updateEmployee(Employee employee) {
		try {
			
			Employee dbEmp = repo.getById(employee.getId());
			employee.setCreatedDate(dbEmp.getCreatedDate());
			
			repo.save(employee);
//			return repo.findById(employee.getId()).get();
			return repo.getById(employee.getId());
		}catch(Exception e) {
			System.out.println(e);
			return null;
		}
	}

	@Override
	public List<Employee> getByNameAndSurname(String name, String surname) {
		return repo.findByNameAndSurname(name, surname);
	}

	@Override
	public List<Employee> getDistinctEmployees(String name) {
		return repo.findDistinctEmployeeByName(name);
	}

}
