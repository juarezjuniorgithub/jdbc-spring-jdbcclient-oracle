/*
  Copyright (c) 2024, Oracle and/or its affiliates.

  This software is dual-licensed to you under the Universal Permissive License
  (UPL) 1.0 as shown at https://oss.oracle.com/licenses/upl or Apache License
  2.0 as shown at http://www.apache.org/licenses/LICENSE-2.0. You may choose
  either license.

  Licensed under the Apache License, Version 2.0 (the "License");
  you may not use this file except in compliance with the License.
  You may obtain a copy of the License at

     https://www.apache.org/licenses/LICENSE-2.0

  Unless required by applicable law or agreed to in writing, software
  distributed under the License is distributed on an "AS IS" BASIS,
  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
  See the License for the specific language governing permissions and
  limitations under the License.
*/

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
