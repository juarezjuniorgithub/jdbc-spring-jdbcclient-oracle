package com.oracle.jdbc.newclient;

public enum EmployeeSqlStatements {

	FIND_ALL_EMPLOYEES("SELECT * FROM employee"), FIND_EMPLOYEE_BY_ID("SELECT * FROM employee WHERE id = :id"),
	CREATE_NEW_EMPLOYEE("INSERT INTO employee (id, name, role, salary, commission) values(?,?,?,?,?)"),
	UPDATE_EMPLOYEE("UPDATE employee SET name = ?, role = ?, salary = ?, commission = ? WHERE id = ?"),
	DELETE_EMPLOYEE("DELETE FROM employee WHERE id = :id"), ID("id");

	private final String sqlStatement;

	private EmployeeSqlStatements(String sqlStatement) {
		this.sqlStatement = sqlStatement;

	}

	public String statement() {
		return sqlStatement;
	}

}
