package com.employee.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.employee.models.Employee;

@Repository
public interface EmployeeRepo extends JpaRepository<Employee, Integer> {

	public List<Employee> findByNameAndSurname(String name, String surname);
	
	public List<Employee> findDistinctEmployeeByName(String name);
	
//	@Query(value="SELECT e FROM EMPLOYEE e") JPQL
	
	@Query(value="select * from employee", nativeQuery = true)
	public List<Employee> fetchAllEmployees();
	
	@Query(value="select * from employee where id= :id", nativeQuery = true)
	public Employee getById(@Param("id") Integer id);
}
