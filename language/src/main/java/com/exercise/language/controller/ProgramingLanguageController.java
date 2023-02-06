package com.exercise.language.controller;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.exercise.language.entity.ProgramingLanguage;
import com.exercise.language.service.ProgramingLanguageService;

@RestController
public class ProgramingLanguageController {
	@Autowired
	private ProgramingLanguageService programingLanguageService;
	
	@PostMapping("/addDetails")
	public String create (@RequestBody ProgramingLanguage programingLanguage) {
		programingLanguageService.addDetails(programingLanguage);
		return"added";
	}
	
	@GetMapping("/getDetails")
	public List<ProgramingLanguage>get(){
		List<ProgramingLanguage>programingLanguages=programingLanguageService.getAll();
		return programingLanguages;
	}
	
	@GetMapping("/getOne{id}")
	public Optional<ProgramingLanguage>getOne(@PathVariable ("id")UUID id){
		Optional<ProgramingLanguage>proOptional=programingLanguageService.getById(id);
		return proOptional;
	}

}
