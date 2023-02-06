package com.socialMedia.demoApp.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "user")

public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	
	@Column(name = "user_id")
	private int userId;
	

	@Column (name = "user_name")
	private String userName;
	
	@Column (name = "user_dob")
	private String userDob;
	
	@Column(name = "user_address")
	private String userAddress;
}
