package com.divagar.springapp.controller;

import org.springframework.beans.factory.annotation.Autowired;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;
import jakarta.persistence.UniqueConstraint;

@Entity
@Table(name="Employee")
public class Employee {
	@Autowired
	@Column(name = "Emp_id")
	@Id
	// @GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Column(name = "Emp_name")
	// @Transient
	private String name;
	@Column(name = "Emp_role")
	// @JsonIgnore
	private String role;
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
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public Employee(int id, String name, String role) {
		this.id = id;
		this.name = name;
		this.role = role;
	}
	public Employee() {
	}
	
}
