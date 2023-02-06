package com.app.sample.dto;

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
	private String password;
	private String phoneNumber;
	private String email;

}
