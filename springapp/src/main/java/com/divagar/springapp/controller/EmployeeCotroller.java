package com.divagar.springapp.controller;

import java.util.List;
import java.util.Optional;

import org.apache.catalina.connector.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
import com.divagar.springapp.controller.Employee;
import com.divagar.springapp.service.EmployeeService;
@RestController
public class EmployeeCotroller 
{
	@Autowired
	EmployeeService obj;
	@PostMapping("/emp/post")
	public ResponseEntity<Employee> addEmployee(@RequestBody Employee a)
	{
		return new ResponseEntity<>(obj.AddNewEmployee(a),HttpStatus.OK);
	}


	@GetMapping("/emp/get")
	public ResponseEntity<List<Employee>> GetEmployee()
	{
		return new ResponseEntity<>(obj.GettAllEmployee(),HttpStatus.OK);
	}


	
	@GetMapping("/emp/get/{id}")
	public ResponseEntity<Employee> GetSingleEmployee(@PathVariable int id)
	{
		Optional<Employee> emp = obj.GettSinlgeEmployee(id);
		if(emp.isPresent())
		{
			return new ResponseEntity<>(emp.get(),HttpStatus.OK);
		}
		else{
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}


	@PutMapping("/emp/put/{id}")
	public ResponseEntity<Employee> UpdateEmployee(@PathVariable int id , @RequestBody Employee b)
	{
		Optional<Employee> emp = obj.GettSinlgeEmployee(id);
		if(emp.isPresent())
		{
			return new ResponseEntity<>(obj.UpdateSingleEmployee(id,b),HttpStatus.OK);
		}
		else
		{
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}


	@DeleteMapping("/emp/delete/{id}")
	public ResponseEntity<Employee> DeleteEmployee(@PathVariable int id) 
	{

		Optional<Employee> emp = obj.GettSinlgeEmployee(id);
		
		if (emp.isPresent()) {
			obj.DeleteSingleEmployee(id);
			return new ResponseEntity<>(emp.get(), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	@GetMapping("/emp/get/sort/{field}")
	public ResponseEntity<List<Employee>> GetSortEmployee(@PathVariable String field)
	{
		return new ResponseEntity<>(obj.EmployeeSorted(field),HttpStatus.OK);
	}

	@GetMapping("/emp/get/{pagenumber}/{pagesize}")
	public ResponseEntity<List<Employee>> GetPageEmployee(@PathVariable int pagenumber,@PathVariable int pagesize)
	{
		return new ResponseEntity<>(obj.EmployeePagination(pagenumber,pagesize),HttpStatus.OK);
	}

}
