package com.Ksotis.EmployeeApp;

import java.util.List;

public interface IEmployeeDAO {

	void addEmployee(Employee employee);
	void changeFirstName(int id, String firstName);
	void deleteEmployee(int id);
	public Employee getEmployeeById(int id);
	public List<Employee> getAllEmployees();
	
}
