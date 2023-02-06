package com.exercise.login.dto;

import java.util.UUID;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDto {
	
	private UUID id;
	private String userName;
	private String userPassword;
	private String phoneNumber;
	private String email;

}
