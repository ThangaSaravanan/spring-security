package com.exercise.encryption.controller;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.exercise.encryption.entity.Employee;
import com.exercise.encryption.service.EmployeeService;

@RestController
public class EmployeeController {
	
	@Autowired
	private EmployeeService employeeService;
	
	@PostMapping("/addDetails")
	public String create (@RequestBody Employee employee) {
		employeeService.addDetails(employee);
		return"added";
	}
	
	@GetMapping("/getDetails")
	public List<Employee>get(){
		List<Employee>employees=employeeService.getAll();
		return employees;
	}
	
	@GetMapping("/getOne")
	public Optional<Employee>getOne(@PathVariable ("id") UUID id){
		Optional<Employee>empOptional=employeeService.get(id);
		return empOptional;
	}

}
