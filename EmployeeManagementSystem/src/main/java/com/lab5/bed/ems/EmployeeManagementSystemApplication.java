package com.lab5.bed.ems;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.lab5.bed.ems.model.Employee;
import com.lab5.bed.ems.repository.EmployeeRepository;

@SpringBootApplication
public class EmployeeManagementSystemApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(EmployeeManagementSystemApplication.class, args);
	}
	
	@Autowired
	private EmployeeRepository employeeRepository;
	@Override
	public void run(String... args) throws Exception {
		
		Employee employee1 = new Employee ("Karan", "Patel", "karan.patel@gmail.com");
		employeeRepository.save(employee1);
		
		Employee employee2 = new Employee ("Janki", "Shah", "janki.shah@gmail.com");
		employeeRepository.save(employee2);
		
		Employee employee3 = new Employee ("Himani", "Mehta", "himani.mehta@gmail.com");
		employeeRepository.save(employee3);
		
		Employee employee4 = new Employee ("Parth", "Prajapati", "parth.prajapati@gmail.com");
		employeeRepository.save(employee4);
		
		Employee employee5 = new Employee ("Tushar", "Gor", "tushar.gor@gmail.com");
		employeeRepository.save(employee5);
		
	}

}
