package com.exercise.language.service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.exercise.language.entity.ProgramingLanguage;
import com.exercise.language.repository.ProgramingLanguageRepository;

@Service
public class ProgramingLanguageService {
	@Autowired
	private ProgramingLanguageRepository programingLanguageRepository;
	
	public void addDetails(ProgramingLanguage programingLanguage) {
		programingLanguageRepository.save(programingLanguage);
	}
	
	public List<ProgramingLanguage>getAll(){
		List<ProgramingLanguage>programingLanguages=programingLanguageRepository.findAll();
		return programingLanguages;
	}
	
	public Optional<ProgramingLanguage>getById(UUID id){
		Optional<ProgramingLanguage>proOptional=programingLanguageRepository.findById(id);
		return proOptional;
		
	}

}
