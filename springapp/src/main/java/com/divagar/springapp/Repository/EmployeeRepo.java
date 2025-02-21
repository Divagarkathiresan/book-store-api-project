package com.divagar.springapp.Repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.divagar.springapp.controller.Employee;
@Repository
public interface EmployeeRepo extends JpaRepository<Employee,Integer>
{
	// @Modifying
	@Query(value="insert into Employee (id,name,role) values (?,?,?)",nativeQuery = true)	
	void AddNewEmployee(int id,String name,String role);
	@Query("select a from Employee a")
	List<Employee> GettAllEmployee();
	@Query("select a from Employee a where a.id=?1")
	Optional<Employee> GettSinlgeEmployee();
}


