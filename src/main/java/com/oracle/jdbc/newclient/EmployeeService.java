package com.oracle.jdbc.newclient;

import java.util.List;
import java.util.Optional;

public interface EmployeeService {

	void create(Employee employee);

	List<Employee> findAll();

	Optional<Employee> findById(String id);

	void update(Employee employee, String id);

	void delete(String id);

}
