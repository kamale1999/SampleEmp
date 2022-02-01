package com.org.emp;

import java.util.List;



public interface EmployeeService {
	List<Employee> getAllEmployees();
	
	Employee saveEmployee(Employee Employee);
	
	Employee getEmployeeById(Integer id);
	
	Employee updateEmployee(Employee Employee);
	
	void deleteEmployeeById(Integer id);
}
