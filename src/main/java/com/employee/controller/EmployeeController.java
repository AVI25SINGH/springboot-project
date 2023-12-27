package com.employee.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.employee.models.Employee;
import com.employee.service.ServiceInf;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/employee")
public class EmployeeController {

	@Autowired
	ServiceInf service;

	@PostMapping("/save")
	public String saveEmployee(@RequestBody @Valid Employee employee) {
		return service.savewEmployee(employee);
	}

	@GetMapping("/fetch")
	public List<Employee> getEmployees() {
		return service.getEmployees();
	}
	
	@DeleteMapping("/delete/{id}")
	public List<Employee> deleteEmployee(@PathVariable int id) {
		return service.deleteEmployee(id);
	}
	
	@PutMapping("/update")
	public Employee updateEmployee(@RequestBody @Valid Employee employee) {
		return service.updateEmployee(employee);
	}
	
	@GetMapping("/fetch/{name}/{surname}")
	public List<Employee> getByNameAndSurname(@PathVariable String name,@PathVariable String surname) {
		return service.getByNameAndSurname(name, surname);
	}
	
	@GetMapping("/fetch/{name}")
	public List<Employee> getDistinctEmployees(@PathVariable String name) {
		return service.getDistinctEmployees(name);
	}
	
	@GetMapping("/hello")
	public String hello() {
		return "Hello";
	}
	
//	@ExceptionHandler(MethodArgumentNotValidException.class)
//	public Map<String, String> handleValidationException(MethodArgumentNotValidException ex) {
//		
//		Map<String, String> errors = new HashMap<String, String>();
//		
//		ex.getBindingResult().getFieldErrors().forEach((error)->{
//			errors.put(error.getField(), error.getDefaultMessage());
//		});
//
//		return errors;
//	}
}
