package com.app.exercise.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.exercise.entity.Student;
import com.app.exercise.repository.StudentRepository;

@Service
public class StudentService {
	
	@Autowired
	private StudentRepository studentRepository;
	
	public void addDetails(Student student) {
		studentRepository.save(student);
		
	}
	
	public List<Student>getAll(){
		List<Student>students=studentRepository.findAll();
		return students;
	}
	
	public Optional<Student>getById(int id){
		Optional<Student>stOptional=studentRepository.findById(id);
		return stOptional;
		
	}
	
	public void deleteById(int id) {
		studentRepository.deleteById(id);
		
	}

}
