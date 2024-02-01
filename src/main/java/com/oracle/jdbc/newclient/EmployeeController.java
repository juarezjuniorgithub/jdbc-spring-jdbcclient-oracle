package com.oracle.jdbc.newclient;

import java.util.List;
import java.util.Optional;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EmployeeController {

	private final EmployeeService employeeService;

	public EmployeeController(EmployeeServiceJdbcClient employeeService) {
		this.employeeService = employeeService;
	}

	@GetMapping("/employees")
	List<Employee> findAll() {
		return employeeService.findAll();
	}

	@GetMapping("/employees/{id}")
	Optional<Employee> findById(@PathVariable("id") String id) {
		return employeeService.findById(id);
	}

	@PostMapping("/employees")
	void create(@RequestBody Employee employee) {
		employeeService.create(employee);
	}

	@PutMapping("/employees/{id}")
	void update(@RequestBody Employee employee, @PathVariable("id") String id) {
		employeeService.update(employee, id);
	}

	@DeleteMapping("/employees/{id}")
	void delete(@PathVariable("id") String id) {
		employeeService.delete(id);
	}

}
