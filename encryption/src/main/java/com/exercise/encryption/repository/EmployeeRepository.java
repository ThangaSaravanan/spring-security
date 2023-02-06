package com.exercise.encryption.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.exercise.encryption.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, UUID> {

}
