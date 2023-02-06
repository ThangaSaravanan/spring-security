package com.exercise.encryption.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.exercise.encryption.entity.Login;
import com.exercise.encryption.repository.LoginRepository;

@Service
public class LoginService {
	@Autowired
	private LoginRepository loginRepository;
	
	public String save(Login login) {
		login.setAndEncryptPassword(login.getPassword());
		loginRepository.save(login);
		return"success";
	}

}
