package com.lab5.bed.ems.services;

import java.util.List;

import com.lab5.bed.ems.model.Employee;

public interface EmployeeServices {

	List<Employee> getAllEmployees();

	Employee getEmployeeById(int empId);

	Employee save(Employee employee);
	
	Employee update(Employee employee);

	void deleteEmployeeById(int empId);
}
