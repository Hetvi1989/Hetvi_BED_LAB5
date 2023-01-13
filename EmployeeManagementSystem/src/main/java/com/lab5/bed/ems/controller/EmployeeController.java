package com.lab5.bed.ems.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.lab5.bed.ems.model.Employee;
import com.lab5.bed.ems.services.EmployeeServices;

@Controller
public class EmployeeController {

	private final EmployeeServices employeeServices;

	public EmployeeController(EmployeeServices employeeServices) {
		this.employeeServices = employeeServices;
	}

	@GetMapping("/employee")
	public String listEmployee(Model model) {
		model.addAttribute("employees", employeeServices.getAllEmployees());
		return "Employees/list-employees";
	}

	@GetMapping("/addEmployee")
	public String addEmployeeForm(Model model) {
		Employee employee = new Employee();
		model.addAttribute("employees", employee);
		return "Employees/add-employees";
	}

	@PostMapping("/employee")
	public String saveEmployee(@ModelAttribute("employees") Employee employee) {
		employeeServices.save(employee);
		return "redirect:/employee";
	}

	@GetMapping("/employee/update/{id}")
	public String updateEmployeeForm(@PathVariable int id, Model model) {
		model.addAttribute("employees", employeeServices.getEmployeeById(id));
		return "Employees/update-employees";
	}

	@PostMapping("/employee/{id}")
	public String update(@PathVariable int id, @ModelAttribute("employees") Employee employee, Model model) {

		Employee existingEmployee = employeeServices.getEmployeeById(id);
		existingEmployee.setId(id);
		existingEmployee.setFirstName(employee.getFirstName());
		existingEmployee.setLastName(employee.getLastName());
		existingEmployee.setEmail(employee.getEmail());

		employeeServices.update(existingEmployee);
		return "redirect:/employee";

	} 
	@GetMapping("/employee/{id}")
	public String deleteEmployee(@PathVariable int id) {
		employeeServices.deleteEmployeeById(id);
		return "redirect:/employee";
	}

}
