package com.exercise.encryption.entity;



import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;

import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "login_table")

public class Login {
	
	@Id
	@GeneratedValue(generator = "UUID")
	@GenericGenerator(name = "UUID" , strategy = "org.hibernate.id.UUIDGenerator")
	@Type(type = "UUID-char")
	
	@Column(name = "id",updatable = false,nullable = false)
	private int id;
	
	
	@Column(name = "user_name")
	private String userName;
	
	@Column(name = "password")
	private String password;
	 public void setAndEncryptPassword(String password) {
	        setPassword(Password.getEncryptedPassword(password));
	    }
	

	
}
