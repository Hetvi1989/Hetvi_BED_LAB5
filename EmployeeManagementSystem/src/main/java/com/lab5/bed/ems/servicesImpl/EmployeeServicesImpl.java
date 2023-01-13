package com.lab5.bed.ems.servicesImpl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.lab5.bed.ems.model.Employee;
import com.lab5.bed.ems.repository.EmployeeRepository;
import com.lab5.bed.ems.services.EmployeeServices;

@Service
public class EmployeeServicesImpl implements EmployeeServices {

	private final EmployeeRepository employeeRepository;

	public EmployeeServicesImpl(EmployeeRepository repository) {
		this.employeeRepository = repository;
	}

	@Override
	public List<Employee> getAllEmployees() {

		return this.employeeRepository.findAll();
	}

	@Override
	public Employee getEmployeeById(int empId) {

		return this.employeeRepository.findById(empId).get();
	}

	@Override
	public Employee save(Employee employee) {

		return this.employeeRepository.save(employee);
	}

	@Override
	public void deleteEmployeeById(int empId) {
		this.employeeRepository.deleteById(empId);
	}

	@Override
	public Employee update(Employee employee) {
	
		return this.employeeRepository.save(employee);
	}

}
