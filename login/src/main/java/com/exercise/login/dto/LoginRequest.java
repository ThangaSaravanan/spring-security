package com.exercise.login.dto;

import java.io.Serializable;

public class LoginRequest implements Serializable {
	
private static final long serialVersionUID = 1L;
	
	private String userName;
	private String userPassword;
	
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getUserPassword() {
		return userPassword;
	}
	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}
	
	
}