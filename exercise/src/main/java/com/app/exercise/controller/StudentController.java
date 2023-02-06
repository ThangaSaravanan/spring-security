package com.app.exercise.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.app.exercise.entity.Student;
import com.app.exercise.service.StudentService;

@RestController
public class StudentController {
	
	@Autowired
	private StudentService studentService;
	
	@PostMapping("/addDetails")
	public String create(@RequestBody Student student) {
		studentService.addDetails(student);
		return"added";
	}
	
	@GetMapping("/getDetails")
	public List<Student>get(){
		List<Student>students=studentService.getAll();
		return students;
	}
	
	@GetMapping("/getOne{id}")
	public Optional<Student>get(@PathVariable ("id")int id){
		Optional<Student>stuOptional=studentService.getById(id);
		return stuOptional;
	}
	
	@PutMapping("/addNew")
	public String createNew(@RequestBody Student student) {
		studentService.addDetails(student);
		return "student";
	}
	
	@DeleteMapping("/deleteOne{id}")
	public String delete(@PathVariable ("id") int id) {
		studentService.deleteById(id);
		return "deleted";
	}
	


}
