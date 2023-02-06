package com.exercise.encryption.service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.exercise.encryption.entity.Employee;
import com.exercise.encryption.repository.EmployeeRepository;

@Service
public class EmployeeService {
	
	@Autowired
	private EmployeeRepository employeeRepository;
	
	public void addDetails(Employee employee){
		employeeRepository.save(employee);
	}
	
	public List<Employee>getAll(){
		List<Employee>employees=employeeRepository.findAll();
		return employees;
	}
	
	public Optional<Employee>get(UUID id){
		Optional<Employee>empOptional=employeeRepository.findById(id);
	   return empOptional;
	}

}
