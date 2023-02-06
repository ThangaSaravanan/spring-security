package com.exercise.login.repository;

import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.exercise.login.dto.UserDto;
import com.exercise.login.entity.User;

public interface UserRepository extends JpaRepository<User, UUID> {
	
	void saveAndFlush(UserDto userDto);
	
	
	Optional<User> findByUserName(String userName);


}
