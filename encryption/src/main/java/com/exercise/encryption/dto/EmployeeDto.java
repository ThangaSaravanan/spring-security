package com.exercise.encryption.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeDto {
	private int employeeId;
	private String employeeName;
	private String employeeAddress;

}
