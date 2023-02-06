package com.app.sample.entity;

import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;

import com.app.sample.util.PasswordUtil;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "user_sample")

public class User {
	
	@Id
	@GeneratedValue(generator = "UUID")
	@GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
	@Type(type = "uuid-char")
	@Column(name = "user_id", updatable = false, nullable = false)
	private UUID id;
	
	@Column(name = "user_name")
	private String userName;
	
	@Column(name = "phone_no")
	private String phoneNumber;
	
	@Column(name = "email")
	private String email;
	
	@Column(name = "password")
	private String password;

	public void setAndEncryptPassword(String password) {
		setPassword(PasswordUtil.getEncryptedPassword(password));
	}
}