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
@Table(name = "login")
public class Login {
	
	@Id
	@GeneratedValue(strategy =GenerationType.AUTO )
	
	@Column(name = "login_id")
	private int loginId;
	
	@Column (name = "user_name")
	private String userName;
	
	@Column (name = "password")
	private int password;

}
