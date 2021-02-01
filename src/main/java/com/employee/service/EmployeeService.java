package com.employee.service;

import java.util.List;
import com.employee.model.Employee;

/**
 * @author Seenivasan Chandrasekaran
 */

public interface EmployeeService {

	public void addNewEmployee(Employee employee);
	
    public List<Employee> getAllEmployees();
	
	public Employee getEmployeebyId(String employeeId);
	
    public void updateExistingEmployeeById(Employee employee);

    public void deleteEmployeeById(String employeeId);

	public void maintainExistingValues(Employee employee, Employee emp);

     
}
