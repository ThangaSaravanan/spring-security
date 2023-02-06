package com.exercise.login.service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.exercise.login.dto.UserDto;
import com.exercise.login.entity.User;
import com.exercise.login.repository.UserRepository;

@Service
public class UserService {

	@Autowired
	private UserRepository userRepository;
	
	
	public void saveOrUpdate(User userObj) {
		//userObj.setAndEncryptPassword(userObj.getUserPassword());
		userRepository.saveAndFlush(userObj);

	}

	public Optional<User> findByUserName(String userName) {
		// TODO Auto-generated method stub
		return userRepository.findByUserName(userName);
	}

	public Optional<User> findById(UUID id) {
		// TODO Auto-generated method stub
		return userRepository.findById(id);
	}
}
