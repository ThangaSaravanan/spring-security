package com.socialMedia.demoApp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.socialMedia.demoApp.entity.Login;

public interface LoginRepository extends JpaRepository<Login, Integer> {

}
