package com.socialMedia.demoApp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.socialMedia.demoApp.entity.User;

public interface UserRepository extends JpaRepository<User, Integer> {

}
