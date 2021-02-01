package com.employee.controller;


import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.employee.model.Employee;
import com.employee.service.EmployeeService;


/**
 * @author Seenivasan Chandrasekaran
 */
@RestController
public class EmployeeController {

	private final Logger logger = LoggerFactory.getLogger(EmployeeController.class);

	@Autowired
	private EmployeeService employeeService;

	@PostMapping("/addEmployee")
	public void addEmployee(Employee employee){
		if(Objects.nonNull(employee.getId())) {
			Employee emp = employeeService.getEmployeebyId(employee.getId());
			if(Objects.isNull(emp.getId())) {
				employeeService.addNewEmployee(employee);
			} else {
				logger.info("Employee Id Already Exists");
			}
		} else {
			logger.info("Enter Employee Id");
		}
	}

	@PutMapping("/updateExistingEmployeeById")
	public void updateExistingEmployeeById(Employee employee){
		if(Objects.nonNull(employee.getId())) {
			Employee emp = employeeService.getEmployeebyId(employee.getId());
			employeeService.maintainExistingValues(employee,emp);
			if(Objects.nonNull(emp)){
				employeeService.updateExistingEmployeeById(employee);
			} else {
				logger.info("Employee does not exists");
			}
		}else {
			logger.info("Please Enter Employee Id");
		}
	}

	@GetMapping("/getAllEmployees")
	public List<Employee> getAllEmployees() {
		List<Employee> employees = new ArrayList<>();
		employees = employeeService.getAllEmployees();
		if(!employees.isEmpty()) {
			logger.info("Values Retrived Successfully");
			return employees;
		}
		return employees;
	}
	  
	@GetMapping("/getEmployeeById")
	public Employee getEmployeeById(@RequestParam("id") String id) {
		Employee employee = employeeService.getEmployeebyId(id);
		return employee;
	}
	  
	@DeleteMapping("/deleteEmployeeById")
	public void deleteEmployeeById(@RequestParam("id") String id){
		if(Objects.nonNull(id)) {
			Employee emp = employeeService.getEmployeebyId(id);
			if(Objects.nonNull(emp.getId())) {
				employeeService.deleteEmployeeById(emp.getId());
			} else {
				logger.info("Please Enter Correct Employee Id");
			}
		} else {
			logger.info("Please Enter Correct Employee Id");
		}
	}

}