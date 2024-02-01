package com.oracle.jdbc.newclient;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jdbc.core.simple.JdbcClient;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;

@Service
@Transactional
public class EmployeeServiceJdbcClient implements EmployeeService {

	private final JdbcClient jdbcClient;
	private static final Logger log = LoggerFactory.getLogger(EmployeeServiceJdbcClient.class);

	public EmployeeServiceJdbcClient(JdbcClient jdbcClient) {
		this.jdbcClient = jdbcClient;
	}

	public List<Employee> findAll() {
		return jdbcClient.sql(EmployeeSqlStatements.FIND_ALL_EMPLOYEES.statement()).query(Employee.class).list();
	}

	@Override
	public Optional<Employee> findById(String id) {
		return jdbcClient.sql(EmployeeSqlStatements.FIND_EMPLOYEE_BY_ID.statement())
				.param(EmployeeSqlStatements.ID.statement(), id).query(Employee.class).optional();
	}

	@Override
	public void create(Employee employee) {
		var updated = jdbcClient.sql(EmployeeSqlStatements.CREATE_NEW_EMPLOYEE.statement())

				.params(List.of(employee.id(), employee.name(), employee.role(), employee.salary(),
						employee.commission()))
				.update();
		log.info("New Employee Created: " + employee.name());
		Assert.state(updated == 1L, EmployeeMessages.EMPLOYEE_CREATION_FAILED.getMessage() + employee.name());
	}

	@Override
	public void update(Employee employee, String id) {
		var updated = jdbcClient.sql(EmployeeSqlStatements.UPDATE_EMPLOYEE.statement())
				.params(List.of(employee.name(), employee.role(), employee.salary(), employee.commission(), id))
				.update();
		log.info("Employee Updated: " + employee.name());
		Assert.state(updated == 1L, EmployeeMessages.EMPLOYEE_UPDATE_FAILED.getMessage() + employee.name());
	}

	@Override
	public void delete(String id) {
		var updated = jdbcClient.sql(EmployeeSqlStatements.DELETE_EMPLOYEE.statement()).param(id, id).update();
		log.info("Employee Deleted: " + id);
		Assert.state(updated == 1L, EmployeeMessages.EMPLOYEE_DELETION_FAILED.getMessage() + id);
	}
}
