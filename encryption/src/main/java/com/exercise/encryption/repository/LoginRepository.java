package com.exercise.encryption.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.exercise.encryption.entity.Login;

public interface LoginRepository extends JpaRepository<Login, UUID>{

}
