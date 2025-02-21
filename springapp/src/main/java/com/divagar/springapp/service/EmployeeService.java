package com.divagar.springapp.service;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.divagar.springapp.Repository.EmployeeRepo;
import com.divagar.springapp.controller.Employee;
@Service
public class EmployeeService {
	@Autowired
	EmployeeRepo obj;

	public Employee AddNewEmployee(Employee a)
	{
		return obj.save(a);
	}

	public List<Employee> GettAllEmployee()
	{
		return obj.findAll();
	}

	public Optional<Employee> GettSinlgeEmployee(int id)
	{
		return obj.findById(id);
	}


	public Employee UpdateSingleEmployee(int id,Employee b)
	{
		return obj.findById(id)
		.map(e->
		{
			if(b.getName() != null)
			{
				e.setName(b.getName());
			}
			if(b.getRole() != null)
			{
				e.setRole(b.getRole());
			}
			return obj.save(e);
		}).orElseThrow(()-> new RuntimeException("The id is not valid"));
	}
	public void DeleteSingleEmployee(int id)
	{
		if(obj.existsById(id))
		{
			obj.deleteById(id);
		}
		else
		{
			throw new RuntimeException( "Id is not found");
		}
	}
	
	public List<Employee> EmployeeSorted(String field)
	{
		Sort sort = Sort.by(Sort.Direction.DESC,field);
		return obj.findAll(sort);
	}

	public List<Employee> EmployeePagination(int pagenumber,int pagesize)
	{
		Pageable page = PageRequest.of(pagenumber, pagesize);
		return obj.findAll(page).getContent();
	}
}
