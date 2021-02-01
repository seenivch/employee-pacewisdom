package com.employee.service;



import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.employee.model.Employee;
import com.employee.repository.EmployeeJpaRepository;

/**
 * @author Seenivasan Chandrasekaran
 */

@Service
public class EmployeeServiceImpl implements EmployeeService {

    private final Logger logger = LoggerFactory.getLogger(EmployeeServiceImpl.class);
    
    @Autowired
    private EmployeeJpaRepository employeeJpaRepository;

	@Override
	public void addNewEmployee(Employee employee) {
		
		if(Objects.nonNull(employee)&& Objects.nonNull(employee.getId())&& Objects.nonNull(employee.getFirstName())
			&&Objects.nonNull(employee.getLastName())&&Objects.nonNull(employee.getEmailId())&&Objects.nonNull(employee.getGender())
			&&Objects.nonNull(employee.getAge())&&Objects.nonNull(employee.getAddress())) {
			employeeJpaRepository.save(employee);
			logger.info("Data Inserted Successfully");
		} else {
			logger.info("Please Enter the values for all fields based on entity");
		}
	}

	@Override
	public void updateExistingEmployeeById(Employee employee) {
		employeeJpaRepository.save(employee);
		logger.info("Data Updated Successfully");
	}
	
	@Override
	public Employee getEmployeebyId(String employeeId) {
		Employee employee = new Employee();
		if(Objects.nonNull(employeeId)) {
			Optional<Employee> optEmp = employeeJpaRepository.findById(employeeId);
			if(!optEmp.isEmpty()) {
				return optEmp.get();
			}
		}
		return employee;
	}

	@Override
	public void maintainExistingValues(Employee employee, Employee emp) {
		if(Objects.isNull(employee.getFirstName())){
			employee.setFirstName(emp.getFirstName());
		}
		if(Objects.isNull(employee.getLastName())){
			employee.setLastName(emp.getLastName());
		}
		if(Objects.isNull(employee.getEmailId())){
			employee.setEmailId(emp.getEmailId());
		}
		if(Objects.isNull(employee.getAge())){
			employee.setAge(emp.getAge());
		}
		if(Objects.isNull(employee.getGender())){
			employee.setGender(emp.getGender());
		}
		if(Objects.isNull(employee.getAddress())){
			employee.setAddress(emp.getAddress());
		}
	}

	@Override
	public void deleteEmployeeById(String employeeId) {
		employeeJpaRepository.deleteById(employeeId);	
		logger.info("Data Deleted Successfully");
	}

	@Override
	public List<Employee> getAllEmployees() {
		List<Employee> allEmployees = new ArrayList<>();
		Iterable<Employee> allValues = employeeJpaRepository.findAll();
		if(Objects.nonNull(allValues)) {
			allValues.iterator().forEachRemaining(allEmployees::add);
		} else {
			logger.info("No Value in DB");
		}
		return allEmployees;
	}
}
